package com.codecool.app;

import java.util.Scanner;
import com.codecool.termlib.Terminal;


public class Main {

    private static int LINELENGTH = 103;

    public static void addMusic() {
        Scanner getData = new Scanner(System.in);
        System.out.println("Give the performer: ");
        String performer = getData.nextLine();
        System.out.println("Add the title: ");
        String title = getData.nextLine();
        System.out.println("Type in the youtube link: ");
        String link = getData.nextLine();
        Song a = new Song(title, link, performer);
        String content = Song.txtReadyString(a.getTitle(), a.getLink(), a.getArtist(), 0);
        OurFileHandler.writer(content, true);
        System.out.println("Song created in database!");
    }

    public static int playChosen(String[][] songData) {
        Scanner getData = new Scanner(System.in);
        int chosen = 0;
        try {
            chosen = getData.nextInt();
            while (!(0 < chosen && chosen <= songData.length)) {
                defScreenTerminal();
                String[] playOption = {"Choose a song or 'q' to quit: "};
                Design.mainMenuDesign(playOption);
                System.out.println("Please choose from the available songs!");
                chosen = getData.nextInt();
            }
            Mediaplayer.main(OurFileHandler.reader()[chosen - 1]);
            defScreenTerminal();
            System.out.println();
            String[] playOption = {"Now Playing: " + songData[chosen-1][2] + " - " + songData[chosen-1][0], String.format("%"+(LINELENGTH-20)+"s", ""), "Choose a song or 'q' to quit: "};
            Design.mainMenuDesign(playOption);
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        return chosen;
    }

    public static void defScreenTerminal() {
        Terminal terminal = new Terminal();
        terminal.resetStyle();
        terminal.moveTo(0,0);
        terminal.clearScreen();
    }


    public static void voteSong(String[][] songData, Scanner choice, Integer chosenSong) {
        System.out.println("Do you like this song? (y or n)");
        String vote = choice.next();
        int voteInt = Integer.parseInt(songData[chosenSong-1][3]);
        if (vote.equals("y")) {
            voteInt += 1;
            songData[chosenSong-1][3] = String.valueOf(voteInt);
            OurFileHandler.voteWriter(songData);
            listPlayer(songData, choice);
        } else if (vote.equals("n")) {
            voteInt -= 1;
            int updateIndex = 0;
            songData[chosenSong-1][3] = String.valueOf(voteInt);
            if (voteInt < 1) {
                String[][] updatedSongData = new String[songData.length-1][songData[0].length];
                for (int i = 0; i < songData.length; i++) {
                    if (i == (chosenSong-1)) {
                    }
                    else {
                        updatedSongData[updateIndex] = songData[i];
                        updateIndex++;
                    }
                }
                songData = updatedSongData;
            }
            OurFileHandler.voteWriter(songData);
            listPlayer(songData, choice);
        }
    }


    public static void listPlayer(String[][] songData, Scanner choice) {
        if (songData.length != 0) {
            try {
                defScreenTerminal();
                String[] playOption = {"Choose a song or 'q' to quit: ", "When a song is playing, you can stop it with '-'."};
                Design.mainMenuDesign(playOption);
                int chosenSong = playChosen(songData);
                voteSong(songData, choice, chosenSong);
            } catch (IndexOutOfBoundsException i) {
                i.printStackTrace();
            }
        } else {
            System.out.println("No songs in the playlist, please add some!");
        }
    }


    public static void main(String[] args) {
        while (true) {
            defScreenTerminal();
            String[] mainOptions = new String[4];
            String[][] songData = OurFileHandler.reader();
            if (songData[0].length < 4) {
                mainOptions[0] = "Temporary JukeBox - songs only exist until votes are positive";
                mainOptions[1] = "No songs yet :(";
                mainOptions[2] = "2. Add song to Temp JukeBox";
                mainOptions[3] = "3. Exit";
            } else {
                mainOptions[0] = "Temporary JukeBox - songs only exist until votes are positive";
                mainOptions[1] = "1. List all songs";
                mainOptions[2] = "2. Add song to Temp JukeBox";
                mainOptions[3] = "3. Exit";
            }
            Design.mainMenuDesign(mainOptions);
            try {
                Scanner choice = new Scanner(System.in);
                System.out.println("Please choose from the selection above: ");
                int c = choice.nextInt();
                if (c == 1) {
                    if (songData[0].length < 4) {
                        continue;
                    } else {
                        listPlayer(songData, choice);
                    }
                }
                if (c == 2) {
                    addMusic();
                }
                if (c == 3) {
                    System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
