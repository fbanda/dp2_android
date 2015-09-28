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
public class NewsFragment extends BaseFragment{

    public static final String NEWS_ARG = "news_arg";

    private boolean[] isFavorite;

    public NewsFragment(){
        super();
    }

    @Override
    public int getLayout(){
        return R.layout.news;
    }

    @Override
    public void prepareView(View rootView, Bundle args, Bundle savedInstanceState){
        ArrayList<NewsItem> news = (ArrayList<NewsItem>)args.getSerializable(NEWS_ARG);
        NewsAdapter adapter = new NewsAdapter(getContext(), this, news);

        ListView newsList = (ListView)rootView.findViewById(R.id.news_list);
        newsList.setAdapter(adapter);
        newsList.setEmptyView(rootView.findViewById(R.id.empty_news_list));

        isFavorite = new boolean[news.size()];
        for(int i=0; i<isFavorite.length; i++){
            isFavorite[i] = news.get(i).isFavorite();
        }
    }

    public boolean toggleFavorite(int position){
        isFavorite[position] = !isFavorite[position];
        return isFavorite[position];
    }

}
