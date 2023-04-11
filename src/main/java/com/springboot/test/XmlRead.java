package com.springboot.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

public class XmlRead {
    public static void main(String[] args) {
//        try {
//            File file1 = new File("C:\\Users\\lqf\\Desktop\\test.xml");
//            SAXReader reader = new SAXReader();
//            Document document = reader.read(file1);
//            String s = document.asXML();
//            Element root = document.getRootElement();
//
//            File file2 = new File("C:\\Users\\lqf\\Desktop\\test1.xml");
//            OutputStream out = null;
//            BufferedWriter bw = null;
//            try {
//                out = new FileOutputStream(file2);
//                bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
//                bw.write(s);
//                bw.flush();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    out.close();
//                    bw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><ns1:ResultNotifyResponse soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"iptv\"><ResultNotifyReturn href=\"#id0\"/></ns1:ResultNotifyResponse><multiRef id=\"id0\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns2:CSPResult\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns2=\"iptv\"><Result xsi:type=\"xsd:int\">0</Result><ErrorDescription xsi:type=\"xsd:string\">Process ok</ErrorDescription></multiRef></soapenv:Body></soapenv:Envelope>";
        try {
            Document dom= DocumentHelper.parseText(str);
            Element root=dom.getRootElement();
            List<Element> root1=root.elements();
            List<Element> root2=root1.get(0).elements();
            List<Element> root3=root2.get(0).elements();
            String code = root3.get(0).element("Result").getText();
            String msg = root3.get(0).element("ErrorDescription").getText();
        }catch (Exception e){
            //兼容resultNotifyReturn 标签不是直接带有结果的，而是使用href="#id0"链接到multiRef标签
            try{
                Document dom = DocumentHelper.parseText(str);
                Element root = dom.getRootElement();
                Element body = root.element("Body");
                List<Element> multiRefList = body.elements("multiRef");
                String msg = "";
                String code = "";
                for (Element multiRef : multiRefList) {
                    if (msg == null || msg.length() == 0 || "null".equals(msg)) {
                        msg = multiRef.elementText("ErrorDescription");
                    }
                    if (code == null || code.length() == 0 || "null".equals(code)) {
                        code = multiRef.getText();
                    }
                }
            }catch (Exception ee){
                ee.printStackTrace();
                System.out.println("ee"+e);
            }

        }
    }
}
