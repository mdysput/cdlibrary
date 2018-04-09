package pl.dominisz.cdlibrary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.dominisz.cdlibrary.cd.CD;
import pl.dominisz.cdlibrary.cd.CDBuilder;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

/**
 * http://dominisz.pl
 * 09.04.2018
 */
public class CDLibraryTest {

    private static final String TRACK1 = "title1;100;artist1;RAP";
    private static final String TRACK2 = "title2;200;artist2;RAP";
    private static final String TRACK3 = "title3;300;artist3;RAP";
    private static final String TRACK4 = "title4;400;artist4;RAP";

    private static final String CD1 = "title1;artist1;2000;producer1;RAP;true;1";
    private static final String CD2 = "title2;artist2;2010;producer2;ROCK;false;2";

    CDLibrary cdLibrary;

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
                .setGenre(Genre.valueOf(elements[3]))
                .build();
    }

    private CD createCD(String cdDescription) {
        String[] elements = cdDescription.split(";");
        return new CDBuilder()
                .setTitle(elements[0])
                .setArtist(elements[1])
                .setReleaseYear(Integer.parseInt(elements[2]))
                .setProducer(elements[3])
                .setGenre(Genre.valueOf(elements[4]))
                .setIsOriginal("true".equals(elements[5]))
                .setDiscCount(Integer.parseInt(elements[6]))
                .build();
    }

    @Test
    void testFindByGenre() {

    }

}
