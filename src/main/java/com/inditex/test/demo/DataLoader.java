package com.inditex.test.demo;

import com.inditex.test.demo.entities.Prices;
import com.inditex.test.demo.repositories.PricesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class DataLoader {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    @Bean
    CommandLineRunner initDatabase(PricesRepository repository) {
        return args -> {
            Prices p1 = new Prices(null, "1", 
                LocalDateTime.parse("2020-06-14-00.00.00", FORMATTER), 
                LocalDateTime.parse("2020-12-31-23.59.59", FORMATTER), 
                "1", "35455", 0, "35.50", "EUR");

            Prices p2 = new Prices(null, "1", 
                LocalDateTime.parse("2020-06-14-15.00.00", FORMATTER), 
                LocalDateTime.parse("2020-06-14-18.30.00", FORMATTER), 
                "2", "35455", 1, "25.45", "EUR");

            Prices p3 = new Prices(null, "1", 
                LocalDateTime.parse("2020-06-15-00.00.00", FORMATTER), 
                LocalDateTime.parse("2020-06-15-11.00.00", FORMATTER), 
                "3", "35455", 1, "30.50", "EUR");

            Prices p4 = new Prices(null, "1", 
                LocalDateTime.parse("2020-06-15-16.00.00", FORMATTER), 
                LocalDateTime.parse("2020-12-31-23.59.59", FORMATTER), 
                "4", "35455", 1, "38.95", "EUR");

            repository.saveAll(Arrays.asList(p1, p2, p3, p4));
        };
    }
}
