package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import android.content.Context;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dp2.layouttest.DetailActivity;
import com.example.dp2.layouttest.R;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<NewsItem> {

    public NewsAdapter(Context context, List<NewsItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("imgs", "getView called for: " + position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.news_list_item, null);
        }

        ImageView pic = (ImageView) convertView.findViewById(R.id.news_item_pic);
        TextView title = (TextView) convertView.findViewById(R.id.news_item_title);
        ImageView authorIcon = (ImageView) convertView.findViewById(R.id.news_item_author_icon);
        TextView authorName = (TextView) convertView.findViewById(R.id.news_item_author_name);
        TextView date = (TextView) convertView.findViewById(R.id.news_item_date);
        ImageView favoriteIcon = (ImageView) convertView.findViewById(R.id.news_item_icon_favorite);

        NewsItem item = getItem(position);
        setImage(pic, item.getPicURL(), "news_" + item.getPicId() + ".jpg");
        title.setText(item.getTitle());
        setImage(authorIcon, item.getAuthorIconURL(), "news_author_" + item.getAuthorIconId() + ".png");
        authorName.setText(item.getAuthorName());
        CharSequence formattedDate = DateUtils.getRelativeDateTimeString(getContext(), item.getUploadDate(),
                DateUtils.MINUTE_IN_MILLIS, DateUtils.YEAR_IN_MILLIS, DateUtils.FORMAT_ABBREV_MONTH);
        date.setText(formattedDate);
        if(!item.isFavorite()){
            favoriteIcon.setImageResource(R.drawable.ic_star_empty);
        }else{
            favoriteIcon.setImageResource(R.drawable.ic_star_full);
        }
        favoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.news_item_icon_favorite) {
                    ImageView favoriteIcon = (ImageView)v;
                    favoriteIcon.setImageResource(R.drawable.ic_star_full);
                }
            }
        });
        return convertView;
    }

    private void setImage(ImageView v, String URL, String title){
        ((DetailActivity)getContext()).setImage(v, URL, title);
    }
}
