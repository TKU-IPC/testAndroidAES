package com.example.catseng6606.testandroidaes;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by catseng6606 on 2018/1/8.
 */

public class AES128Helper {
    //final static String AES_KEY = "b16920894899c7780b5fc7161560a41";

    public static String getKey(String AES_KEY) // 補足 16 位數
    {
        String strPadding = "1234567890123456";
        try {
            AES_KEY = (AES_KEY + "1234567890123456").substring(0, 16);
        } catch (Exception ex) {
            AES_KEY = strPadding;
        }
        return AES_KEY;
    }

    /*
     * AES加密
     *
     * @param text 待加密字符串
     * @return 加密後字符串
     */
    public static String AESEncrypt(String text, String AES_KEY) {
        try {
            String password = getKey(AES_KEY);
            SecretKeySpec skeySpec = new SecretKeySpec(password.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            String strTmp = Base64.encodeToString(cipher.doFinal(text.getBytes()), Base64.DEFAULT);
            return strTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * AES解密
     *
     * @param text 待解密字符串
     * @return 解密後字符串
     */
    public static String AESDecrypt(String text, String AES_KEY) {
        try {
            String password = getKey(AES_KEY);
            SecretKeySpec skeySpec = new SecretKeySpec(password.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            String strTmp = new String(cipher.doFinal(Base64.decode(text, Base64.DEFAULT)));
            return strTmp;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return text;
    }
}
