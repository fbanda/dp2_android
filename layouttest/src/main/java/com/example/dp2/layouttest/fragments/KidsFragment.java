package com.example.dp2.layouttest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dp2.layouttest.R;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.KidItem;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.KidAdapter;

import java.util.ArrayList;

/**
 * Created by Fernando on 23/09/2015.
 */
public class KidsFragment extends Fragment{

    public static final String KIDS_ARG = "kids_arg";

    public KidsFragment(){
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.kids, container, false);

        ArrayList<KidItem> kids = (ArrayList<KidItem>)getArguments().getSerializable(KIDS_ARG);
        KidAdapter adapter = new KidAdapter(getContext(), kids);

        ListView newsList = (ListView)rootView.findViewById(R.id.kids_list);
        newsList.setAdapter(adapter);
        newsList.setEmptyView(rootView.findViewById(R.id.empty_kids_list));

        return rootView;
    }

}
