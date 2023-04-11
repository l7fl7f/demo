package com.springboot.test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IPTest {
    public static void main(String[] args) {
        try {
            String s1 = InetAddress.getLocalHost().getHostAddress();
            String s2 = InetAddress.getLocalHost().getHostName();
            byte[] s3 = InetAddress.getLocalHost().getAddress();
//            System.out.println(s1);
//            System.out.println(s2);
//            System.out.println(s3);
            Enumeration<NetworkInterface> netInterfaces = null;
            try {
                netInterfaces = NetworkInterface.getNetworkInterfaces();
                while (netInterfaces.hasMoreElements()) {
                    NetworkInterface ni = netInterfaces.nextElement();
                    System.out.println("DisplayName:" + ni.getDisplayName());
                    System.out.println("Name:" + ni.getName());
                    Enumeration<InetAddress> ips = ni.getInetAddresses();
                    while (ips.hasMoreElements()) {
                        System.out.println("IP:" + ips.nextElement().getHostAddress());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
