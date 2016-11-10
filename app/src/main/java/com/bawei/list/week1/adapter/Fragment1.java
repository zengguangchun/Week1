    package com.bawei.list.week1.adapter;

    import android.os.Bundle;
    import android.os.Handler;
    import android.os.Message;
    import android.support.annotation.Nullable;
    import android.support.v4.app.Fragment;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    import com.bawei.list.week1.R;
    import com.bawei.list.week1.xlistview.XListView;
    import com.google.gson.Gson;
    import com.lidroid.xutils.HttpUtils;
    import com.lidroid.xutils.exception.HttpException;
    import com.lidroid.xutils.http.ResponseInfo;
    import com.lidroid.xutils.http.callback.RequestCallBack;
    import com.lidroid.xutils.http.client.HttpRequest;

    import org.json.JSONObject;

    import java.io.IOException;
    import java.util.ArrayList;

    import okhttp3.Call;
    import okhttp3.Callback;
    import okhttp3.OkHttpClient;
    import okhttp3.Request;
    import okhttp3.Response;

    /**
     * Created by asus on 2016/11/7.
     */
    public class Fragment1 extends Fragment {

        private XListView listView;
        private  LV_Adapter adapter;
        private String path = "http://japi.juhe.cn/joke/content/list.from?key=%20874ed931559ba07aade103eee279bb37%20&page=1&pagesize=10&sort=asc&time=1418745237";
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                ArrayList<DataBean.Result.Data> data = (ArrayList<DataBean.Result.Data>) msg.obj;
                adapter =   new LV_Adapter(getActivity(), data);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = View.inflate(getContext(), R.layout.fragment1, null);
            listView = (XListView) view.findViewById(R.id.lv_s);

            listView.setPullLoadEnable(true);
            listView.setXListViewListener(new XListView.IXListViewListener() {

                @Override
                public void onRefresh() {
                    stopXlistView();

                }

                @Override
                public void onLoadMore() {
                    stopXlistView();

                }
            });
            //解析数据(xUtils)
            //intixUtils();
            //解析数据(okHttp)
            initokHttp();
            //解析数据（原生态解析）
            //ititJson();
            return view;
        }

        private void stopXlistView() {
            listView.setRefreshTime("每一刻都是新的开始");

            listView.stopLoadMore();
            listView.stopRefresh();
        }

        private void ititJson() {
            JSONObject object = new JSONObject();

        }

        private void initokHttp() {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(path).build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
System.out.print("数据加载失败。。。。。。。。。。。。。。。。。。。。。");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String json = response.body().string();
                    Gson gson = new Gson();
                    DataBean db = gson.fromJson(json, DataBean.class);
                    ArrayList<DataBean.Result.Data> data = db.result.data;
                    Message message = new Message();
                    message.obj = data;
                    handler.sendMessage(message);


                }
            });

        }

        private void intixUtils() {
            HttpUtils httpUtils = new HttpUtils();
            httpUtils.send(HttpRequest.HttpMethod.GET, path, new RequestCallBack<String>() {


                // 获取数据失败
                @Override
                public void onFailure(HttpException arg0, String arg1) {
                    // TODO Auto-generated method stub
    //tt.setText("数据加载失败。。。。。。。。。。。。。");
                    System.out.println("数据加载失败。。。。。。。。。。。。。");
                }

                // 获取数据成功
                @Override
                public void onSuccess(ResponseInfo<String> arg0) {
                    String json = arg0.result;
                    Gson gson = new Gson();
                    DataBean db = gson.fromJson(json, DataBean.class);
                    ArrayList<DataBean.Result.Data> data = db.result.data;
                    LV_Adapter adapter = new LV_Adapter(getActivity(), data);
                    listView.setAdapter(adapter);


                }

            });
        }


    }
