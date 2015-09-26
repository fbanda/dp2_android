package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Fernando on 24/09/2015.
 */
public class AttendanceItem implements Serializable, Comparable<AttendanceItem> {

    private int picId;
    private String picURL;
    private String name;
    private boolean toggleOn;

    public AttendanceItem(int picId, String picURL, String name, boolean toggleOn){
        this.picId = picId;
        this.picURL = picURL;
        this.name = name;
        this.toggleOn = toggleOn;
    }

    public int getPicId(){
        return picId;
    }

    public String getPicURL(){
        return picURL;
    }

    public String getName(){
        return name;
    }

    public boolean isToggleOn(){
        return toggleOn;
    }

    public int compareTo(AttendanceItem o2){
        return name.compareTo(o2.name);
    }

}
