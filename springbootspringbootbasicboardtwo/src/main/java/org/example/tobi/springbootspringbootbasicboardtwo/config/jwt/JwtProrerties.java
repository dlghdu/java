package org.example.tobi.springbootspringbootbasicboardtwo.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("jwt")
public class JwtProrerties {
    private String issuer;
    private String secretKey;
}
