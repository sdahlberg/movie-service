package nl.dahlberg.movie.interfaces.model;

import lombok.Builder;
import lombok.Data;

import java.time.Year;
import java.util.List;
import java.util.UUID;

@Builder
@Data
public class MovieTitlesResource {
    private UUID uuid;
    private String tconst;
    private MovieTitleTypeResource movieTitleType;
    private String primaryTitle;
    private String originalTitle;
    private boolean isAdult;
    private Year startYear;
    private Year endYear;
    private int runtimeMinutes;
    private List<MovieTitleGenresResource> genres;
}
