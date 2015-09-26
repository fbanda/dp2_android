package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import java.io.Serializable;

public class SessionItem implements Serializable, Comparable<SessionItem> {
    private String name;
    private long date;

    public SessionItem(String name, long date) {
        this.name = name;
        this.date = date;
    }

    public String getName() { return name; }

    public long getDate() {
        return date;
    }

    @Override
    public int compareTo(SessionItem o2){
        return Long.valueOf(o2.date).compareTo(date);
    }
}
