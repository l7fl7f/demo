package com.springboot.utils;

import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * AES128 算法
 * <p>
 * CBC 模式
 * <p>
 * PKCS7Padding 填充模式
 * <p>
 * CBC模式需要添加一个参数iv
 * <p>
 * 介于java 不支持PKCS7Padding，只支持PKCS5Padding 但是PKCS7Padding 和 PKCS5Padding 没有什么区别
 * 要实现在java端用PKCS7Padding填充，需要用到bouncycastle组件来实现
 */
public class AESUtil {
    // 算法名称
    private final static String KEY_ALGORITHM = "AES";
    // 加解密算法/模式/填充方式
    private final static String algorithmStr = "AES/CBC/PKCS5Padding";
    //字符集
    private final static String CODE_TYPE = "UTF-8";
    // 偏移量
    private static final String IV = "0102030405060708";
    //以加 解密方式+密钥+偏移量作为key -- 防止多线程冲突
    private static Map<String, Cipher> cipherMap = new HashMap<String, Cipher>();

    /**
     * 初始化
     *
     * @param model     Cipher.ENCRYPT_MODE ， Cipher.DECRYPT_MODE
     * @param keyString
     * @param iv
     * @throws Exception
     */
    private static Cipher getCipher(int model, String keyString, String iv) throws Exception {

        //以加 解密方式+密钥+偏移量作为key -- 防止多线程冲突
        String tdName = Thread.currentThread().getName();
        String mapkey = model + keyString + iv + tdName;
        Cipher cipher = cipherMap.get(mapkey);

        if (cipher != null) {
            return cipher;
        }

        // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
        int base = 16;
        byte[] keyBytes = keyString.getBytes();
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 初始化
//        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        Key key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);

        // 初始化cipher
        cipher = Cipher.getInstance(algorithmStr);

        cipher.init(model, key, new IvParameterSpec(iv.getBytes()));
        //放入map中
        cipherMap.put(mapkey, cipher);
        return cipher;

    }

    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 加密方法
     *
     * @param content   要加密的字符串
     * @param keyString 加密密钥
     * @return
     */
    public static String encrypt(String content, String keyString) {
        try {
            if (StringUtils.isEmpty(content)) {
                return "";
            }

            byte[] contentBytes = content.getBytes(CODE_TYPE);
            // 初始化
            Cipher cipher = getCipher(Cipher.ENCRYPT_MODE, keyString, IV);
            byte[] encryptedText = cipher.doFinal(contentBytes);
            return parseByte2HexStr(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密方法
     *
     * @param encryptedData 要解密的字符串
     * @param keyString     解密密钥
     * @return
     */
    public static String decrypt(String encryptedData, String keyString) {
        try {
            if (StringUtils.isEmpty(encryptedData)) {
                return "";
            }

            byte[] encryptedBytes = parseHexStr2Byte(encryptedData);
            // 初始化
            Cipher cipher = getCipher(Cipher.DECRYPT_MODE, keyString, IV);

            byte[] encryptedText = cipher.doFinal(encryptedBytes);
            return new String(encryptedText, CODE_TYPE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) throws Exception {
        String content = "B8:87:6E:16:BF:A0";
        String password = "!@45pD_f";
        String str = encrypt(content, password);
        System.out.println("加密后:" + str);
        String str2 = decrypt(str, password);
        System.out.println("解密后：" + str2);
    }
}