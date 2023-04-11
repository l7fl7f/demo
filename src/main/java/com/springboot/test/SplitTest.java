package com.springboot.test;

public class SplitTest {
    public static void main(String[] args) {

        String LspFtpTest = "ftp://syftp:sy!2f4#tp@192.168.31.252:21/workftp/epgs/sichuan/scdx/panda/CDTVepg.tar";
        LspFtpTest = LspFtpTest.substring(LspFtpTest.indexOf("ftp://") + "ftp://".length());
        String remoteFilePath = LspFtpTest.substring(LspFtpTest.indexOf("/"));


        String tempFile = "/syiptv/tomcat/smpl/model/CDTVepg_official/temp/CDTVepg/config/ShowException.jsp";

        String path = tempFile.split("/syiptv/tomcat/smpl/model/CDTVepg_official/temp")[1];
        String remotePath = remoteFilePath.substring(0, remoteFilePath.lastIndexOf("/")) + path;
        System.out.println(remotePath);
    }
}
