package pl.dominisz.cdlibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://dominisz.pl
 * 25.03.2018
 */
public class App {

    private CDLibrary cdLibrary = new CDLibrary();
    private Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        cdLibrary.loadFromFile();
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add new CD");
            System.out.println("2. Show all CDs");
            System.out.println("3. Exit");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    addNewCD();
                    break;
                case 2:
                    showAllCDs();
                    break;
                default:
                    exit = true;
            }
        }
        cdLibrary.saveToFile();
    }

    private void showAllCDs() {

    }

    private void addNewCD() {
        System.out.println("Enter CD info");
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("Artist:");
        String artist = scanner.nextLine();
        System.out.println("Release year:");
        int releaseYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Producer:");
        String producer = scanner.nextLine();
        Genre genre = readGenre();
        List<Track> tracks = readTracks();
        System.out.println("Is original (yes/no):");
        boolean original = "yes".equals(scanner.nextLine());
        System.out.println("Disc count:");
        int discCount = Integer.parseInt(scanner.nextLine());
        //create CD
        //add to CDLibrary
    }

    private List<Track> readTracks() {
        return new ArrayList<>();
    }

    private Genre readGenre() {
        Genre[] genres = Genre.values();
        for (int i = 0; i < genres.length; i++) {
            System.out.println((i + 1) + " " + genres[i].getDescription());
        }
        System.out.println("Choose number:");
        int number = Integer.parseInt(scanner.nextLine());
        return genres[number - 1];
    }

    public static void main(String[] args) {
        App app = new App();
        app.showMainMenu();
    }

}
