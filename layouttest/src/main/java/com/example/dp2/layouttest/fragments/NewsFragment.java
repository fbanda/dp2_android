package com.example.dp2.layouttest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dp2.layouttest.R;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.DocumentsAdapter;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.DocumentsItem;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.NewsAdapter;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.NewsItem;

import java.util.ArrayList;

/**
 * Created by Fernando on 23/09/2015.
 */
public class NewsFragment extends Fragment{

    public static final String NEWS_ARG = "news_arg";

    public NewsFragment(){
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.news, container, false);

        ArrayList<NewsItem> news = (ArrayList<NewsItem>)getArguments().getSerializable(NEWS_ARG);
        NewsAdapter adapter = new NewsAdapter(getContext(), news);

        ListView newsList = (ListView)rootView.findViewById(R.id.news_list);
        newsList.setAdapter(adapter);
        newsList.setEmptyView(rootView.findViewById(R.id.empty_news_list));

        return rootView;
    }

}
