package ua.cyclopoid.back.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import ua.cyclopoid.back.form.Form;
import ua.cyclopoid.back.form.FormRepository;


@Slf4j
public class LoadDatabase {

    @Bean
    public CommandLineRunner initDatabase(FormRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Form("Login")));
            log.info("Preloading " + repository.save(new Form("Register")));
        };
    }
}
