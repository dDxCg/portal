package io.edu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "io.edu.user", "io.edu.app" })
@EnableJpaRepositories(basePackages = "io.edu.user.repository")
@EntityScan(basePackages = "io.edu.user.model")
@EnableCaching
public class PortalApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PortalApp.class);
        app.setAdditionalProfiles("dev"); // Set the active profile to "dev"
        app.run(args);
    }
}


