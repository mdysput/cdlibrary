package pl.dominisz.cdlibrary;

import jdk.nashorn.internal.runtime.options.Option;
import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.menu.CDDisplay;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class UUIDFinder {
    private CDLibrary cdLibrary;
    private Scanner scanner;

    public UUIDFinder(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }

    public void findCD() {
        System.out.println("Enter UUID: ");
        UUID uuid= UUID.fromString(scanner.nextLine());
        Optional<CD> optionalCd= cdLibrary.findByUUID(uuid);

        if(optionalCd.isPresent()){
            CD cd= optionalCd.get();
            System.out.println(cd);
        }
        else{
            System.out.println("CD not found");
        }
    }
}
