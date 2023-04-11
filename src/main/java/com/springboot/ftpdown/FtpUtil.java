package com.springboot.ftpdown;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;

public class FtpUtil {

    public static boolean ftpFile(String ftpIp, String name, String passwd, String sourceFile, String targetPath, String targetFileName) {
        boolean flag = false;
        FTPClient ftpClient = new FTPClient();
        FileInputStream fis = null;
        System.out.println("ftpIp=[" + ftpIp + "] name=[" + name + "] passwd=[" + passwd + "]");
        System.out.println("sourceFile=[" + sourceFile + "]");
        System.out.println("targetPath=[" + targetPath + "]");
        System.out.println("targetFileName=[" + targetFileName + "]");
        System.out.println("开始");
        try {
            ftpClient.connect(ftpIp);
            ftpClient.login(name, passwd);
            int replyCode = ftpClient.getReplyCode(); //是否成功登录服务器
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("replyCode=====" + replyCode);
                return flag;
            }
            ftpClient.enterLocalPassiveMode();
            System.out.println("connect to server, success!");
            File srcFile = new File(sourceFile);
            fis = new FileInputStream(srcFile);
            //创建上传目录
            System.out.println("//创建上传目录");
            CreateDirecroty(targetPath, ftpClient);
            // 设置上传目录
            ftpClient.changeWorkingDirectory(targetPath);
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("UTF-8");
            // 设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.storeFile(targetFileName, fis);
            flag = true;
            System.out.println("ftp file to " + ftpIp + ", success!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("connect to server, fail!");
        } finally {
            IOUtils.closeQuietly(fis);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("closed ftp server, fail!");
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        /*		FtpUtil.ftpFile("118.123.189.73", "syftp", "sy!2f4#tp", "D:/data/PIC/2019/09/18/51FC8296E9B04CAB959D14AF7997FFEA.png", "/workftp/adManger/PIC/2019/09/18", "51FC8296E9B04CAB959D14AF7997FFEA.png");
         */        //ftp://ftper:jUhqC8_F6MnR@182.138.30.139:21/TYzte/images/3dca29a1942949c4b9acd05235e474e4.jpg
        downloadFtpFile("182.138.30.139", "ftper", "jUhqC8_F6MnR", 21, "/TYzte/images/52b0045d3cb1499dad7a96b5e0dc450a.jpg", "D:/ftp", "52b0045d3cb1499dad7a96b5e0dc450a.jpg");

    }

    //创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
    public static boolean CreateDirecroty(String remote, FTPClient ftpClient) throws IOException {
        boolean success = true;
        String directory = remote + "/";
//        String directory = remote.substring(0, remote.lastIndexOf("/") + 1);
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory), ftpClient)) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            String path = "";
            String paths = "";
            while (true) {

                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + "/" + subDirectory;
                if (!existFile(path, ftpClient)) {
                    if (makeDirectory(subDirectory, ftpClient)) {
                        changeWorkingDirectory(subDirectory, ftpClient);
                    } else {
                        System.out.println("创建目录[" + subDirectory + "]失败");
                        changeWorkingDirectory(subDirectory, ftpClient);
                    }
                } else {
                    changeWorkingDirectory(subDirectory, ftpClient);
                }

                paths = paths + "/" + subDirectory;
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

    //创建目录
    public static boolean makeDirectory(String dir, FTPClient ftpClient) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                System.out.println("创建文件夹" + dir + " 成功！");

            } else {
                System.out.println("创建文件夹" + dir + " 失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    //改变目录路径
    public static boolean changeWorkingDirectory(String directory, FTPClient ftpClient) {
        boolean flag = true;
        try {
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                System.out.println("进入文件夹" + directory + " 成功！");

            } else {
                System.out.println("进入文件夹" + directory + " 失败！");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flag;
    }

    //判断ftp服务器文件是否存在
    public static boolean existFile(String path, FTPClient ftpClient) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }

    public static boolean downloadFtpFile(String ftpHost, String ftpUserName,
                                          String ftpPassword, int ftpPort, String ftpPath, String localPath,
                                          String fileName) throws RuntimeException {
        boolean flag = false;
        FTPClient ftpClient = null;
        try {
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.setControlEncoding("UTF-8"); // 中文支持  
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);
//            File localFile = new File(localPath + File.separatorChar + fileName);
            File localFile = new File("/syiptv" + localPath);
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
            ftpClient.retrieveFile(ftpPath, os);
            os.close();
            ftpClient.logout();
            flag = true;
        } catch (FileNotFoundException e) {
            System.out.println("没有找到" + ftpPath + "文件");
            e.printStackTrace();
            throw new RuntimeException("没有找到" + ftpPath + "文件:", e);
        } catch (SocketException e) {
            System.out.println("连接FTP失败.");
            e.printStackTrace();
            throw new RuntimeException("连接FTP失败:", e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取错误。");
            e.printStackTrace();
            throw new RuntimeException("文件读取错误:", e);
        }
        return flag;
    }

    public static boolean downloadFtpFile(FTPClient ftpClient, String ftpPath, String localPath) throws Exception {
        boolean flag = false;
        try {
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);
            // 判断ftp文件存不存在
            FTPFile[] fileArray = ftpClient.listFiles(ftpPath);
            if (fileArray.length == 0) {
                System.out.println("远程文件不存在");
                return flag;
            }
            File localFile = new File("/syiptv/" + localPath);
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
            ftpClient.retrieveFile(ftpPath, os);
            os.close();
            flag = true;
        } catch (FileNotFoundException e) {
            System.out.println("没有找到" + ftpPath + "文件");
            e.printStackTrace();
            throw new RuntimeException("没有找到" + ftpPath + "文件:", e);
        } catch (SocketException e) {
            System.out.println("连接FTP失败.");
            e.printStackTrace();
            throw new RuntimeException("连接FTP失败:", e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取错误。");
            e.printStackTrace();
            throw new RuntimeException("文件读取错误:", e);
        }
        return flag;
    }

    public static FTPClient getFTPClient(String ftpHost, String ftpUserName,
                                         String ftpPassword, int ftpPort) throws RuntimeException {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器  
            ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器  
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                System.out.println("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("FTP的IP地址可能错误，请正确配置。");
            throw new RuntimeException("FTP的IP地址可能错误，请正确配置！", e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FTP的端口错误,请正确配置。");
            throw new RuntimeException("FTP的端口错误,请正确配置！", e);
        }
        return ftpClient;
    }

}