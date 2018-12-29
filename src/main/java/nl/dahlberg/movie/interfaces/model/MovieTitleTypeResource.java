package nl.dahlberg.movie.interfaces.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovieTitleTypeResource {
    MOVIE("movie"),
    SHORT("short"),
    TV_EPISODE("tvEpisode"),
    TV_MINI_SERIES("tvMiniSeries"),
    TV_MOVIE("tvMovie"),
    TV_SERIES("tvSeries"),
    TV_SHORT("tvShort"),
    TV_SPECIAL("tvSpecial"),
    VIDEO("video"),
    VIDEO_GAME("videoGame");

    @JsonValue
    private final String value;

    public static MovieTitleTypeResource findByValue(final String value) {
        for (MovieTitleTypeResource movieTitleTypeResource : MovieTitleTypeResource.values()) {
            if (value.equals(movieTitleTypeResource.value)) {
                return movieTitleTypeResource;
            }
        }
        throw new IllegalArgumentException("Not a valid value: " + value);
    }
}
