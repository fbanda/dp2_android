package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dp2.layouttest.R;
import com.example.dp2.layouttest.fragments.BaseFragment;

import java.util.List;

public class DrawerAdapter extends BaseArrayAdapter<DrawerItem> {

    public DrawerAdapter(Context context, List<DrawerItem> objects) {
        super(context, null, R.layout.drawer_list_item, objects);
    }

    @Override
    public void prepareItemView(View convertView, DrawerItem item, int position) {
        ImageView icon = (ImageView) convertView.findViewById(R.id.drawer_list_item_icon);
        TextView name = (TextView) convertView.findViewById(R.id.drawer_list_item_name);

        icon.setImageResource(item.getIconId());
        name.setText(item.getName());
    }
}
