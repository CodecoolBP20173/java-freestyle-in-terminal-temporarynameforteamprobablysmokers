package com.codecool.app;

import java.util.Map;
import java.util.TreeMap;

public class Song {
    private String title;
    private String  link;
    public static Map<String,Song> objectList = new TreeMap<>();

    public Song(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
