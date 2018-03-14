package com.codecool.app;

import java.io.*;
import java.util.Map;
import java.util.Scanner;


public class OurFileHandler {
    private static String path = "/Users/Peter/Documents/codecool/tw1java/java-freestyle-in-terminal-temporarynameforteamprobablysmokers/src/com/codecool/app/musics.txt";
    private static File file = new File(path);



    public static void writer(Song song) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.println(song.getTitle() + "," + song.getLink());
        writer.close();
    }

    public static Map reader() throws FileNotFoundException {
        BufferedReader read = new BufferedReader(new FileReader(file));
        Scanner linesok = new Scanner (file);
        Scanner readd;
        String line;
        String title, link;
        int counter =0;




        try {
            while (linesok.hasNext()) {
                counter++;
                line = read.readLine();

                readd = new Scanner(line);
                readd.useDelimiter(",");

                title = readd.next();
                link = readd.next();


                Song.objectList.put(title, new Song(title, link));
                System.out.println(title + " " + link);
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Song.objectList;
    }


}
