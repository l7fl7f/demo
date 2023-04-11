package com.springboot.c2.utils;

public enum CisExceptionEnum {
    CMDFILEURL_IS_NOT_FTP(0,"cmdFileURL is not ftp"),
    CMDFILEURL_DOWNLOAD_FAILED(0,"cmdFileURL download failed"),
    PARSERXMLFILE_IS_FALSE(0,"parserXmlFile is false"),
    ;
    private int code;
    private String message;

    private CisExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
