package pl.dominisz.cdlibrary;

/**
 * http://dominisz.pl
 * 05.04.2018
 */
public enum Genre {

    AFRICAN_HEAVY_METAL("african heavy metal"),
    BENGA("benga"),
    CLASSICAL("classical"),
    JAZZ("jazz"),
    POP("pop"),
    ROCK("rock"),
    RAP("rap");

    private String description;

    public String getDescription() {
        return description;
    }

    Genre(String description) {
        this.description = description;
    }
}
