package com.bawei.list.week1.adapter;

import java.util.ArrayList;

/**
 * Created by asus on 2016/11/7.
 */
public class DataBean {
    public Result result;
   public class Result{
       public ArrayList<Data> data;
       public class Data{
           public String content;
           public String updatetime;
       }
   }

}
