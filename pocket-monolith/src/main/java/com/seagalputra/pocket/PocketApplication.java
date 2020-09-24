package com.seagalputra.pocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.seagalputra.pocket.domain"})
@EntityScan(basePackages = {"com.seagalputra.pocket.domain"})
public class PocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(PocketApplication.class, args);
    }
}
