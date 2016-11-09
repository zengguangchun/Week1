package com.bawei.list.week1.com.bawei.list.week1.adpter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.list.week1.R;

/**
 * Created by asus on 2016/11/7.
 */
public class Fragment4 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment4,null);
        return view;
    }
}
