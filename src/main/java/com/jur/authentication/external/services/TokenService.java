package com.jur.authentication.external.services;

import com.jur.authentication.external.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class TokenService {

    public String generateToken(User user){
        return Jwts.builder()
                .setSubject(user.getName())
                .setExpiration(Date.from(ZonedDateTime.now().plusHours(1).toInstant()))
                .setIssuer(user.getEmail())
                .claim("groups", user.getRoles())
                .signWith(SignatureAlgorithm.HS512, "MTIzNDU2Nzg=").compact();
    }

    private void printStructure(String token) {
        Jws parseClaimsJws = Jwts.parser().setSigningKey("MTIzNDU2Nzg=").parseClaimsJws(token);

        System.out.println("Header     : " + parseClaimsJws.getHeader());
        System.out.println("Body       : " + parseClaimsJws.getBody());
        System.out.println("Signature  : " + parseClaimsJws.getSignature());
    }

    private void printBody(String token) {
        Claims body = Jwts.parser().setSigningKey("MTIzNDU2Nzg=").parseClaimsJws(token).getBody();

        System.out.println("Issuer     : " + body.getIssuer());
        System.out.println("Subject    : " + body.getSubject());
        System.out.println("Expiration : " + body.getExpiration());
    }
}
