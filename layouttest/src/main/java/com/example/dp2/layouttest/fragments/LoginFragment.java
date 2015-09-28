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

import java.util.ArrayList;

/**
 * Created by Fernando on 23/09/2015.
 */
public class LoginFragment extends BaseFragment{

    public LoginFragment(){
        super();
    }

    @Override
    public int getLayout(){
        return R.layout.login;
    }

}
