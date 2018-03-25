package com.codecool.app;

import java.io.*;


public class OurFileHandler {

    private static final String FILENAME = "/home/gergelyk89/codecool/1TWJava/java-freestyle-in-terminal-temporarynameforteamprobablysmokers/src/music.txt";

    public static void writer(String content, Boolean append) {
        BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME, append);
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

    public static void voteWriter(String[][] songData) {
        try {
            new PrintWriter(FILENAME).close();
        }
        catch (FileNotFoundException f) {
            f.printStackTrace();
        }
		for (int i = 0; i < songData.length; i++) {
			writer(Song.txtReadyString(songData[i][0], songData[i][1], songData[i][2], Integer.parseInt(songData[i][3])), true);
		}
	}

    public static String[][] reader() {
        StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
		    br = new BufferedReader(new FileReader(FILENAME));
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



