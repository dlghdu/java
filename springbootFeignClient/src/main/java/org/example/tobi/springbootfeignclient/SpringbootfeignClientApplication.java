package org.example.tobi.springbootfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootfeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootfeignClientApplication.class, args);
    }

}
