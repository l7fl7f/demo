package com.springboot.utils;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTools {


    /**
     * Description: 根据格式返回字符类型数据 "yyyy-MM-dd HH:mm:ss"
     *
     * @param
     * @return Date
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String getDate(String strFormat) {

        Date myDate = new Date();
        SimpleDateFormat formater = new SimpleDateFormat(strFormat);
        String strDate = formater.format(myDate);

        return strDate;
    }

    public static String getLastDate(String strFormat) {
        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date start = calendar.getTime();
        String lastDay = format.format(start);


        return lastDay;
    }


    /**
     * Description: 根据格式返回日期类型数据 "yyyy-MM-dd HH:mm:ss"
     *
     * @param
     * @return Date
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static Date getNowDate(String strFormat) {
        Date dateBack = null;
        try {
            Date date = new Date();
            SimpleDateFormat formater = new SimpleDateFormat(strFormat);
            String strDate = formater.format(date);
            dateBack = formater.parse(strDate);
        } catch (Exception e) {
            return null;
        }
        return dateBack;
    }

    /**
     * Description: 根据格式返回日期类型数据 "yyyy-MM-dd HH:mm:ss"
     *
     * @param
     * @return Date
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String getFormatDate(String strFormat, Date date) {
        String strDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat(strFormat);
            strDate = formater.format(date);
        } catch (Exception e) {
            return null;
        }
        return strDate;
    }

    /**
     * Description: 根据格式返回日期类型数据 "yyyy-MM-dd HH:mm:ss"
     *
     * @param
     * @return Date
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static Date getFormatDate(Date date, String strFormat) {
        Date myDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat(strFormat);
            myDate = formater.parse(formater.format(date));
        } catch (Exception e) {
            return null;
        }
        return myDate;
    }

    /**
     * @return
     * @description 返回当前月月底日期和零时 "yyyy-MM-dd HH:mm:ss"
     * @author lzp
     * @date 2009-5-5
     * @version 1.0.0
     */
    public static Date getFirstDate() {
        Calendar cal = Calendar.getInstance();
        int maxDate = cal.getActualMaximum(Calendar.DATE);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), maxDate, 23,
                59, 59);
        return cal.getTime();
    }

    /**
     * @return
     * @description 返回当前日期N天之后的日期 "yyyy-MM-dd HH:mm:ss"
     * @author lzp
     * @date 2009-5-5
     * @version 1.0.0
     */
    public static Date getAfterDate(int N) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, N);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal
                .get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return cal.getTime();
    }

    /**
     * @return
     * @description 返回当前时间N小时之后的时间Date
     * @author chenwei
     * @date 2009-9-3
     * @version 1.0.0
     */
    public static Date getAfterNHourDate(int N) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, N);
        return cal.getTime();
    }

    /**
     * @param n
     * @return
     * @description 返回当前时间n分钟之后的时间Date
     * @author sunlei
     * @date 2010-8-5
     * @version 1.0.0
     * @history1:@author;@date;@description
     * @history2:@author;@date;@description
     */
    public static Date getAfterNMinDate(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, n);
        return cal.getTime();
    }

    /**
     * @return
     * @description 判断当前时间是否在时间date2之前 "yyyy-MM-dd HH:mm:ss"
     * @author chenwei
     * @date 2009-9-3
     * @version 1.0.0
     */
    public static boolean isDateBefore(String date2) {
        try {
            Date date1 = new Date();
            DateFormat df = DateFormat.getDateTimeInstance();
            return date1.before(df.parse(date2));
        } catch (ParseException e) {
            System.out.print("[SYS] " + e.getMessage());
            return false;
        }
    }

    /**
     * @return
     * @Description:获取当前时间的下个月月底日期和零时 "yyyy-MM-dd HH:mm:ss"
     * @author sunxh
     * @Date:2013-7-19 下午5:44:37
     * @version 1.0.0
     */
    public static Date getSecondDate() {
        Calendar cal = Calendar.getInstance();
        int maxDate = cal.getActualMaximum(Calendar.DATE);
        cal.add(Calendar.MONTH, +1);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), maxDate, 23,
                59, 59);
        return cal.getTime();
    }

    /**
     * @param strFormat
     * @return
     * @description 获取数据库操作时间
     * @author xiajie
     * @date 2011-5-4
     * @version 1.0.0
     * @history1:@author;@date;@description
     * @history2:@author;@date;@description
     */
    public static Timestamp getTimestamp(Date date) {

        if (null == date) {
            return new Timestamp(System.currentTimeMillis());
        }
        return new Timestamp(date.getTime());
    }

    public static void main(String[] args) {
//    	String desc ="ChangingPolicyDesc20161104183844@##KEY##@10$subc01FL3Ix61M280wIg000000139258";
//        String msg = "尊敬的用户：您的ITV于##DATE##订购了\"##NAME##\"业务，消费##FEE##元，有效期30天(到期自动续订)，感谢您对我们业务的支持。【重庆电信】";
//        String string = null;
//
//        double realFee = Integer.parseInt(string);
//        String date = TimeTools.getDate("yyyy年MM月dd日HH时mm分ss秒");
////		String msg = "";
//
//        System.out.println(msg.replaceAll("##DATE##", date).replaceAll("##NAME##", "炫动游戏").replaceAll("##FEE##", String.valueOf(realFee)));


        String s = TimeTools.getLastDate("yyyyMMdd");
        System.out.println("s:"+s);
//    	System.out.println(desc.replaceAll("##KEY##", "123"));
//    	System.out.println(desc.substring(desc.indexOf("@")+1,desc.indexOf("$")));
        //yyyy-MM-dd HH:mm:ss
//    	String fee = "1600";
//    	double realFee = Integer.parseInt(fee)/100.0;
//    	System.out.println(realFee);

//    	System.out.println(getDate("yyyy年MM月dd日HH时mm分ss秒"));

//        Date now = new Date();
//        System.out.println(DateUtil.formatLongDate(now));
//        
//        Date nMinDate = TimeTools.getAfterNMinDate(22);
//        System.out.println(DateUtil.formatLongDate(nMinDate));
//    	String string = "short 中文:6666";
//    	byte[] Content = string.getBytes();
//    	for(int i = 0; i < Content.length; i++)
//            if(Content[i] > 127 || Content[i] < 0)
//                System.out.println(15);
//
//        System.out.println(0);
//    	
//    	System.out.println(DateUtil.formatDate(new Date(),
//					"yyyyMMddHHmmssSSS")+Tools.getRandomNum(6));
//    	
//    	
//    	if (DateUtil.parseStr2Date("20141231235959")
//				.after(TimeTools.getSecondDate())) {
//    		System.out.println("==========");
//		}else {
//			System.out.println("--------");	
//			
//		}
//    	System.out.println(getFormatDate("yyyyMMddHHmmss",TimeTools.getSecondDate()));
    }

    /**
     * @param date
     * @return
     * @Description:返回日期类型数据 "yyyy-MM-dd HH:mm:ss:SSS"
     * @author sunxh
     * @Date:2012-8-30 上午10:42:57
     * @version 1.0.0
     */
    public static String getFormatTime(Date date) {
        String strDate = "";
        String strFormat = "yyyy-MM-dd HH:mm:ss.SSS";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(strFormat);
            strDate = formater.format(date);
        } catch (Exception e) {
            return strDate;
        }
        return strDate;
    }

    /**
     * @param n
     * @return
     * @description 获取N秒之后的时间
     * @author sunlei
     * @date 2010-12-15
     * @version 1.0.0
     * @history1:@author;@date;@description
     * @history2:@author;@date;@description
     */
    public static Date getAfterNSecDate(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, n);
        return cal.getTime();
    }

    /**
     * 获取当前时间前N秒的时间
     *
     * @param @param  n
     * @param @return 设定文件
     * @return Date    返回类型
     * @throws
     * @Title: getBeforeNSecDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author wsr
     * @date 2015-8-6 上午10:25:56
     */
    public static Date getBeforeNSecDate(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, -n);
        return cal.getTime();
    }

    /**
     * 获取默认时间
     */
    public static Timestamp getTimestampDefault(Date date) {

        if (null == date) {
            return new Timestamp(getDateFromString("1900-01-01 00:00:00").getTime());
        }
        return new Timestamp(date.getTime());
    }

    public static Date getDateFromString(String dateStr) {
        Date myDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            myDate = formater.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
        return myDate;
    }

    /**
     * @description 返回当前月月底日期和零时 "yyyy-MM-dd HH:mm:ss"
     */
    public static Date getLastDateOfMonth() {
        Calendar cal = Calendar.getInstance();
        int maxDate = cal.getActualMaximum(Calendar.DATE);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), maxDate, 23, 59, 59);
        return cal.getTime();
    }

    /**
     * @param date
     * @return
     * @Description:四川用户在退订包月产品后的失效日期，规则为：订购月+1，订购日-1，23时59分59秒
     * @author sunxh
     * @Date:2013-7-17 下午5:33:31
     * @version 1.0.0
     */
    public static Date getExpireTime(Date orderDate) {
        if (null == orderDate) {
            return null;
        }

        //订购日
        int orderDD = Integer.parseInt(new SimpleDateFormat("dd").format(orderDate));

        Date unorderDate = new Date();//退订时间

        //退订日
        int unorderDD = Integer.parseInt(new SimpleDateFormat("dd").format(unorderDate));

        Calendar cal = Calendar.getInstance();
        cal.setTime(unorderDate);

        //退订日大于等于订购日时，失效月份+1
        if (unorderDD >= orderDD) {
            cal.add(Calendar.MONTH, 1);
        }

        int maxDate = cal.getActualMaximum(Calendar.DATE);
        if (orderDD > maxDate) {
            cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), maxDate, 23, 59, 59);
        } else {
            cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), orderDD, 23, 59, 59);
            cal.add(Calendar.DAY_OF_MONTH, -1);//日期-1
        }

        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return cal.getTime();
    }

    /**
     * 获取N天之后的日期
     *
     * @param date
     * @param N
     * @return Date
     * @Title: getAfterNDayDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author sunxh
     * @date 2017-11-9 下午8:08:10
     */
    public static Date getAfterNDayDate(Date date, int N) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, N);
        return cal.getTime();
    }

    /**
     * Description: 获取订购不自动续订时包月计费订购失效时间
     *
     * @return Date
     * @Title: getExpireTimeOfPackMonth
     * @Description: 获取订购不自动续订时包月计费订购失效时间
     * @author zhaoyj
     * @Date:2015-9-11 下午3:33:31
     */
//    public static Date getExpireTimeOfPackMonth(Date subscribeTime) {
//        // 当前时间
//        Calendar cal = Calendar.getInstance();
//
//        try {
//
//            Integer chargingPolicy = IptvConfig.getChargingPolicy();
//
//            // 按固定时段续包月,失效时间的时分秒为订购时间的时分秒
//            if(chargingPolicy == SyscodeBeanConstant.CHARGING_POLICY_FIXEDTIME)
//            {
//                Calendar cal_SubscribeTime = Calendar.getInstance();
//                cal_SubscribeTime.setTime(subscribeTime);
//                // 固定天数
//                Integer fixedTime = IptvConfig.getFixedTime();
//
//                cal.add(Calendar.DATE, fixedTime);
//
//                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE),
//                        cal_SubscribeTime.get(Calendar.HOUR_OF_DAY), cal_SubscribeTime.get(Calendar.MINUTE), cal_SubscribeTime.get(Calendar.SECOND));
//            }
//         // 固定时段续包月,按固定时段续包月,失效时间的时分秒为235959
//            else if(chargingPolicy == SyscodeBeanConstant.CHARGING_POLICY_FIXEDTIME_FIVE)
//            {
//                // 固定天数
//                Integer fixedTime = IptvConfig.getFixedTime();
//
//                cal.add(Calendar.DATE, fixedTime);
//
//                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23,
//                    59, 59);
//            }
//            // 当月订购日至下月当日续包月
//            else if(chargingPolicy == SyscodeBeanConstant.CHARGING_POLICY_TODAYTONEXT)
//            {
//                cal.add(Calendar.MONTH, 1);
//                cal.add(Calendar.DATE, -1);
//                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23,
//                        59, 59);
//            }
//            // 普通包月或按天续包月
//            else
//            {
//                int maxDate = cal.getActualMaximum(Calendar.DATE);
//                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), maxDate, 23,
//                    59, 59);
//            }
//
//        } catch (Exception e) {
//            Log.error("获取包月计费订购失效时间:",e);
//        }
//
//        return cal.getTime();
//    }

    // 宽带托收，自动包月，失效时间
    public static Date getLongYearAfter() {
        return getDateFromString("2099-12-31 23:59:59");
    }
}
