package edu.miu.cs.cs425.studentmgmt.service.impl;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String extractUsername(String token){
        return null;
    }

//    private Claims extractAllClaims(String token) {
//        return Jwts
//                .parser()
//                .setSigningKey(getSignIKey())
//                .build()
//                .parseClaimsJws
//    }
}
