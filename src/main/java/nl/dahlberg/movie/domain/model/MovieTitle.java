package nl.dahlberg.movie.domain.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
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

    @Column(length = 512)
    private String primaryTitle;

    @Column(length = 512)
    private String originalTitle;

    private boolean isAdult;

    @Column(columnDefinition = "smallint")
    private Year startYear;

    @Column(columnDefinition = "smallint")
    private Year endYear;

    private int runtimeMinutes;

    @CollectionTable(indexes = {@Index(name = "genre_index", columnList = "genres")})
    @BatchSize(size = 20)
    @Fetch(FetchMode.SELECT)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieTitleGenre> genres;

    public static MovieTitle.MovieTitleBuilder create() {
        return MovieTitle.builder().uuid(UUID.randomUUID());
    }
}
