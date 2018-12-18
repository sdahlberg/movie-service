package nl.dahlberg.demo.commands;

import lombok.AllArgsConstructor;
import nl.dahlberg.demo.application.DatabaseFiller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DemoController {

    private final DatabaseFiller databaseFiller;

    @GetMapping("/test")
    public String test() {
        databaseFiller.fillDatabase();
        return "Hello world";
    }
}
