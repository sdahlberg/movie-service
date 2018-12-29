package nl.dahlberg.movie.interfaces.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class MovieTitleFilterCriteriaResource {
    private List<MovieTitleTypeResource> movieTitleTypes = Collections.emptyList();
}
