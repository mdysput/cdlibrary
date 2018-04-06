package pl.dominisz.cdlibrary;

import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.track.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
public class CDLibrary {

    private List<CD> CDs = new ArrayList<>();

    public void add(CD cd) {

    }

    public void saveToFile() {

    }

    public void loadFromFile() {

    }

    public List<CD> getCDs() {
        return CDs;
    }

    //znajduje płyty podanego artysty
    public List<CD> findByArtist(String artist) {
        return new ArrayList<>();
    }

    //znajduje płyty o tytule zawierającym podany tekst
    public List<CD> findCDByTitle(String title) {
        return new ArrayList<>();
    }

    public List<Track> findTrackByTitle(String title) {
        return new ArrayList<>();
    }

    public List<CD> findCDByTrackTitle(String title) {
        return new ArrayList<>();
    }

    //znajduje płyty
    public List<CD> findByGenre(Genre genre) {
        return new ArrayList<>();
    }

}
