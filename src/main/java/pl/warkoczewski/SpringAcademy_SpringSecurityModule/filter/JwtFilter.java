package pl.warkoczewski.SpringAcademy_SpringSecurityModule.filter;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.util.SecurityConstants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;

import java.util.Base64;
import java.util.Collections;
@Service
public class JwtFilter extends OncePerRequestFilter {
    public JwtFilter() {
        System.out.println(getKeySpecForPrivateKey());
        System.out.println(getKeySpecForPrivateKey().getEncoded());
        System.out.println(getKeySpecForPrivateKey().getFormat());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        try {
            UsernamePasswordAuthenticationToken authenticationToken = getUsernamePasswordAuthenticationToken(authorization);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);
        }catch(InvalidKeySpecException inValid)
        {
            System.out.println("Invalid Key Spec");
        }catch (NoSuchAlgorithmException noSuchAlgorithmException){
            System.out.println("No such algorithm");
        }

    }

    protected UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String authorization) throws InvalidKeySpecException, NoSuchAlgorithmException {
        JWTVerifier jwtVerifier = JWT.require(buildJwtAlgorithm()).build();
        //JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512("eShVmYq3t6w9y$B&E)H@McQfTjWnZr4u7x!A%C*F-JaNdRgUkXp2s5v8y/B?E(G+")).build();
        DecodedJWT verify = jwtVerifier.verify(authorization.substring(7));
        String name = verify.getClaim("name").asString();
        boolean isAdmin = verify.getClaim("admin").asBoolean();
        String role = "ROLE_USER";
        if(isAdmin) {
            role = "ROLE_ADMIN";
        }
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
        return new UsernamePasswordAuthenticationToken(name, null, Collections.singleton(simpleGrantedAuthority));
    }
    protected  Algorithm buildJwtAlgorithm() throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey =  keyFactory.generatePublic(getKeySpecForPublicKey());
        PrivateKey privateKey =  keyFactory.generatePrivate(getKeySpecForPrivateKey());
        /*byte[] publicKeyBytes = SecurityConstants.PUBLIC_KEY.getBytes();
        RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
        byte[] privateKeyBytes = SecurityConstants.PRIVATE_KEY.getBytes();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(new X509EncodedKeySpec(privateKeyBytes));*/
        Algorithm algorithm = Algorithm.RSA512((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
        return algorithm;
    }
    protected X509EncodedKeySpec getKeySpecForPublicKey(){
        String publicKeyString = SecurityConstants.PUBLIC_KEY;
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyString.getBytes()));
        //PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getEncoder().encode(publicKeyString.getBytes()));
        return keySpec;
    }
    protected PKCS8EncodedKeySpec getKeySpecForPrivateKey(){
        String privateKeyString = SecurityConstants.PRIVATE_KEY;
        //X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(privateKeyString.getBytes()));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyString.getBytes()));
        return keySpec;
    }
    protected String getPublicKeyString(){
        String publicKeyString = SecurityConstants.PUBLIC_KEY;
        return publicKeyString;
    }
    protected String getPrivateKeyString(){
        String privateKeyString = SecurityConstants.PRIVATE_KEY;
        return privateKeyString;
    }

}

