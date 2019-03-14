package ua.cyclopoid.back.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import ua.cyclopoid.back.form.Form;
import ua.cyclopoid.back.form.FormController;
import ua.cyclopoid.back.form.api.FormRepository;


public class DBManager {

    private final static Logger LOGGER = LoggerFactory.getLogger(FormController.class);

    @Bean
    public CommandLineRunner initDatabase(FormRepository repository) {
        return args -> {
            LOGGER.info("Preloading " + repository.save(new Form("Login")));
            LOGGER.info("Preloading " + repository.save(new Form("Register")));
        };
    }
}
