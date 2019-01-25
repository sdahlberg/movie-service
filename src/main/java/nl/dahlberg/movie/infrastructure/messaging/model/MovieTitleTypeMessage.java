package nl.dahlberg.movie.infrastructure.messaging.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MovieTitleTypeMessage {
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
