package pl.dominisz.cdlibrary;

import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.menu.CDDisplay;

import java.util.List;
import java.util.Scanner;

/**
 * http://dominisz.pl
 * 06.04.2018
 */
public class ArtistFinder {

    private CDLibrary cdLibrary;
    private Scanner scanner;

    public ArtistFinder(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }

    public void find() {
        System.out.println("Enter artist:");
        String artist = scanner.nextLine();
        List<CD> CDs = cdLibrary.findByArtist(artist);
        CDDisplay.show(CDs);
    }

}
