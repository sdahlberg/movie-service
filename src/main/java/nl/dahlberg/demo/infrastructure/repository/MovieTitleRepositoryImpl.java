package nl.dahlberg.demo.infrastructure.repository;

import nl.dahlberg.demo.domain.model.MovieTitle;
import nl.dahlberg.demo.domain.repository.MovieTitleRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class MovieTitleRepositoryImpl implements MovieTitleRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void saveAllBatched(final Iterable<MovieTitle> movieTitles) {
        int i = 0;
        for (final MovieTitle movieTitle : movieTitles) {
            entityManager.persist(movieTitle);
            i++;

            if (i % 100 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
