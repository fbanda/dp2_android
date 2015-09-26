package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.dp2.layouttest.DetailActivity;
import com.example.dp2.layouttest.R;

import java.util.List;

public class AttendanceAdapter extends ArrayAdapter<AttendanceItem> {

    public AttendanceAdapter(Context context, List<AttendanceItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("imgs", "getView called for: " + position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.attendance_list_item, null);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.attendance_item_icon);
        TextView name = (TextView) convertView.findViewById(R.id.attendance_item_name);

        AttendanceItem item = getItem(position);
        setImage(icon, item.getPicURL(), "news_author_" + item.getPicId() + ".png");
        name.setText(item.getName());

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            Switch switc = (Switch) convertView.findViewById(R.id.attendance_item_toggle);
            switc.setChecked(item.isToggleOn());
        }
        return convertView;
    }

    private void setImage(ImageView v, String URL, String title){
        ((DetailActivity)getContext()).setImage(v, URL, title);
    }
}
