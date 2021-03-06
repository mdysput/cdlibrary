package pl.dominisz.cdlibrary;

import pl.dominisz.cdlibrary.menu.CDDisplay;
import pl.dominisz.cdlibrary.menu.CDReader;

import java.util.Scanner;


public class App {

    private static final String FILENAME = "cdlibrary.txt";

    private CDLibrary cdLibrary = new CDLibrary();
    private Scanner scanner = new Scanner(System.in);
    private CDReader cdReader = new CDReader(cdLibrary, scanner);
    private ArtistFinder artistFinder = new ArtistFinder(cdLibrary, scanner);
    private TitleFinder titleFinder = new TitleFinder(cdLibrary, scanner);
    private UUIDFinder uuidFinder= new UUIDFinder(cdLibrary, scanner);

    public void showMainMenu() {
        cdLibrary.loadFromFile(FILENAME);
        boolean exit = false;
        while (!exit) {
            System.out.println("Main menu:");
            System.out.println("1. Add new CD");
            System.out.println("2. Show all CDs");
            System.out.println("3. Find CDs by artist");
            System.out.println("4. Show all artists");
            System.out.println("5. Find CDs by title");
            System.out.println("6. Find tracks by title");
            System.out.println("7. Find CD by UUID");
            System.out.println("9. Exit");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    cdReader.addNewCD();
                    break;
                case 2:
                    CDDisplay.show(cdLibrary.getCDs());
                    break;
                case 3:
                    artistFinder.findByArtist();
                    break;
                case 4:
                    artistFinder.findAllArtists();
                    break;
                case 5:
                    titleFinder.findCDs();
                    break;
                case 6:
                    titleFinder.findTracks();
                    break;
                case 7:
                    uuidFinder.findCD();
                    break;
                default:
                    exit = true;
            }
        }
        cdLibrary.saveToFile(FILENAME);
    }

    public static void main(String[] args) {
        App app = new App();
        app.showMainMenu();
    }

}
