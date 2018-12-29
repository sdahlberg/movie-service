package nl.dahlberg.movie.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Builder
@Getter
public class MovieTitleFilterCriteria {
    private List<MovieTitleType> movieTitleTypes = Collections.emptyList();
}
