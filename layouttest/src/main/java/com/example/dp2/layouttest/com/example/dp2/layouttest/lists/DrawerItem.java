package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import java.io.Serializable;

public class DrawerItem implements Serializable {
    private String name;
    private int iconId;

    public DrawerItem(String name, int iconId) {
        this.name = name;
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }
}
