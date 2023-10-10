package com.hanwhalife.common.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.crypto.Cipher;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * RSA 암호화/복호화 유틸
 * 
 * @see 암호화 되는 평문의 최대 길이는 254byte
 */
@Component
public final class RSAUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(RSAUtil.class);

    /**
     * RSA 생성
     */
    public Map<String, Object> createRSA() {

        Map<String, Object> rsaMap = new HashMap<>();

        KeyPairGenerator generator;
        try {
            generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);

            KeyPair keyPair = generator.genKeyPair();
            PublicKey publicKey = keyPair.getPublic(); // 공개키
            PrivateKey privateKey = keyPair.getPrivate(); // 비밀키

            rsaMap.put("rsaTimestamp", new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.KOREAN).format(Calendar.getInstance().getTime()));
            rsaMap.put("rsaPublicKey", publicKey);
            rsaMap.put("rsaPublicKeyBase64", Base64.getEncoder().encodeToString(publicKey.getEncoded()));
            rsaMap.put("rsaPrivateKey", privateKey);
            rsaMap.put("rsaPrivateKeyBase64", Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        } catch (Exception e) {
            LOGGER.error("RSAUtil.getRSA()", e);
        }

        return rsaMap;
    }

    /**
     * 공개키, 타임스탬프 값 을 반환하며 세션에 비밀키 값을 저장한다
     */
    public Map<String, String> initRSA(HttpSession session) {

        Map<String, String> resultMap = new HashMap<>();

        Map<String, Object> rsaMap = this.createRSA();

        String rsaTimestamp = null;
        String rsaPublicKeyBase64 = null;
        String rsaPrivateKeyBase64 = null;

        if (rsaMap != null && !rsaMap.isEmpty()) {
            rsaTimestamp = (String) rsaMap.get("rsaTimestamp");
            rsaPublicKeyBase64 = (String) rsaMap.get("rsaPublicKeyBase64");
            rsaPrivateKeyBase64 = (String) rsaMap.get("rsaPrivateKeyBase64");

            resultMap.put("rsaTimestamp", rsaTimestamp);
            resultMap.put("rsaPublicKeyBase64", rsaPublicKeyBase64);
        }

        if (session != null) {
            this.removeRSASessionValue(session);

            if (rsaPrivateKeyBase64 != null && rsaPrivateKeyBase64.length() > 0) {
                session.setAttribute("rsaTimestamp", rsaTimestamp);
                session.setAttribute("rsaPrivateKeyBase64", rsaPrivateKeyBase64);
            }
        }

        return resultMap;
    }

    /**
     * 공개키, 타임스탬프 값 을 세션에서 제거한다
     */
    public void removeRSASessionValue(HttpSession session) {
        session.removeAttribute("rsaTimestamp");
        session.removeAttribute("rsaPrivateKeyBase64");
    }

    /**
     * 공개키 값을 공개키 객체로 반환함
     */
    private PublicKey getPublicKey(String publicKeyBase64) {

        PublicKey publicKey = null;

        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyBase64.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);

        } catch (Exception e) {
            LOGGER.error("RSAUtil.getPublicKey()", e);
        }

        return publicKey;
    }

    /**
     * 비밀키 값을 비밀키 객체로 반환함
     */
    private PrivateKey getPrivateKey(String privateKeyBase64) {

        KeyFactory keyFactory = null;

        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (Exception e) {
            LOGGER.error("RSAUtil.getPublicKey()", e);
        }

        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyBase64.getBytes()));

        try {
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            LOGGER.error("RSAUtil.getPublicKey()", e);
        }

        return privateKey;
    }

    /**
     * 암호화
     */
    public byte[] encrypt(String data, String publicKeyBase64) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, this.getPublicKey(publicKeyBase64));
        return cipher.doFinal(data.getBytes());
    }

    /**
     * 복호화
     */
    public String decrypt(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
    }

    /**
     * 복호화
     */
    public String decrypt(String data, String privateKeyBase64) throws Exception {
        return decrypt(Base64.getDecoder().decode(data.getBytes()), this.getPrivateKey(privateKeyBase64));
    }

}
