package org.example.tobi.catalogservice.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ConfigurationProperties(prefix = "polar")
public class PolarProperties {
    String greeting;
}
