package com.codecool.app;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import com.codecool.termlib.Terminal;


public class Main {

    public static void addMusic() throws FileNotFoundException {
        Scanner getData = new Scanner(System.in);
        System.out.println("Give the performer: ");
        String performer = getData.nextLine();
        System.out.println("Add the title: ");
        String title = getData.nextLine();
        System.out.println("Type in the youtube link: ");
        String link = getData.nextLine();
        Song a = new Song(title, link, performer);
        String content = Song.txtReadyString(a.getTitle(), a.getLink(), a.getArtist(), 5);
        OurFileHandler.writer(content, true);
        System.out.println("Song created in database!");
    }

    public static int playChosen() throws FileNotFoundException {
        Scanner getData = new Scanner(System.in);
        int chosen = getData.nextInt();
        Mediaplayer.main(OurFileHandler.reader()[chosen - 1]);
        return chosen;
    }

    public static void defScreenTerminal() {
        Terminal terminal = new Terminal();
        terminal.moveTo(0,0);
        terminal.clearScreen();
    }

    public static void main(String[] args) throws FileNotFoundException {
        while (true) {
            defScreenTerminal();
            String[][] songData = OurFileHandler.reader();
            String[] mainOptions = {"1. List all songs","2. Add song to Temp JukeBox"};
            Design.mainMenuDesign(mainOptions);
            try {
                Scanner choice = new Scanner(System.in);
                System.out.println("Please choose from the selection above: ");
                int c = choice.nextInt();
                if (c == 1) {
                    if (songData.length != 0) {
                        try {
                            defScreenTerminal();
                            String[] playOption = {"Choose a song or 'q' to quit: "};
                            Design.mainMenuDesign(playOption);
                            int choosenSong = playChosen();
                            System.out.println("Do you like this song? (y or n)");
                            String vote = choice.next();
                            int voteInt = Integer.parseInt(songData[choosenSong-1][3]);
                            if (vote.equals("y")) {
                                voteInt += 1;
                                songData[choosenSong-1][3] = String.valueOf(voteInt);
                                OurFileHandler.voteWriter(songData);
                            } else if (vote.equals("n")) {
                                voteInt -= 1;
                                songData[choosenSong-1][3] = String.valueOf(voteInt);
                                OurFileHandler.voteWriter(songData);
                            }
                        } catch (IndexOutOfBoundsException i) {
                            i.printStackTrace();
                        }
                    } else {
                        System.out.println("No songs in the playlist, please add some!");
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
