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
import java.util.List;

/**
 * Created by Fernando on 23/09/2015.
 */
public class DocumentsFragment extends Fragment{

    public static final String DOCUMENTS_ARG = "docs_arg";

    public DocumentsFragment(){
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.documents, container, false);

        ArrayList<DocumentsItem> documents = (ArrayList<DocumentsItem>)getArguments().getSerializable(DOCUMENTS_ARG);
        DocumentsAdapter adapter = new DocumentsAdapter(getContext(), documents);

        ListView docsList = (ListView)rootView.findViewById(R.id.docs_list);
        docsList.setAdapter(adapter);
        docsList.setEmptyView(rootView.findViewById(R.id.empty_docs_list));

        return rootView;
    }

}
