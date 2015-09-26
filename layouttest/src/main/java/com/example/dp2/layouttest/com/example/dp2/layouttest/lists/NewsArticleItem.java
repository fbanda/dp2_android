package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;

import java.io.Serializable;

public class NewsArticleItem implements Serializable, Comparable<NewsArticleItem> {
    private int picId;
    private String picURL;
    private String title;
    private String authorName;
    private long uploadDate;
    private String content;

    public NewsArticleItem(int picId, String picURL, String title, String authorName, long uploadDate, String content) {
        this.picId = picId;
        this.picURL = picURL;
        this.title = title;
        this.authorName = authorName;
        this.uploadDate = uploadDate;
        this.content = content;
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

    public String getAuthorName(){
        return authorName;
    }

    public long getUploadDate() {
        return uploadDate;
    }

    public String getContent(){
        return content;
    }

    @Override
    public int compareTo(NewsArticleItem o2){
        return Long.valueOf(o2.uploadDate).compareTo(uploadDate);
    }
}
