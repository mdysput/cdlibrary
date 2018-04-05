package pl.dominisz.cdlibrary;

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
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addNewCD();
                    break;
                case 2:
                    showAllCDs();
                    break;
            }
        }
        cdLibrary.saveToFile();
    }

    private void showAllCDs() {

    }

    private void addNewCD() {

    }

    public static void main(String[] args) {
        App app = new App();
        app.showMainMenu();
    }

}
