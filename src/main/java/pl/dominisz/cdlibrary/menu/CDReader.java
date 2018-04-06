package pl.dominisz.cdlibrary.menu;

import pl.dominisz.cdlibrary.CDLibrary;
import pl.dominisz.cdlibrary.Genre;
import pl.dominisz.cdlibrary.track.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://dominisz.pl
 * 06.04.2018
 */
public class CDReader {

    private CDLibrary cdLibrary;
    private Scanner scanner;

    public CDReader(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }

    public void addNewCD() {
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
}
