package com.springboot.utils;

public class HashUtil {
	private final static int USEE_TABLE_COUNT = 10;// 用户相关表分10张

	// 根据用户名获得HASH值
    static public int hash(String str) {
        int l_power[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
            47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
            113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173};
        int s_sum, i;
        s_sum = 0;
        for (i = 0; i < str.length(); i++ ) {
            s_sum += str.charAt(i) * l_power[i];
        }
        return (s_sum % USEE_TABLE_COUNT);
    }


    public static String calcHashValue(String str)
        throws Exception {
        int sum = -1;
        String ret = "";
        if (str == null || str.length() > 40)
            throw new Exception(
                "Exception in method sHash of class HashUtil:str is null or lenth > 40");
        sum = hash(str.trim());
        if ( (sum < 0) || (sum > USEE_TABLE_COUNT - 1))
            throw new Exception(
                "Exception in method sHash of class HashUtil:error");
        if (sum < 10)
            ret = "0" + sum;
        else if (sum >= 10)
            ret = String.valueOf(sum);
        return (ret);
    }


    public static String getHashValue(String str){
        try {
            return calcHashValue(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
		try {
			System.out.println(getHashValue("3"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
