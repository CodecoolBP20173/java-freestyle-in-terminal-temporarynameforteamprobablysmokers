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

    public static void defScreenTerminal() {
        Terminal terminal = new Terminal();
        terminal.moveTo(0,0);
        terminal.clearScreen();
    }

    public static void main(String[] args) throws FileNotFoundException {
        while (true) {
            defScreenTerminal();
            String[] mainOptions = {"1. List all songs","2. Add song to Temp JukeBox"};
            Design.mainMenuDesign(mainOptions);
            try {
                Scanner choice = new Scanner(System.in);
                System.out.println("Please choose from the selection above: ");
                int c = choice.nextInt();
                if (c == 1) {
                    try {
                        defScreenTerminal();
                        String[] playOption = {"Choose a song or 'q' to quit: "};
                        Design.mainMenuDesign(playOption);
                        playChosen();
                    } catch (IndexOutOfBoundsException i) {
                        i.printStackTrace();
                    }
                }
                if (c == 2) {
                    addMusic();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
