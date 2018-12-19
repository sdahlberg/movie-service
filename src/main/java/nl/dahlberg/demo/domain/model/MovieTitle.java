package nl.dahlberg.demo.domain.model;

import nl.dahlberg.demo.infrastructure.repository.jpa.converter.YearAttributeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Year;
import java.util.List;
import java.util.UUID;

@lombok.Builder
@lombok.Getter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Entity
public class MovieTitle {
    @Id
    @GeneratedValue
    private long id;

    private UUID uuid;

    @Column(unique = true)
    private String tconst;

    @Enumerated(EnumType.STRING)
    private MovieTitleType movieTitleType;

    private String primaryTitle;

    @Column(length = 512)
    private String originalTitle;

    private boolean isAdult;

    @Column(columnDefinition = "smallint")
    @Convert(converter = YearAttributeConverter.class)
    private Year startYear;

    @Column(columnDefinition = "smallint")
    @Convert(converter = YearAttributeConverter.class)
    private Year endYear;

    private int runtimeMinutes;

    @ElementCollection
    private List<MovieGenre> genres;

    public static MovieTitle.MovieTitleBuilder create() {
        return MovieTitle.builder().uuid(UUID.randomUUID());
    }
}
