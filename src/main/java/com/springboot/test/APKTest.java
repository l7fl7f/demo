package com.springboot.test;

import com.alibaba.fastjson.JSONObject;
import com.springboot.utils.AESUtil;
import com.springboot.utils.DateUtil;
import com.springboot.utils.Hash163;

import java.util.UUID;

public class APKTest {
    public static String timestamp = "20220823103500";
    public static String md5key = "B#V&3X$n0Q6iCb8H";
    public static String aeskey = "!@45pD_f";
    public static String mac = "18:EF:3A:3C:96:64";
    public static String shortmessage = "704388";

    public static void main(String[] args) {
//        maclogin();
//        tokenupdate();
//        shortmessage();
        phonelogin();
//        parsedata();
//        hash163("APK5e6def0918270@ITV");
//        md5test();
//        System.out.println(Long.toHexString(Long.parseLong("17723325502")));
    }

    private static void maclogin() {
        String sign = MD5Util.md5(mac + timestamp + md5key);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("guest", 0);
        jsonObject.put("mac", mac);
        jsonObject.put("timestamp", timestamp);
        jsonObject.put("sign", sign);
        String aes = AESUtil.encrypt(jsonObject.toJSONString(), aeskey);
        System.out.println(aes);
    }

    private static void shortmessage() {
        String sign = MD5Util.md5(mac + timestamp + md5key);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phonenumber", "19950351449");
        jsonObject.put("mac", mac);
        jsonObject.put("timestamp", timestamp);
        jsonObject.put("sign", sign);
        String aes = AESUtil.encrypt(jsonObject.toJSONString(), aeskey);
        System.out.println(aes);
    }

    private static void phonelogin() {
        String sign = MD5Util.md5(mac + timestamp + md5key);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phonenumber", "19950351449");
        jsonObject.put("shortmessage", shortmessage);
        jsonObject.put("mac", mac);
        jsonObject.put("timestamp", timestamp);
        jsonObject.put("sign", sign);
        String aes = AESUtil.encrypt(jsonObject.toJSONString(), aeskey);
        System.out.println(aes);
    }

    private static void parsedata() {
        String data = "6a7b48d7de9b2a2369a4930e6fe8fab5e21a90f7c3fdc7aab4812edfa64dab26bd9518075f970d2627792916ce9eeed58496e3ecb7c503c0bb7e99b149ad8ebac216d7a40c44c2ac0580d73c65416546a3d7c1afeba744c74b1a7b42c0079cd1107358e86229c43ba47cccfca5d856ca";
        String jsonStr = AESUtil.decrypt(data, aeskey);
        System.out.println(jsonStr);
    }

    private static void hash163(String userId) {
        String tableName = "";
        try {
            tableName = Hash163.USERHash(userId, Hash163.USERINFO_TABLE_HEAD);
        } catch (Exception e) {

        }
        System.out.println(tableName);
    }

    private static void tokenupdate() {
        String sign = MD5Util.md5(mac + timestamp + md5key);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", "guest1656929323313225");
        jsonObject.put("mac", "08:00:27:85:9F:18");
        jsonObject.put("token", "1ec99daa8280b20c2dc71b8f6a5790b2");
        jsonObject.put("timestamp", timestamp);
        jsonObject.put("sign", sign);
        String aes = AESUtil.encrypt(jsonObject.toJSONString(), aeskey);
        System.out.println(aes);
    }

    private static void md5test() {
        String dateStr = DateUtil.getDateString2();
        System.out.println(dateStr);
        String transactionId = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(transactionId);
        String sign = transactionId + "APK5e460d471ad34@ITVSC_OASN_0002" + dateStr + "sdfsd12132";
        System.out.println(MD5Util.md5(sign.toLowerCase()));
    }

}
