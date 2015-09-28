package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dp2.layouttest.R;
import com.example.dp2.layouttest.fragments.BaseFragment;

import java.util.List;

public class KidAdapter extends BaseArrayAdapter<KidItem> {

    public static final int FILTER_COLOR = 0xff7fb2d6;

    public KidAdapter(Context context, BaseFragment fragment, List<KidItem> objects) {
        super(context, fragment, R.layout.kid_list_item, objects);
    }

    @Override
    public void prepareItemView(View convertView, KidItem item, int position) {
        TextView name = (TextView) convertView.findViewById(R.id.kids_item_name);
        TextView age = (TextView) convertView.findViewById(R.id.kids_item_date);
        ImageView menu = (ImageView) convertView.findViewById(R.id.kids_item_menu);

        name.setText(item.getName());
        age.setText(convertView.getResources().getString(R.string.kids_age, item.getAge()));
        menu.setImageResource(item.isWritten() ? android.R.drawable.checkbox_on_background : android.R.drawable.checkbox_off_background);
    }
}
