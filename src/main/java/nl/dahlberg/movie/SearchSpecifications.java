package nl.dahlberg.movie;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SearchSpecifications {
    public static <T> Specification<T> in(final List<?> values, final String property) {
        return (root, query, criteriaBuilder) -> !values.isEmpty() ? root.get(property).in(values) : null;
    }
}
