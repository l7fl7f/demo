package com.springboot.constants;

import java.util.Hashtable;

public class ErrorCodeConstant {
    /**
     * 存放错误代码和描述信息对照表
     */
    public static Hashtable interErrorInfoTable = new Hashtable();

    /**
     * 定义一些常用的错误消息的提示 公共类
     */
    public static final int INTERFACE_OK = 0;

    static {
        interErrorInfoTable.put("PI_" + INTERFACE_OK, "处理成功");
    }

    public static final int INTERFACE_FAIL = 1;

    static {
        interErrorInfoTable.put("PI_" + INTERFACE_FAIL, "处理失败");
    }

    /** 得到提示消息的信息 * */
    public static String getPromptInfo(int code) {
        return (String) interErrorInfoTable.get("PI_" + code);
    }

    /** 得到相应的提示信息* */
    public static String getErrorInfo(int code) {
        return getPromptInfo(code);
    }


}
