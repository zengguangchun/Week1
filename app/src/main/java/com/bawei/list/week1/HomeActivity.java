package com.bawei.list.week1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.bawei.list.week1.adapter.FragmentAdapter;

import java.util.ArrayList;

public class HomeActivity extends FragmentActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private ViewPager vp;
    private ArrayList<TextView> listtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //初始化控件
        findByID();
        //设配器
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i = 0; i < listtv.size(); i++) {
                    if (i == position) {
                        listtv.get(i).setTextColor(Color.GREEN);
                    } else {
                        listtv.get(i).setTextColor(Color.BLACK);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //遍历
        for (TextView tv:listtv){
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.tv1:
                            vp.setCurrentItem(0);
                            break;
                        case R.id.tv2:
                            vp.setCurrentItem(1);
                            break;
                        case R.id.tv3:
                            vp.setCurrentItem(2);
                            break;
                        case R.id.tv4:
                            vp.setCurrentItem(3);
                            break;
                    }
                }
            });
        }
    }

    private void findByID() {
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        vp = (ViewPager)findViewById(R.id.vp);
        listtv = new ArrayList<TextView>();
        listtv.add(tv1);
        listtv.add(tv2);
        listtv.add(tv3);
        listtv.add(tv4);
    }
}
