package com.bawei.list.week1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawei.list.week1.R;

import java.util.ArrayList;

/**
 * Created by asus on 2016/11/7.
 */
public class LV_Adapter extends BaseAdapter {
    private Context context;
private ArrayList<DataBean.Result.Data> data;
    public  LV_Adapter(Context context,ArrayList<DataBean.Result.Data> data){
super();
        this.context =context;
        this.data =data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = View.inflate(context, R.layout.list_itenm,null);
        TextView tv1 = (TextView)view1.findViewById(R.id.tv_tite);
        TextView tv2 = (TextView)view1.findViewById(R.id.tv_t);
        tv1.setText(data.get(i).content);
        tv2.setText(data.get(i).updatetime);
        return view1;
    }
}
