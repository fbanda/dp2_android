package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
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

import com.example.dp2.layouttest.DetailActivity;
import com.example.dp2.layouttest.R;
import com.example.dp2.layouttest.fragments.AttendanceFragment;
import com.example.dp2.layouttest.fragments.BaseFragment;
import com.example.dp2.layouttest.fragments.KidsFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionAdapter extends BaseArrayAdapter<SessionItem> {

    public static final int FILTER_COLOR = 0xff7fb2d6;

    public SessionAdapter(Context context, BaseFragment fragment, List<SessionItem> objects) {
        super(context, fragment, R.layout.session_list_item, objects);
    }

    @Override
    public void prepareItemView(View convertView, SessionItem item, int position) {
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
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch(item.getItemId()){
                                case R.id.sessions_menu_comment:
                                    Bundle args = new Bundle();
                                    ArrayList<KidItem> kids = new ArrayList<>();
                                    kids.add(new KidItem("Eduardo Arenas", 12, true));
                                    kids.add(new KidItem("Julio Castillo", 12, false));
                                    kids.add(new KidItem("Juan Reyes", 12, true));
                                    kids.add(new KidItem("Kevin Brown", 12, true));
                                    kids.add(new KidItem("Robert Aduviri", 12, false));
                                    Collections.sort(kids);
                                    args.putSerializable(KidsFragment.KIDS_ARG, kids);
                                    KidsFragment kidsFragment = new KidsFragment();
                                    kidsFragment.setArguments(args);
                                    getFragment().addFragmentToStack(kidsFragment, DetailActivity.FRAGMENT_COMENTARIOS);
                                    break;
                                case R.id.sessions_menu_attendance:
                                    args = new Bundle();
                                    ArrayList<AttendanceItem> volunteers = new ArrayList<>();
                                    volunteers.add(new AttendanceItem(
                                            2001,
                                            "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                                            "Alonso Alvarez", false));
                                    volunteers.add(new AttendanceItem(
                                            2001,
                                            "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                                            "Fernando Banda", false));
                                    volunteers.add(new AttendanceItem(
                                            2001,
                                            "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                                            "Luis Barcena", false));
                                    volunteers.add(new AttendanceItem(
                                            2001,
                                            "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                                            "Daekef Abarca", false));
                                    volunteers.add(new AttendanceItem(
                                            2001,
                                            "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                                            "Gloria Cisneros", false));
                                    volunteers.add(new AttendanceItem(
                                            2001,
                                            "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                                            "Diego Malpartida", false));
                                    volunteers.add(new AttendanceItem(
                                            2001,
                                            "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                                            "Gabriel Tovar", false));
                                    volunteers.add(new AttendanceItem(
                                            2001,
                                            "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                                            "Luis Incio", false));
                                    Collections.sort(volunteers);
                                    args.putSerializable(AttendanceFragment.ATTENDANCE_ARG, volunteers);
                                    AttendanceFragment attendanceFragment = new AttendanceFragment();
                                    attendanceFragment.setArguments(args);
                                    getFragment().addFragmentToStack(attendanceFragment, DetailActivity.FRAGMENT_ASISTENCIA);
                                    break;
                            }
                            return true;
                        }
                    });
                }
            }
        });
    }
}
