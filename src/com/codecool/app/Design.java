package com.codecool.app;
import com.codecool.termlib.Color;
import com.codecool.termlib.Terminal;

public class Design {
    private static int LINELENGTH = 103;
    public static void mainMenuDesign(String[] menuOptions) {
        String logo = graphics()[0];
        String hifi = graphics()[1];
        Terminal terminal = new Terminal();
        terminal.setBgColor(Color.BLACK);
        terminal.setColor(Color.YELLOW);
        System.out.println(logo);
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println(String.format("          "+"%-"+(LINELENGTH-menuOptions[0].length())/2+"s", menuOptions[i])+String.format("%"+(LINELENGTH-(LINELENGTH-menuOptions[0].length())/2-10)+"s", ""));
        }
        if (menuOptions.length < 2) {
            playList();
        }
        System.out.println(hifi);
        terminal.resetStyle();
    }


    public static void playList() {
        for (int i = 0; i < OurFileHandler.reader().length; i++) {
            String listElement = ("                " + Integer.toString(i + 1) + ". " + OurFileHandler.reader()[i][2] + " " + OurFileHandler.reader()[i][0] + " ////// Votes: " + OurFileHandler.reader()[i][3]);
            System.out.println(listElement + String.format("%-"+(LINELENGTH-(listElement.length()))+"s", ""));
        }
    }


    public static String[] graphics() {
        String woofer = String.join("\n"
        , "╔══╗ ♫_______ _______ _______  _____       _____ _     _ _     _ _______ ______   _____  _     _  ♫╔══╗"
        , "║██║ ♪♪  |    |______ |  |  | |_____]        |   |     | |____/  |______ |_____] |     |  \\___/  ♪♪║██║"
                , "║██║♫♪   |    |______ |  |  | |            __|   |_____| |    \\_ |______ |_____] |_____| _/   \\_♫♪ ║██║"
                , "║ ◎♫♪♫                                                                                           ♪♫◎♫ ║"
                , "╚══╝                                                                                               ╚══╝");

        String hifi = String.join("\n"
        ,"                                                                      ░░█▀▀▀▀▀▀▀▀▀▀▀▀▀▀█               "
        ,"                                                                      ██▀▀▀██▀▀▀▀▀▀██▀▀▀██             "
        ,"                                                                      █▒▒▒▒▒█▒▀▀▀▀▒█▒▒▒▒▒█             "
        ,"                                                                      █▒▒▒▒▒█▒████▒█▒▒▒▒▒█             "
        ,"                                                                      ██▄▄▄██▄▄▄▄▄▄██▄▄▄██             ");
        String[] graphics = {woofer, hifi};
        return graphics;
    }
}






