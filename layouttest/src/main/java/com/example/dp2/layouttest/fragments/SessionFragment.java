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
public class SessionFragment extends BaseFragment{

    public static final String SESSION_ARG = "session_arg";

    public SessionFragment(){
        super();
    }

    @Override
    public int getLayout(){
        return R.layout.sessions;
    }

    @Override
    public void prepareView(View rootView, Bundle args, Bundle savedInstanceState){
        ArrayList<SessionItem> sessions = (ArrayList<SessionItem>)args.getSerializable(SESSION_ARG);
        SessionAdapter adapter = new SessionAdapter(getContext(), this, sessions);

        ListView newsList = (ListView)rootView.findViewById(R.id.sessions_list);
        newsList.setAdapter(adapter);
        newsList.setEmptyView(rootView.findViewById(R.id.empty_sessions_list));
    }

}
