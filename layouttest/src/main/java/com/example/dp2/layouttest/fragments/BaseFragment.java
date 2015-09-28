package com.example.dp2.layouttest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dp2.layouttest.DetailActivity;

/**
 * Created by Fernando on 25/09/2015.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(getLayout(), container, false);
        prepareView(rootView, getArguments(), savedInstanceState);
        return rootView;
    }

    public abstract int getLayout();

    public void prepareView(View rootView, Bundle args, Bundle savedInstanceState){

    }

    public void setImage(ImageView v, String URL, String fileName){
        ((DetailActivity)getContext()).setImage(v, URL, fileName);
    }

    public void addFragmentToStack(Fragment fragment, int fragmentId){
        DetailActivity activity = ((DetailActivity) getContext());
        activity.addFragment(fragment, activity.getTitle(fragmentId), activity.getMenu(fragmentId));
    }

}