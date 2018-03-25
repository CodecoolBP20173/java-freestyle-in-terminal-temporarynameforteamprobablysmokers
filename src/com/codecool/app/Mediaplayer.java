package com.codecool.app;


class Mediaplayer{
	public static void main(String args[]){
		try{
			ProcessBuilder pb=new ProcessBuilder("cvlc", "--global-key-quit=-","--no-video", args[1]);
			pb.start();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
