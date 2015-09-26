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
public class AttendanceFragment extends Fragment{

    public static final String ATTENDANCE_ARG = "attendance_arg";

    public AttendanceFragment(){
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.attendance, container, false);

        ArrayList<AttendanceItem> volunteers = (ArrayList<AttendanceItem>)getArguments().getSerializable(ATTENDANCE_ARG);
        AttendanceAdapter adapter = new AttendanceAdapter(getContext(), volunteers);

        ListView newsList = (ListView)rootView.findViewById(R.id.attendance_list);
        newsList.setAdapter(adapter);
        newsList.setEmptyView(rootView.findViewById(R.id.empty_attendance_list));

        return rootView;
    }

}
