package com.codecool.app;

import java.util.*;

class Mediaplayer{
	public static void main(String args[]){

		try{
			ProcessBuilder pb=new ProcessBuilder("cvlc", "--global-key-quit=s","--no-video", args[1], "https://www.youtube.com/watch?v=75LnzY7UnZE");
    		 pb.start();
		} catch (Exception e){
			System.out.println(e);
		}
	}
}
