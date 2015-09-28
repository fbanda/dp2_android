package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import android.content.Context;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dp2.layouttest.DetailActivity;
import com.example.dp2.layouttest.R;
import com.example.dp2.layouttest.fragments.BaseFragment;
import com.example.dp2.layouttest.fragments.NewsArticleFragment;
import com.example.dp2.layouttest.fragments.NewsFragment;

import java.util.List;

public class NewsAdapter extends BaseArrayAdapter<NewsItem> {

    public static final int EMPTY_STAR = R.drawable.ic_star_empty;
    public static final int FULL_STAR = R.drawable.ic_star_full;
    public static int getStarDrawable(boolean isFavorite){
        if(!isFavorite){
            return R.drawable.ic_star_empty;
        }else{
            return R.drawable.ic_star_full;
        }
    }

    public NewsAdapter(Context context, BaseFragment fragment, List<NewsItem> objects) {
        super(context, fragment, R.layout.news_list_item, objects);
    }

    @Override
    public void prepareItemView(final View convertView, final NewsItem item, final int position) {
        ImageView pic = (ImageView) convertView.findViewById(R.id.news_item_pic);
        TextView title = (TextView) convertView.findViewById(R.id.news_item_title);
        ImageView authorIcon = (ImageView) convertView.findViewById(R.id.news_item_author_icon);
        TextView authorName = (TextView) convertView.findViewById(R.id.news_item_author_name);
        TextView date = (TextView) convertView.findViewById(R.id.news_item_date);
        ImageView favoriteIcon = (ImageView) convertView.findViewById(R.id.news_item_icon_favorite);

        setImage(pic, item.getPicURL(), "news_" + item.getPicId() + ".jpg");
        title.setText(item.getTitle());
        setImage(authorIcon, item.getAuthorIconURL(), "news_author_" + item.getAuthorIconId() + ".png");
        authorName.setText(item.getAuthorName());
        CharSequence formattedDate = DateUtils.getRelativeDateTimeString(getContext(), item.getUploadDate(),
                DateUtils.MINUTE_IN_MILLIS, DateUtils.YEAR_IN_MILLIS, DateUtils.FORMAT_ABBREV_MONTH);
        date.setText(formattedDate);
        favoriteIcon.setImageResource(getStarDrawable(item.isFavorite()));
        favoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.news_item_icon_favorite) {
                    boolean isFavorite = ((NewsFragment)getFragment()).toggleFavorite(position);
                    ImageView favoriteIcon = (ImageView) v;
                    favoriteIcon.setImageResource(getStarDrawable(isFavorite));
                }
            }
        });

        RelativeLayout newsItem = (RelativeLayout)convertView.findViewById(R.id.news_item);
        newsItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.news_item){
                    NewsArticleFragment newsArticleFragment = new NewsArticleFragment();
                    Bundle args = new Bundle();
                    NewsArticleItem arg = new NewsArticleItem(item.getPicId(), item.getPicURL(),
                            item.getTitle(), item.getAuthorName(), item.getUploadDate(),
                            convertView.getResources().getString(R.string.article_example));
                    args.putSerializable(NewsArticleFragment.NEWS_ARTICLE_ARG, arg);
                    newsArticleFragment.setArguments(args);
                    getFragment().addFragmentToStack(newsArticleFragment, DetailActivity.FRAGMENT_DETALLE_NOTICIAS);
                }
            }
        });
    }
}
