package com.codecool.app;

import java.util.*;

class Mediaplayer{
	public static void main(String args[]){

		try{
			ProcessBuilder pb=new ProcessBuilder("cvlc", "--global-key-quit=s","--no-video", args[1]);
    		 pb.start();
		} catch (Exception e){
			System.out.println(e);
		}
	}
}
