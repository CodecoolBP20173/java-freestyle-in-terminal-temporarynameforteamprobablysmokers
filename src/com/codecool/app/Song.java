package com.codecool.app;

import java.util.Map;
import java.util.TreeMap;

public class Song {
    private String title;
    private String  link;
    private Category category;
    private int vote;

    private String  artist;
    public static Map<String,Song> objectList = new TreeMap<>();

    public Song(String title, String link, String artist) {
        this.title = title;
        this.link = link;
	this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getArtist() {
        return artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String txtReadyString(String link, String title, String Artist) {
	this.artist = artist;
        this.link = link;
	this.title = title;
	stringToTxt = link + "," + title + "," + artist + ";";
	return stringToTxt;

    }
}
