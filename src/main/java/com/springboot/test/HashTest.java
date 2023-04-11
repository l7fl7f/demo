package com.springboot.test;

public class HashTest {
    public static void main(String[] args) {
//        char c = 'a';
//        int i = 0;
//        System.out.println(0 + c);
//        System.out.println("漫漫".hashCode());

//        String url = "ftp://wacos:wacos@172.25.116.7:21//opt/wacos/CTMSData/picture/2017/12/18/20171218115313_129431.jpg";
//        String localPath = url.substring(url.indexOf("picture"));
//        String s = url.split(":21")[1];
//        System.out.println(s);


        String localFilePath = "/syiptv/vftpdata/vuser1/c1/model/tysx/20200318/95cbe7b9bb244b3f9ba98acff1e7b005/test20191127.zip";

        String ftpRoot = "ftp://syftp:sy!2f4#tp@192.168.31.252:21/workftp/epgs";

        String destPath = "/sichuan/tysx/tysx_epg/test";

        uploadToDev(localFilePath, ftpRoot, destPath);

    }

    public static void uploadToDev(String localFilePath, String ftpRoot, String destPath) {
        Boolean flag = false;
        String LspFtpTest = ftpRoot;
        String ftpUname = LspFtpTest.substring(LspFtpTest.indexOf("//") + 2).substring(0, LspFtpTest.substring(LspFtpTest.indexOf("//") + 2).indexOf(":"));
        String ftpPwd = LspFtpTest.substring(LspFtpTest.indexOf("//") + 2).substring(LspFtpTest.substring(LspFtpTest.indexOf("//") + 2).indexOf(":") + 1, LspFtpTest.substring(LspFtpTest.indexOf("//") + 2).indexOf("@"));
        String url = LspFtpTest.substring(LspFtpTest.indexOf("//") + 2).substring(LspFtpTest.substring(LspFtpTest.indexOf("//") + 2).indexOf("@") + 1);
        String host = url.substring(0, url.indexOf(":"));
        String port = url.substring(url.indexOf(":") + 1, url.indexOf("/"));
        String ftpPathTest = url.substring(url.indexOf("/")) + destPath;
//            String unzipTemp = interfaceParamService.getParaValue("C1_UNZIP_TEMP", "/syiptv/tomcat/unzip");
//            Map temp = zipGetFileData(localFilePath, unzipTemp);
//            String code = (String) temp.get("code");
//            if ("0".equals(code)) {
//                return flag;
//            }
//            String data = (String) temp.get("data");
//            String[] tempFiles = data.substring(0, data.length() - 1).split("#");

//            FTPUtil ftpUtil = new FTPUtil(host, Integer.parseInt(port), ftpUname, ftpPwd);
//            try {
//                if (ftpUtil.connect()) {
//                }
//            } catch (Exception e) {
//                log.error("建立FTP失败" + e.getMessage());
//                return flag;
//            }
//            for (String localpath : tempFiles) {
//                try {
//                    FTPUtil.UploadStatus uploadStatus = null;
                    String localpath = "/syiptv/tomcat/unzip/test20191127.html";
                    String romtepath = ftpPathTest + localpath.substring(localpath.lastIndexOf("/"));
//                    uploadStatus = ftpUtil.upload2(localpath, romtepath);
//                    ftpUtil.initPath();
//                    if (uploadStatus == FTPUtil.UploadStatus.Upload_From_Break_Failed) {
//                        return flag;
//                    }
//                } catch (Exception e) {
//                    log.error("文件上传FTP失败:" + e.getMessage());
//                    return flag;
//                }
//            }
//        } else {
//            if (!ToolUtil.ftpUpload(localFilePath, ftpRoot + destPath + "/" + localFilePath.substring(localFilePath.lastIndexOf("/") + 1))) {
//                return false;
//            }
        System.out.println();
    }
}
