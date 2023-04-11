package com.springboot.ftpdown;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        list.add("/syiptv/IPTV/ftp_1.txt");
//        list.add("C:\\Users\\lqf\\Desktop\\ftp_1.txt");
        for (String s : list) {
            execute(s);
        }
    }

    public static void execute(String fileName) throws InterruptedException {
        System.out.println(fileName);
        FTPClient ftpClient = FtpUtil.getFTPClient("172.25.116.7", "wacos", "wacos", 21);
        // 读取文件
        File file = new File(fileName);
        BufferedReader reader = null;
        int num = 0;
        int noFile = 0;
        int err1 = 0;
        int err2 = 0;
        int err3 = 0;
        int err4 = 0;
        Long start = System.currentTimeMillis();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                String ftpUrl = "ftp://wacos:wacos@172.25.116.7:21//opt/wacos/CTMSData/picture/" + tempString.split("\\|")[1];
                num++;
                String temp = ftpUrl.replace("ftp://", "");
                String path = temp.split(":21")[1];
                try {
//                FtpUtil.downloadFtpFile(ftpClient, path, path);
                    ftpClient.setControlEncoding("UTF-8"); // 中文支持
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                    ftpClient.enterLocalPassiveMode();
                    ftpClient.changeWorkingDirectory(path);
                    // 判断ftp文件存不存在
                    FTPFile[] fileArray = ftpClient.listFiles(path);
                    if (fileArray.length == 0) {
//                    System.out.println("远程文件不存在");
                        noFile++;
                        continue;
                    }
                    File localFile = new File("/syiptv/IPTV/" + path);
                    // 本地存在文件就删除
                    if (null != localFile && localFile.exists()) {
                        localFile.delete();
                    }
                    // 本地路径不存在就创建
                    File dir = localFile.getParentFile();
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    OutputStream os = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(path, os);
                    os.close();
                } catch (FileNotFoundException e) {
                    System.out.println("没有找到" + path + "文件");
                    e.printStackTrace();
                    err1++;
//                throw new RuntimeException("没有找到" + path + "文件:", e);
                } catch (SocketException e) {
                    System.out.println("连接FTP失败");
                    e.printStackTrace();
                    err2++;
//                throw new RuntimeException("连接FTP失败:", e);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("文件读取错误");
                    e.printStackTrace();
                    err3++;
//                throw new RuntimeException("文件读取错误:", e);
                } catch (Exception e) {
                    System.out.println("下载失败");
                    err4++;
                }
                if (num % 1000 == 0) {
                    System.out.println(System.currentTimeMillis() + "下载到第" + num + "张图片;耗时：" + (System.currentTimeMillis() - start));
                    start = System.currentTimeMillis();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    ftpClient.logout();
                } catch (IOException e1) {
                    System.out.println("ftp关闭异常");
                    e1.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis() + fileName + "下载完成,总量:" + num + ";下载失败:" + noFile);
            System.out.println(err1);
            System.out.println(err2);
            System.out.println(err3);
            System.out.println(err4);
        }

        // 解析地址
//        String host = "";
//        int port = 21;
//        String user = "";
//        String password = "";
        // 拿第一条地址解析
//        String ftpUrl = urlList.get(0);
//        ftpUrl = ftpUrl.substring(ftpUrl.indexOf("ftp://") + "ftp://".length());
//        String[] tempArray = ftpUrl.substring(0, ftpUrl.indexOf("/")).split("@");
//        if (tempArray.length == 2) {
//            String[] tempArray2 = tempArray[0].split(":");
//            if (tempArray2.length == 2) {
//                user = tempArray2[0];
//                password = tempArray2[1];
//            } else {
//                user = "anonymous";
//                password = "anonymous";
//            }
//            tempArray2 = tempArray[1].split(":");
//            if (tempArray2.length > 0) host = tempArray2[0];
//            if (tempArray2.length > 1) port = Integer.parseInt(tempArray2[1]);
//        }

//        FTPClient ftpClient = FtpUtil.getFTPClient(host, user, password, port);
    }
}
