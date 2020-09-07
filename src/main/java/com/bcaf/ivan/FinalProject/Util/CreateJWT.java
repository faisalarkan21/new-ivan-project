package com.bcaf.ivan.FinalProject.Util;


import com.bcaf.ivan.FinalProject.Entity.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreateJWT {

    public String buildJWT(String userId, String agencyId, User user) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("a11ea930e241e6d7af0e9e6e941905bf03a53984a9faec14bfcd559b9129599093b78e737df420436e9ba847909757786ea7e6bd3205522b5bcd89882d3a18a7");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());


        Map dataUser = new HashMap<String, Object>();
        dataUser.put("userId", userId);
        dataUser.put("name", user.getFirstName() + " " + user.getLastName());
        dataUser.put("email", user.getEmail());
        dataUser.put("agencyId", agencyId);

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                .setClaims(dataUser)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, signingKey);


        long expMillis = nowMillis + 31536000000L; // 1 year expire
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);


        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
}
