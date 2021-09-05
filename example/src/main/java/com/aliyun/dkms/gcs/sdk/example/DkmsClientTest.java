package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.*;
import com.aliyun.tea.TeaException;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;


class DkmsClientTest {
    private static String clientKeyContent = "client key content";
    private static String clientKeyPassword = "client key password";
    private static String endpoint = "crypto service address";
    private static Client client;

    private static void encrypt() {
        String encryptionKeyId = "CmkId";
        String plaintext = "this is test";

        EncryptRequest encryptRequest = new EncryptRequest();
        encryptRequest.setKeyId(encryptionKeyId);
        encryptRequest.setPlaintext(plaintext.getBytes(StandardCharsets.UTF_8));
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //EncryptResponse encryptResponse = client.encrypt(encryptRequest);
            EncryptResponse encryptResponse = client.encryptWithOptions(encryptRequest, runtimeOptions);
            System.out.printf("encrypt response KeyId: %s\n", encryptResponse.getKeyId());
            System.out.printf("encrypt response CiphertextBlob: %s\n", new String(Hex.encode(encryptResponse.getCiphertextBlob())));
            System.out.printf("encrypt response RequestId: %s\n", encryptResponse.getRequestId());
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("encrypt error code: %s\n", ((TeaException) e).getCode());
                System.out.printf("encrypt error message: %s\n", ((TeaException) e).getMessage());
                System.out.printf("encrypt error httpCode: %s\n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("encrypt error hostId: %s\n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("encrypt error requestId: %s\n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("encrypt errMsg: %s\n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void decrypt() {
        String encryptionKeyId = "CmkId";
        byte[] ciphertextBlob = Hex.decode("ciphertextBlob hex data");

        DecryptRequest decryptRequest = new DecryptRequest();
        decryptRequest.setKeyId(encryptionKeyId);
        decryptRequest.setCiphertextBlob(ciphertextBlob);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //DecryptResponse decryptResponse = client.decrypt(decryptRequest);
            DecryptResponse decryptResponse = client.decryptWithOptions(decryptRequest, runtimeOptions);
            System.out.printf("decryptResponse KeyId: %s\n", decryptResponse.getKeyId());
            System.out.printf("decryptResponse Plaintext: %s\n", new String(decryptResponse.getPlaintext()));
            System.out.printf("decryptResponse RequestId: %s\n", decryptResponse.getRequestId());
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("decrypt error code: %s\n", ((TeaException) e).getCode());
                System.out.printf("decrypt error message: %s\n", ((TeaException) e).getMessage());
                System.out.printf("decrypt error httpCode: %s\n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("decrypt error hostId: %s\n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("decrypt error requestId: %s\n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("decrypt errMsg: %s\n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void hmac() {
        String hmacKeyId = "CmkId";
        String message = "this is test";

        HmacRequest hmacRequest = new HmacRequest();
        hmacRequest.setKeyId(hmacKeyId);
        hmacRequest.setMessage(message.getBytes(StandardCharsets.UTF_8));
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //HmacResponse hmacResponse = client.hmac(hmacRequest);
            HmacResponse hmacResponse = client.hmacWithOptions(hmacRequest, runtimeOptions);
            System.out.printf("hmac response KeyId: %s\n", hmacResponse.getKeyId());
            System.out.printf("hmac response Signature: %s\n", new String(Hex.encode(hmacResponse.getSignature())));
            System.out.printf("hmac response RequestId: %s\n", hmacResponse.getRequestId());
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("hmac error code: %s\n", ((TeaException) e).getCode());
                System.out.printf("hmac error message: %s\n", ((TeaException) e).getMessage());
                System.out.printf("hmac error httpCode: %s\n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("hmac error hostId: %s\n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("hmac error requestId: %s\n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("hmac errMsg: %s\n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void sign() {
        String signKeyId = "CmkId";
        byte[] digest = "this is test".getBytes(StandardCharsets.UTF_8);
        String algorithm = "RSA_PKCS1_SHA_256";

        SignRequest signRequest = new SignRequest();
        signRequest.setKeyId(signKeyId);
        signRequest.setAlgorithm(algorithm);
        signRequest.setDigest(digest);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //SignResponse signResponse = client.sign(signRequest);
            SignResponse signResponse = client.signWithOptions(signRequest, runtimeOptions);
            System.out.printf("sign response KeyId: %s\n", signResponse.getKeyId());
            System.out.printf("sign response Signature: %s\n", new String(Hex.encode(signResponse.getSignature())));
            System.out.printf("sign response RequestId: %s\n", signResponse.getRequestId());
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("sign error code: %s\n", ((TeaException) e).getCode());
                System.out.printf("sign error message: %s\n", ((TeaException) e).getMessage());
                System.out.printf("sign error httpCode: %s\n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("sign error hostId: %s\n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("sign error requestId: %s\n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("sign errMsg: %s\n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void verify() {
        String signKeyId = "CmkId";
        byte[] digest = "this is test".getBytes(StandardCharsets.UTF_8);
        byte[] signature = "this is test".getBytes(StandardCharsets.UTF_8);
        String algorithm = "RSA_PKCS1_SHA_256";

        VerifyRequest verifyRequest = new VerifyRequest();
        verifyRequest.setKeyId(signKeyId);
        verifyRequest.setAlgorithm(algorithm);
        verifyRequest.setDigest(digest);
        verifyRequest.setSignature(signature);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //VerifyResponse verifyResponse = client.verify(verifyRequest);
            VerifyResponse verifyResponse = client.verifyWithOptions(verifyRequest, runtimeOptions);
            System.out.printf("verify response KeyId: %s\n", verifyResponse.getKeyId());
            System.out.printf("verify response Value: %s\n", verifyResponse.getValue());
            System.out.printf("verify response RequestId: %s\n", verifyResponse.getRequestId());
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("verify error code: %s\n", ((TeaException) e).getCode());
                System.out.printf("verify error message: %s\n", ((TeaException) e).getMessage());
                System.out.printf("verify error httpCode: %s\n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("verify error hostId: %s\n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("verify error requestId: %s\n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("verify errMsg: %s\n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void generateRandom() {
        Integer length = 16;
        GenerateRandomRequest generateRandomRequest = new GenerateRandomRequest();
        generateRandomRequest.setLength(length);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //GenerateRandomResponse generateRandomResponse = client.generateRandom(generateRandomRequest);
            GenerateRandomResponse generateRandomResponse = client.generateRandomWithOptions(generateRandomRequest, runtimeOptions);
            System.out.printf("generateRandom response Random: %s\n", new String(Hex.encode(generateRandomResponse.getRandom())));
            System.out.printf("generateRandom response RequestId: %s\n", generateRandomResponse.getRequestId());
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("generateRandom error code: %s\n", ((TeaException) e).getCode());
                System.out.printf("generateRandom error message: %s\n", ((TeaException) e).getMessage());
                System.out.printf("generateRandom error httpCode: %s\n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("generateRandom error hostId: %s\n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("generateRandom error requestId: %s\n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("generateRandom errMsg: %s\n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyContent(clientKeyContent);
        config.setPassword(clientKeyPassword);
        config.setEndpoint(endpoint);
        try {
            client = new Client(config);
            //加密测试
            encrypt();
            //解密测试
            decrypt();
            //Hmac测试
            hmac();
            //签名测试
            sign();
            //验签测试
            verify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}