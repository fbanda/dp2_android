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
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.SessionAdapter;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.SessionItem;

import java.util.ArrayList;

/**
 * Created by Fernando on 23/09/2015.
 */
public class SessionFragment extends Fragment{

    public static final String SESSION_ARG = "session_arg";

    public SessionFragment(){
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.sessions, container, false);

        ArrayList<SessionItem> sessions = (ArrayList<SessionItem>)getArguments().getSerializable(SESSION_ARG);
        SessionAdapter adapter = new SessionAdapter(getContext(), sessions);

        ListView newsList = (ListView)rootView.findViewById(R.id.sessions_list);
        newsList.setAdapter(adapter);
        newsList.setEmptyView(rootView.findViewById(R.id.empty_sessions_list));

        return rootView;
    }

}
