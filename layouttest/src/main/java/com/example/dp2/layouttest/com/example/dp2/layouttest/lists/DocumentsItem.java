package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;

import java.io.Serializable;

public class DocumentsItem implements Serializable, Comparable<DocumentsItem> {
    private String name;
    private int iconId;
    private String filesize;
    private long uploadDate;

    public DocumentsItem(String name, int iconId, String filesize, long uploadDate) {
        this.name = name;
        this.iconId = iconId;
        this.filesize = filesize;
        this.uploadDate = uploadDate;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }

    public String getFilesize(){
        return filesize;
    }

    public long getUploadDate() {
        return uploadDate;
    }

    @Override
    public int compareTo(DocumentsItem o2){
        return Long.valueOf(o2.uploadDate).compareTo(uploadDate);
    }
}
