package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dp2.layouttest.R;

import java.util.List;

public class DrawerAdapter extends ArrayAdapter<DrawerItem> {

    public DrawerAdapter(Context context, List<DrawerItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_list_item, null);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.list_item_icon);
        TextView name = (TextView) convertView.findViewById(R.id.list_item_name);

        DrawerItem item = getItem(position);
        icon.setImageResource(item.getIconId());
        name.setText(item.getName());

        return convertView;
    }
}
