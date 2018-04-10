package pl.dominisz.cdlibrary.track;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import pl.dominisz.cdlibrary.Genre;
import pl.dominisz.cdlibrary.track.Track;
import pl.dominisz.cdlibrary.track.TrackBuilder;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
public class TrackBuilderTest {

    @Test
    void testTrackBuilder() {
        String title = "title";
        int time = 100;
        String artist = "artist";
        Genre genre1 = Genre.AFRICAN_HEAVY_METAL;
        Genre genre2 = Genre.BENGA;
        Set<Genre> genres = Sets.newHashSet(Genre.RAP, Genre.ROCK);

        Track track = new TrackBuilder()
                .setArtist(artist)
                .setTime(time)
                .setGenre(genre1)
                .setGenre(genre2)
                .setGenres(genres)
                .setTitle(title)
                .build();

        assertEquals(artist, track.getArtist());
        assertEquals(time, track.getTime());
        assertEquals(title, track.getTitle());
        assertEquals(4, track.getGenres().size());
        assertTrue(track.getGenres().contains(Genre.AFRICAN_HEAVY_METAL));
        assertTrue(track.getGenres().contains(Genre.BENGA));
        assertTrue(track.getGenres().contains(Genre.RAP));
        assertTrue(track.getGenres().contains(Genre.ROCK));
    }

}
