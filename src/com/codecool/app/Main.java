package com.codecool.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        OurFileHandler.writer(new Song("run", "ww.ww"));
        System.out.println("dizajn");
        System.out.println("1. list all songs");
        System.out.println("2. Add song");
        Scanner choice = new Scanner (System.in);
        int c = choice.nextInt();
        if (c==1) {
            System.out.println("belefut");
            for (String key : Song.objectList.keySet()) {
                System.out.println(Song.objectList);
            }
        }

    }
}
