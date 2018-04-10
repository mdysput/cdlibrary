package pl.dominisz.cdlibrary;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.cd.CDBuilder;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * http://dominisz.pl
 * 09.04.2018
 */
public class CDLibraryTest {

    private static final String TRACK1 = "title1;100;artist1;RAP,ROCK";
    private static final String TRACK2 = "title2;200;artist2;RAP,POP";
    private static final String TRACK3 = "title3;300;artist3;RAP,JAZZ,BENGA";
    private static final String TRACK4 = "title4;400;artist4;RAP,ROCK,POP,JAZZ";

    private static final String CD1 = "title1;artist1;2000;producer1;true;1";
    private static final String CD2 = "title2;artist2;2010;producer2;false;2";

    private CDLibrary cdLibrary;

    @BeforeEach
    void setup() {
        CD cd1 = createCD(CD1);
        cd1.getTracks().add(createTrack(TRACK1));
        cd1.getTracks().add(createTrack(TRACK2));

        CD cd2 = createCD(CD2);
        cd2.getTracks().add(createTrack(TRACK3));
        cd2.getTracks().add(createTrack(TRACK4));

        cdLibrary = new CDLibrary();
        cdLibrary.add(cd1);
        cdLibrary.add(cd2);
    }

    private Track createTrack(String trackDescription) {
        String[] elements = trackDescription.split(";");
        return new TrackBuilder()
                .setTitle(elements[0])
                .setTime(Integer.parseInt(elements[1]))
                .setArtist(elements[2])
                .setGenres(createGenres(elements[3]))
                .build();
    }

    private Set<Genre> createGenres(String genres) {
        return Arrays.stream(genres.split(","))
                .map(Genre::valueOf)
                .collect(Collectors.toSet());
    }

    private CD createCD(String cdDescription) {
        String[] elements = cdDescription.split(";");
        return new CDBuilder()
                .setTitle(elements[0])
                .setArtist(elements[1])
                .setReleaseYear(Integer.parseInt(elements[2]))
                .setProducer(elements[3])
                .setIsOriginal("true".equals(elements[4]))
                .setDiscCount(Integer.parseInt(elements[5]))
                .build();
    }

    @Test
    void findByGenreShouldReturnOneCD() {
        List<CD> result = cdLibrary.findByGenre(Genre.BENGA);
        assertEquals(1, result.size());
        assertTrue(result.get(0).getGenres().contains(Genre.BENGA));
    }

    @Test
    void findByGenreShouldReturnEmptyList() {
        List<CD> result = cdLibrary.findByGenre(Genre.AFRICAN_HEAVY_METAL);
        assertEquals(0, result.size());
    }

    @Test
    void findCDByTrackTitleShouldReturnOneCD() {
        List<CD> result = cdLibrary.findCDByTrackTitle("tle3");
        assertEquals(1, result.size());
        assertTrue(result.get(0).getTracks().stream()
            .anyMatch(track -> track.getTitle().toLowerCase().contains("tle3")));
    }

    @Test
    void findCDByTrackTitleShouldReturnEmptyList() {
        assertTrue(cdLibrary.findCDByTrackTitle("none").isEmpty());
    }

    @Test
    void findTrackByTitleShouldReturnOneTrack() {
        List<Track> actualTracks = cdLibrary.findTrackByTitle("tle3");
        assertEquals(1, actualTracks.size());
        Track actualTrack = actualTracks.get(0);
        assertTrue(actualTrack.getTitle().toLowerCase().contains("tle3"));
    }

    @Test
    void findTrackByTitleShouldReturnEmptyList() {

    }

    //TODO zrobić testy findCDByTitle

    //TODO zrobić testy findByArtist

    @Test
    void findAllArtistsShouldReturnTwoArtists() {
        Set<String> actualArtists = cdLibrary.findAllArtists();
        assertEquals(2, actualArtists.size());
        assertTrue(actualArtists.contains("artist1"));
        assertTrue(actualArtists.contains("artist2"));
    }

    @Test
    void testLoadFromFile() {
        CDLibrary libraryFromFile = new CDLibrary();
        String path = this.getClass().getResource("/testlibrary.txt").getPath();
        libraryFromFile.loadFromFile(path);
        assertEquals(cdLibrary.getCDs().size(), libraryFromFile.getCDs().size());
        for (int i = 0; i < cdLibrary.getCDs().size(); i++) {
            assertEquals(cdLibrary.getCDs().get(i), libraryFromFile.getCDs().get(i));
        }
    }

    @Test
    void testSaveToFile() throws IOException {
        String directoryPath = this.getClass().getResource("/").getPath();
        cdLibrary.saveToFile(directoryPath + "savedlibrary.txt");
        File testFile = new File(directoryPath + "testlibrary.txt");
        File savedFile = new File(directoryPath + "savedlibrary.txt");
        assertTrue(FileUtils.contentEquals(testFile, savedFile));
    }

    @Test
    void testAddCD() {
        CDLibrary newLibrary = new CDLibrary();
        assertTrue(newLibrary.getCDs().isEmpty());
        CD newCD = createCD(CD1);
        newLibrary.add(newCD);
        assertEquals(1, newLibrary.getCDs().size());
        assertEquals(newCD, newLibrary.getCDs().get(0));
    }

}
