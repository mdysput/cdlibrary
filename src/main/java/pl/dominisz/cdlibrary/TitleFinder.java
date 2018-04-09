package pl.dominisz.cdlibrary;

import pl.dominisz.cdlibrary.menu.CDDisplay;

import java.util.Scanner;

/**
 * http://dominisz.pl
 * 09.04.2018
 */
public class TitleFinder {

    private CDLibrary cdLibrary;
    private Scanner scanner;

    public TitleFinder(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }


    public void findCD() {
        System.out.println("Enter CD title:");
        String title = scanner.nextLine();
        System.out.println("CDs with title containing " + title);
        CDDisplay.show(cdLibrary.findCDByTitle(title));
    }

}
