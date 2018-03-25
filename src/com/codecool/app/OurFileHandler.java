package com.codecool.app;

import java.io.*;
import java.util.Map;
import java.util.Scanner;


public class OurFileHandler {

    private static final String FILENAME = "music.txt";

    public static void writer(Song song) {
        BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			String content = Song.txtReadyString(song.getTitle(), song.getLink(), song.getArtist());
			fw = new FileWriter(FILENAME, true);
			bw = new BufferedWriter(fw);
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    }

    public static String[][] reader() {
        StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
		    br = new BufferedReader(new FileReader("music.txt"));
		    String line;
		    while ((line = br.readLine()) != null) {
		        if (sb.length() > 0) {
		            sb.append("\n");
		        }
		        sb.append(line);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (br != null) {
		            br.close();
		        }
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    }
		}
		String contents = sb.toString();
		try {
			String[] array = contents.split(";");
			String [][] songData = new String[array.length][3];
			for (int i = 0; i < array.length; i++) {
				songData[i] = array[i].split(",");
			}
			return songData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}







    }



