package com.example.dp2.layouttest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dp2.layouttest.R;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.AttendanceAdapter;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.AttendanceItem;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.NewsAdapter;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.NewsItem;

import java.util.ArrayList;

/**
 * Created by Fernando on 23/09/2015.
 */
public class AttendanceFragment extends BaseFragment{

    public static final String ATTENDANCE_ARG = "attendance_arg";

    public AttendanceFragment(){
        super();
    }

    @Override
    public int getLayout(){
        return R.layout.attendance;
    }

    @Override
    public void prepareView(View rootView, Bundle args, Bundle savedInstanceState){
        ArrayList<AttendanceItem> volunteers = (ArrayList<AttendanceItem>)args.getSerializable(ATTENDANCE_ARG);
        AttendanceAdapter adapter = new AttendanceAdapter(getContext(), this, volunteers);

        ListView newsList = (ListView)rootView.findViewById(R.id.attendance_list);
        newsList.setAdapter(adapter);
        newsList.setEmptyView(rootView.findViewById(R.id.empty_attendance_list));
    }

}
