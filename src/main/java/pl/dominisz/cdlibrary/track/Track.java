package pl.dominisz.cdlibrary.track;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import pl.dominisz.cdlibrary.Genre;
import pl.dominisz.cdlibrary.TimeUtil;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
@Getter
@AllArgsConstructor
public class Track {

    private String title;
    private int time;
    private String artist;
    private Genre genre;

    @Override
    public String toString() {
        return "Title: " + title +
                ", time: " + TimeUtil.intTimeToString(time) +
                ", artist: " + artist +
                ", genre: " + genre.getDescription();
    }
}
