package com.vocabimate.protocol;

/**
 * Created by Hisham on 12/Oct/2018 - 19:10
 */
public class TokenDecryptionHelper {
    private final String token;
    private final String tokenEncryptedStringFromByteArray;

    public TokenDecryptionHelper(String token, String tokenEncryptedStringFromByteArray) {
        this.token = token;
        this.tokenEncryptedStringFromByteArray = tokenEncryptedStringFromByteArray;
    }

    public byte[] decrypt(){

        String key = token.substring(0, 16);
//        String iv = token.substring(token.length() - 16, token.length());
        String iv = token.substring(token.length() - 17, token.length() - 1); // abcdefgh
        byte[] keyBytes = tokenEncryptedStringFromByteArray.getBytes();
        byte[] decryptKey = AesEncryptionUtil.decrypt(key, iv, keyBytes);
        return decryptKey;
    }
}
