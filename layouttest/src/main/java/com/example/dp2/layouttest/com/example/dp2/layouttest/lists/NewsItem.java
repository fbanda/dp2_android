package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;

import java.io.Serializable;

public class NewsItem implements Serializable, Comparable<NewsItem> {
    private int picId;
    private String picURL;
    private String title;
    private int authorIconId;
    private String authorIconURL;
    private String authorName;
    private long uploadDate;
    private boolean isFavorite;

    public NewsItem(int picId, String picURL, String title, int authorIconId, String authorIconURL, String authorName, long uploadDate, boolean isFavorite) {
        this.picId = picId;
        this.picURL = picURL;
        this.title = title;
        this.authorIconId = authorIconId;
        this.authorIconURL = authorIconURL;
        this.authorName = authorName;
        this.uploadDate = uploadDate;
        this.isFavorite = isFavorite;
    }

    public int getPicId(){
        return picId;
    }

    public String getPicURL(){
        return picURL;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthorIconId(){
        return authorIconId;
    }

    public String getAuthorIconURL() {
        return authorIconURL;
    }

    public String getAuthorName(){
        return authorName;
    }

    public long getUploadDate() {
        return uploadDate;
    }

    public boolean isFavorite(){
        return isFavorite;
    }

    @Override
    public int compareTo(NewsItem o2){
        return Long.valueOf(o2.uploadDate).compareTo(uploadDate);
    }
}
