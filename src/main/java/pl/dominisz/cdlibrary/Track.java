package pl.dominisz.cdlibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

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

}
