package org.example.tobi.springbootspringbootbasicboardtwo.config.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Member;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenProvider {

    private final JwtProrerties jwtProrerties;


    public String generateToken(Member member, Duration expriredAt) {
        Date now = new Date();
        return makeToken(
                member,
                new Date(now.getTime() + expriredAt.toMillis())
        );

    }

    private String makeToken(Member member, Date expire) {

        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer(jwtProrerties.getIssuer())
                .setIssuedAt(now)
                .setExpiration(expire)
                .setSubject(member.getUserId())
                .claim("id", member.getId())
                .claim("role", member.getRole())
                .claim("userName", member.getUserName())
                .signWith(getSecretKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public int validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            log.info("Token validated");
            return 1;
        } catch (ExpiredJwtException e) {
            // 토큰이 만료된 경우
            log.info("Token is expired");
            return 2;
        } catch (Exception e) {
            // 복호화 과정에서 에러 발생
            log.info("Token is not valid");
            return 3;
        }
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = Base64.getDecoder().decode(jwtProrerties.getSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
