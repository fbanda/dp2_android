package com.example.dp2.layouttest.com.example.dp2.layouttest.lists;


import java.io.Serializable;

public class KidItem implements Serializable, Comparable<KidItem> {
    private String name;
    private int age;
    private boolean written;

    public KidItem(String name, int age, boolean written) {
        this.name = name;
        this.age = age;
        this.written = written;
    }

    public String getName() { return name; }

    public int getAge() {
        return age;
    }

    public boolean isWritten() {
        return written;
    }

    @Override
    public int compareTo(KidItem o2){
        return name.compareTo(o2.name);
    }
}
