package org.example.tobi.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CatalogserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogserviceApplication.class, args);
    }

}
