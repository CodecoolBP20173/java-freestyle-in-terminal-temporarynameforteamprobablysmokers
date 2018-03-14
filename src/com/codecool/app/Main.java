package com.codecool.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void addMusic() throws FileNotFoundException {
        Scanner getData = new Scanner(System.in);
        System.out.println("Add the title: ");
        String title = getData.nextLine();
        System.out.println("Paste in a youtube link: ");
        String link = getData.nextLine();
        System.out.println("Give the performer: ");
        String performer = getData.nextLine();
        System.out.println("Give the category: ");
        String category = getData.nextLine();
        Song a = new Song(title, link, performer);
        OurFileHandler.writer(a);
        System.out.println("Song created in database!");
    }

    public static void playChosen() throws FileNotFoundException {
        Scanner getData = new Scanner(System.in);
        int chosen = getData.nextInt();
        Mediaplayer.main(OurFileHandler.reader()[chosen - 1]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("dizajn");
        System.out.println("1. list all songs");
        System.out.println("2. Add song");
        Scanner choice = new Scanner (System.in);
        int c = choice.nextInt();
        if (c==1) {
            System.out.println("belefut");
            for (int i=0; i<OurFileHandler.reader().length; i++) {
                System.out.println(Integer.toString(i+1) + Arrays.toString(OurFileHandler.reader()[i]));
            }
            System.out.println("to play choose a number");
            playChosen();
        }
        if (c==2) {
            addMusic();

        }

    }
}
