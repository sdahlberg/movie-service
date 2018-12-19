package nl.dahlberg.demo.infrastructure.importer.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.Year;
import java.util.List;

@JsonPropertyOrder(value = {"tconst", "titleType", "primaryTitle", "originalTitle", "isAdult", "startYear", "endYear", "runtimeMinutes", "genres"})
@Data
public class TitleBasics {
    private String tconst;
    private TitleType titleType;
    private String primaryTitle;
    private String originalTitle;
    private Boolean isAdult;
    private Year startYear;
    private Year endYear;
    private int runtimeMinutes;
    private List<Genre> genres;
}
