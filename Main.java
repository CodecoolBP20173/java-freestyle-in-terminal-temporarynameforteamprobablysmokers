import java.util.Scanner;

public class Main {

	public static void  main(String args[]) {
		// dizájn vicikvacak
		mainMenu();
	}

	public static void mainMenu() {
		Scanner menuChoice = new Scanner(System.in);
		System.out.println("1. List all music");
		System.out.println("2. Add new music");
		int choice = menuChoice.nextInt();
		switch (choice) {
			case 1:
				listMusic();
				break;
			case 2:
				addMusic();
				break;
		}
	}

	public static void addMusic() {
		Scanner getData = new Scanner(System.in);
		System.out.println("Add the title: ");
		String title = getData.nextLine();
		System.out.println("Paste in a youtube link: ");
		String link = getData.nextLine();
		System.out.println("Give the performer: ");
		String performer = getData.nextLine();
		System.out.println("Give the category: ");
		String category = getData.nextLine();
		System.out.println("Song created in database!");
	}
	public static void listMusic() {
		
	}
}
