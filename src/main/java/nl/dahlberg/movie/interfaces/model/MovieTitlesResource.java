package nl.dahlberg.movie.interfaces.model;

import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Builder
@Data
public class MovieTitlesResource {
    private UUID uuid;
    private String tconst;
    private MovieTitleTypeResource movieTitleType;
    private String primaryTitle;
}
