package com.codecool.app;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import com.codecool.termlib.Terminal;


public class Main {

    public static void addMusic() throws FileNotFoundException {
        Scanner getData = new Scanner(System.in);
        System.out.println("Add the title: ");
        String title = getData.nextLine();
        System.out.println("Paste in a youtube link: ");
        String link = getData.nextLine();
        System.out.println("Give the performer: ");
        String performer = getData.nextLine();
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
        while (true) {
            System.out.println("dizajn");
            Terminal terminal = new Terminal();
            terminal.clearScreen();
            System.out.println("1. List all songs");
            System.out.println("2. Add song to Temp Music Database\n");
            Scanner choice = new Scanner(System.in);
            int c = choice.nextInt();
            if (c == 1) {

                for (int i = 0; i < OurFileHandler.reader().length; i++) {
                    System.out.println(Integer.toString(i + 1) + ". " + Arrays.toString(OurFileHandler.reader()[i]) + "\n");
                }
                System.out.println("Choose a number to play the song:\n");
                playChosen();
            }
            if (c == 2) {
                addMusic();

            }
        }
    }
}
