package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dp2.layouttest.R;

import java.util.List;

public class KidAdapter extends ArrayAdapter<KidItem> {

    public static final int FILTER_COLOR = 0xff7fb2d6;

    public KidAdapter(Context context, List<KidItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.kid_list_item, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.kids_item_name);
        TextView age = (TextView) convertView.findViewById(R.id.kids_item_date);
        ImageView menu = (ImageView) convertView.findViewById(R.id.kids_item_menu);

        KidItem item = getItem(position);
        name.setText(item.getName());
        age.setText(convertView.getResources().getString(R.string.kids_age, item.getAge()));
        menu.setImageResource(item.isWritten() ? android.R.drawable.checkbox_on_background : android.R.drawable.checkbox_off_background);
/*
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.kids_item_menu) {
                    PopupMenu popup = new PopupMenu(getContext(), v);
                    popup.getMenuInflater().inflate(R.menu.docs_menu_afi, popup.getMenu());
                    popup.show();
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.docs_menu_view:
                                    Toast.makeText(getContext(), "Ver documento...", Toast.LENGTH_LONG).show();
                                    break;
                                case R.id.docs_menu_download:
                                    Toast.makeText(getContext(), "Descargar documento...", Toast.LENGTH_LONG).show();
                                    break;
                                case R.id.docs_menu_check_views:
                                    Toast.makeText(getContext(), "Revisar vistas...", Toast.LENGTH_LONG).show();
                                    break;
                            }
                            return true;
                        }
                    });
                }
            }
        });
*/
        return convertView;
    }
}
