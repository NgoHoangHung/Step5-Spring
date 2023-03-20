package com.example.assignment19_jwt_bookmanager.security.jwt;

import com.example.assignment19_jwt_bookmanager.security.service.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProcess {
    //tạo đoạn mã bí mật
    private final String secretKey = "hungnh";

    private final long expiried = 3600L;

    //    Tạo ra jwt từ thông tin user
    public String genarateToken(CustomUserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiried);
        return Jwts.builder()
                .setSubject(Long.toString(userDetails.getUser().getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    //Lấy thông tin User từ jwt cho các lần đăng nhập kế tiếp
    public int getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return Integer.parseInt(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException exception) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException exception) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException exception) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException exception) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}


















