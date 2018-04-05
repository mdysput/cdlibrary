package pl.dominisz.cdlibrary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
public class CDBuilderTest {

    @Test
    void testCDBuilder() {
        Track track1 = new TrackBuilder()
                .setTitle("title1")
                .build();
        Track track2 = new TrackBuilder()
                .setTitle("title2")
                .build();
        Track track3 = new TrackBuilder()
                .setTitle("title3")
                .build();
        CD cd = new CDBuilder()
                .setTitle("cd title")
                .setTrack(track1)
                .setTrack(track2)
                .setTrack(track3)
                .build();
        assertEquals("cd title", cd.getTitle());
        assertEquals(3, cd.getTracks().size(), "CD should has got 3 tracks");
        assertEquals("title1", cd.getTracks().get(0).getTitle());
        assertEquals("title2", cd.getTracks().get(1).getTitle());
        assertEquals("title3", cd.getTracks().get(2).getTitle());
    }
}
