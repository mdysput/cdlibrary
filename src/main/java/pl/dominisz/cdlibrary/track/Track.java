package pl.dominisz.cdlibrary.track;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.dominisz.cdlibrary.Genre;
import pl.dominisz.cdlibrary.TimeUtil;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Track {

    private String title;
    private int time;
    private String artist;
    private Set<Genre> genres;

    @Override
    public String toString() {
        return "Title: " + title +
                ", time: " + TimeUtil.intTimeToString(time) +
                ", artist: " + artist +
                ", genres: " + getGenresDescription();
    }

    private String getGenresDescription() {
        return genres.stream()
                .map(Genre::getDescription)
                .collect(Collectors.joining(", "));
    }
}
