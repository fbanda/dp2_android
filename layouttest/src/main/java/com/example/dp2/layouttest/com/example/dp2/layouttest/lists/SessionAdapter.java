package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dp2.layouttest.R;

import java.util.List;

public class SessionAdapter extends ArrayAdapter<SessionItem> {

    public static final int FILTER_COLOR = 0xff7fb2d6;

    public SessionAdapter(Context context, List<SessionItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.session_list_item, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.sessions_item_name);
        TextView date = (TextView) convertView.findViewById(R.id.sessions_item_date);
        ImageView menu = (ImageView) convertView.findViewById(R.id.sessions_item_menu);
        int color;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            color = convertView.getResources().getColor(R.color.toolbar_background, null);
        }else{
            color = convertView.getResources().getColor(R.color.toolbar_background);
        }
        menu.setColorFilter(color);

        SessionItem item = getItem(position);
        name.setText(item.getName());
        CharSequence formattedDate = DateUtils.getRelativeDateTimeString(getContext(), item.getDate(),
                DateUtils.MINUTE_IN_MILLIS, DateUtils.YEAR_IN_MILLIS, DateUtils.FORMAT_ABBREV_MONTH);
        date.setText(formattedDate);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.sessions_item_menu) {
                    PopupMenu popup = new PopupMenu(getContext(), v);
                    popup.getMenuInflater().inflate(R.menu.sessions_menu_afi, popup.getMenu());
                    popup.show();
                }
            }
        });

        return convertView;
    }
}
