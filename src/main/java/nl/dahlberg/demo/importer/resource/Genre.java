package nl.dahlberg.demo.importer.resource;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genre {
    ACTION("Action"),
    ADULT("Adult"),
    ADVENTURE("Adventure"),
    ANIMATION("Animation"),
    BIOGRAPHY("Biography"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DOCUMENTARY("Documentary"),
    DRAMA("Drama"),
    FAMILY("Family"),
    FANTASY("Fantasy"),
    FILM_NOIR("Film-Noir"),
    GAME_SHOW("Game-Show"),
    HISTORY("History"),
    HORROR("Horror"),
    MUSIC("Music"),
    MUSICAL("Musical"),
    MYSTERY("Mystery"),
    NEWS("News"),
    REALITY_TV("Reality-TV"),
    ROMANCE("Romance"),
    SCI_FI("Sci-Fi"),
    SHORT("Short"),
    SPORT("Sport"),
    TALK_SHOW("Talk-Show"),
    THRILLER("Thriller"),
    WAR("War"),
    WESTERN("Western");

    @JsonValue
    private final String value;
}
