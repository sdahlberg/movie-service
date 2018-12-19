package nl.dahlberg.movie.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovieTitleType {
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

    private final String value;
}
