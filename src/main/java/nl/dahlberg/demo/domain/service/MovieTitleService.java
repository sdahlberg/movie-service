package nl.dahlberg.demo.domain.service;

import lombok.AllArgsConstructor;
import nl.dahlberg.demo.domain.model.MovieTitle;
import nl.dahlberg.demo.domain.repository.MovieTitleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class MovieTitleService {
    private final MovieTitleRepository movieTitleRepository;

    public void addMovieTitles(final Stream<MovieTitle> movieTitleStream) {
        int[] counter = {0};
        long[] now = {System.currentTimeMillis()};
        movieTitleRepository.saveAllBatched(movieTitleStream
                .peek(movieTitle -> {
                    if (counter[0]++ % 10000 == 0) {
                        System.out.println("Save " + counter[0] + " in " + (System.currentTimeMillis() - now[0]) + "ms");
                        now[0] = System.currentTimeMillis();
                    }
                })
                ::iterator);
    }

    public Page<MovieTitle> getMovieTitles(final Pageable pageable) {
        return movieTitleRepository.findAll(pageable);
    }
}
