package com.kevin.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author caonanqing
 * @version 1.0
 * @description         JWT工具类
 * @createDate 2019/8/19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class JWTUtils {

    /**
     * 加密秘钥
     */
    @Value("${jwt.secret}")
    private String secret;
    /**
     * 有效时间 秒
     */
    @Value("${jwt.expire}")
    private long expire;
    /**
     * 用户凭证
     */
    @Value("${jwt.header}")
    private String header;
    /**
     * 签发者
     */
    @Value("${jwt.iss}")
    private String iss;

    /**
     * 加密算法
     */
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

    /**
     * 签发JWT,创建Token的方法
     * @param username
     * @return  token为一次性，为一个用户的有效登录周期准备的token，用户退出或超时，token失效
     */
    public String createJWT(String username) {

        // 创建时间
        Date nowDate = new Date();
        // 过期时间
        Date expireDate = new Date(nowDate.getTime()+expire*1000);
        // 创建JWT的构建器，就是使用指定的信息和加密算法，生成Token的工具。
        JwtBuilder builder = Jwts.builder()
                // 身份标志，客户端的唯一标识
                .setId(UUID.randomUUID().toString())
                // 默认使用{"typ":"JWT"}
                .setHeaderParam("typ","JWT")
                // 签发者
                .setIssuer(iss)
                // 主题
                .setSubject(username)
                // token生成时间
                .setIssuedAt(nowDate)
                // token过期时间
                .setExpiration(expireDate)
                // 秘钥和算法
                .signWith(signatureAlgorithm, secret);
        // 生成Token
        return builder.compact();
    }

    /**
     * 获取JWT签名信息
     * @param token   就是服务器为客户端生成的签名数据，就是token
     * @return
     */
    public Claims getClaimsToken(String token) {
        try {
            // getBody()获取的就是token中记录的payload数据，就是payload中保存的所有的claims。
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 判断token是否过期
     * @param expiration
     * @return
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

}
