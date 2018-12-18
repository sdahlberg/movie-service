package nl.dahlberg.demo.domain;

import lombok.Builder;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Builder
@Getter
@Entity
public class MovieTitle {
    @Id
    @GeneratedValue
    private long id;

    private UUID uuid;

    private String tconst;

    @Enumerated(EnumType.STRING)
    private MovieTitleType movieTitleType;

    private String primaryTitle;

    public static MovieTitle.MovieTitleBuilder create() {
        return MovieTitle.builder().uuid(UUID.randomUUID());
    }
}
