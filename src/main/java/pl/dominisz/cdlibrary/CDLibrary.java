package pl.dominisz.cdlibrary;

import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.cd.CDBuilder;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
public class CDLibrary {

    private static final String FILENAME = "cdlibrary.txt";

    private List<CD> CDs = new ArrayList<>();

    public void add(CD cd) {
        CDs.add(cd);
    }

    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(FILENAME);
            out.println(CDs.size());
            for (CD cd : CDs) {
                saveCDToFile(out, cd);
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało się zapisać pliku " + FILENAME);
        }
    }

    private void saveCDToFile(PrintWriter out, CD cd) {
        out.println(cd.getTitle());
        out.println(cd.getArtist());
        out.println(cd.getReleaseYear());
        out.println(cd.getProducer());
        out.println(cd.getGenre());
        out.println(cd.isOriginal());
        out.println(cd.getDiscCount());
        out.println(cd.getTracks().size());
        for (Track track : cd.getTracks()) {
            saveTrackToFile(out, track);
        }
    }

    private void saveTrackToFile(PrintWriter out, Track track) {
        out.println(track.getTitle());
        out.println(track.getTime());
        out.println(track.getArtist());
        out.println(track.getGenre());
    }

    public void loadFromFile() {
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(FILENAME));
            String line = bufferedReader.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                loadCDFromFile(bufferedReader);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku " + FILENAME);
        }
    }

    private void loadCDFromFile(BufferedReader bufferedReader) throws IOException {
        CD cd = new CDBuilder()
                .setTitle(bufferedReader.readLine())
                .setAuthor(bufferedReader.readLine())
                .setReleaseYear(Integer.parseInt(bufferedReader.readLine()))
                .setProducer(bufferedReader.readLine())
                .setGenre(Genre.valueOf(bufferedReader.readLine()))
                .setIsOriginal(Boolean.valueOf(bufferedReader.readLine()))
                .setDiscCount(Integer.parseInt(bufferedReader.readLine()))
                .setTracks(loadTracksFromFile(bufferedReader))
                .build();
        CDs.add(cd);
    }

    private List<Track> loadTracksFromFile(BufferedReader bufferedReader) throws IOException {
        int count = Integer.parseInt(bufferedReader.readLine());
        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tracks.add(loadTrackFromFile(bufferedReader));
        }
        return tracks;
    }

    private Track loadTrackFromFile(BufferedReader bufferedReader) throws IOException {
        return new TrackBuilder()
                .setTitle(bufferedReader.readLine())
                .setTime(Integer.parseInt(bufferedReader.readLine()))
                .setArtist(bufferedReader.readLine())
                .setGenre(Genre.valueOf(bufferedReader.readLine()))
                .build();
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
