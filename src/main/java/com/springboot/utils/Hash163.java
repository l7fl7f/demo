package com.springboot.utils;

// 此类处理按hash值分表

public class Hash163 {
    private final static int TABLE_COUNT = 12;// 分表数

    private final static int USEE_TABLE_COUNT = 10;// 用户相关表分10张

    public final static String USERINFO_TABLE_HEAD = "user_";// 用户信息表

    public final static String USER_BOOKMARKS_TABLE_HEAD = "bookmarks_";// 用户书签表

    public final static String USER_FAVORITE_TABLE_HEAD = "favorite_";// 用户收藏表

    public final static String USERCDN_TABLE_HEAD = "I_USERCDN";// 用户能力关联表

    public final static String IPTVINFO_TABLE_HEAD = "I_IPTVINFO";// IPTV能力信息表

    public final static String IPTVLOGIN_TABLE_HEAD = "I_IPTVLOGIN";// IPTV用户登录信息表
    
    public final static String MULLOGIN_TABLE_HEDA = "I_MULLOGIN";// 三屏用户登录信息表

    public final static String SUBSCRIBEINFO_TABLE_HEAD = "user_subscribe_";// 包月定购关系表

    public final static String PPVORDERINFO_TABLE_HEAD = "user_ppvorder_";// 按次定购关系表

    public final static String TEMPSUBSCRIPTION_TABLE_HEAD = "I_TEMPSUBSCRIPTION";// 非包月定购关系表

    public final static String HISTORYINFO_TABLE_HEAD = "I_HISTORYINFO";// 定购历史信息表

    public final static String MOBILEINFO_TABLE_HEAD = "I_MOBILEINFO";// MOBILE能力信息

    public final static String PCINFO_TABLE_HEAD = "I_PCINFO";// PC能力信息

    public final static String FAVORITEINFO_TABLE_HEAD = "I_FAVORITEINFO";// 收藏信息

    public final static String MEETINGINFO_TABLE_HEAD = "I_MEETINGINFO";// 会议能力信息

    public final static String SOFTCLIENTINFO_TABLE_HEAD = "I_SOFTCLIENTINFO";// 软终端能力信息
    
    public final static String SOFTCLIENTONLINEINFO_TABLE_HEAD = "I_SOFTCLIENTONLINEINFO";// 软终端在线信息
    
    public final static String IPTVACCOUNT_TABLE_HEAD = "I_IPTVACCOUNT";// 积分账户表
    
    public final static String GAMESACCOUNT_TABLE_HEAD = "I_GAMES_ACCOUNT";// 游戏账号表

	public final static String A_ACCOUNTLOCK_TABLE_HEAD = "A_ACCOUNTLOCK";// 童锁密码表
	
	public final static String A_ACCOUNTLOCKHISTORY_TABLE_HEAD = "A_ACCOUNTLOCKHISTORY";// 童锁密码表

	public static final String A_ACCOUNTPHONE_TABLE_HEAD = "A_ACCOUNTPHONE";//绑定手机表
    
	public static final String A_INTERFACELOG_TABLE_HEAD = "A_INTERFACELOG";//接口日志表

	public static final String A_USERINFO_TABLE_HEAD = "A_USERINFO";//用户基本信息

	public static final String A_EDUCATIONACCOUNT_TABLE_HEAD = "A_EDUCATIONACCOUNT";//教育账户信息

	public static final String A_GAMESACCOUNT_TABLE_HEAD = "A_GAMESACCOUNT";//游戏账户信息

	public static final String A_KALAOKACCOUNT_TABLE_HEAD = "A_KALAOKACCOUNT";//卡拉OK账户信息

	public static final String A_READINGACCOUNT_TABLE_HEAD = "A_READINGACCOUNT";//阅读帐户信息
	
	public static final String A_LIVEACCOUNT_TABLE_HEAD = "A_LIVEACCOUNT";//生活账户信息
	
    public static final String A_STBBLACKACCOUNT_TABLE_HEAD= "A_STBBLACKACCOUNT";//黑名单表
    
    public static final String A_STBGRAYACCOUNT_TABLE_HEAD= "A_STBGRAYACCOUNT";//灰名单表
    
	public static final String A_BEHAVIORLOG_TABLE_HEAD = "A_BEHAVIORLOG";//用户行为日志表
	
	public static final String A_SELFSERVICESACCOUNT_TABLE_HEAD = "A_SELFSERVICESACCOUNT";//自服务账户表
	
	//add by zhaoyj 71919
    //消息盒子相关表
    public static final String A_M_USERNORMALMESSAGEVIEW_TABLE_HEAD = "A_M_USERNORMALMESSAGEVIEW";//用户普通消息概览表
    public static final String A_M_USERNORMALMESSAGE_TABLE_HEAD = "A_M_USERNORMALMESSAGE";//用户普通消息表
    public static final String A_M_USERFORCEDMESSAGE_TABLE_HEAD = "A_M_USERFORCEDMESSAGE";//用户强制消息表
	
    //add by zhaoyj 71919 20151022
    // 四川四季度抽奖表
    public static final String T_A_LOTTERY_TABLE_HEAD = "T_A_LOTTERY";
    
    //四川电子钱包
    public final static String A_USERPAYMENTVOUCHERACCOUNT_TABLE_HEAD = "A_USERPAYMENTVOUCHERACCOUNT";// 用户支付券账户表
    public final static String A_PAYMENTVOUCHERINFO_TABLE_HEAD = "A_PAYMENTVOUCHERINFO";// 支付券信息表
    public final static String A_USERPAYMENTVOUCHEROBTAIN_TABLE_HEAD = "A_USERPAYMENTVOUCHEROBTAIN";// 用户支付券领取记录表
    public final static String A_USERPAYVOUCHERCONSUMPTION_TABLE_HEAD = "A_USERPAYVOUCHERCONSUMPTION";// 用户支付券消费记录表
    
    public static final String A_USERMOBILE_TABLE_HEAD= "A_USERMOBILE";
    
    public static final String A_USERMOBILEHISTORY_TABLE_HEAD= "A_USERMOBILEHISTORY";
    
    /**
     * @Fields USER_BIND_INFO_TABLE_HEAD : 微信小程序  用户绑定表前缀
     */
    public static final String USER_BIND_INFO_TABLE_HEAD= "user_bind_info_";
    /**
     * 获得订购关系表名
     * 
     * @param userName
     * @return
     * @throws Exception
     */
    public static String getSubscribeInfoTableName(String userName)
        throws Exception {
        return getTableName2(userName, SUBSCRIBEINFO_TABLE_HEAD);
    }

    /**
     * 获得订购关系表名
     * 
     * @param userName
     * @return
     * @throws Exception
     */
    public static String getTempSubscribeInfoTableName(String userName)
        throws Exception {
        return getTableName2(userName, TEMPSUBSCRIPTION_TABLE_HEAD);
    }


    /**
     * 获得用户表名
     * 
     * @return java.lang.String
     * @param userName
     *            java.lang.String
     */
    public static String USERHash(String userName, String tableHead)
        throws Exception {
        return getTableName2(userName, tableHead);
    }

    /**
     * 根据用户名获得相关表名. 创建 日期: (2002-6-6 11:18:12)
     * 
     * @return java.lang.String
     * @param str
     *            java.lang.String
     * @param tableHead
     *            java.lang.String
     */
    public static String getTableName(String str, String tableHead)
        throws Exception {
        if (tableHead == null || tableHead.equals(""))
            throw new Exception(
                "Exception in method getTableName of class Hash163:param tableHead is null");
        return tableHead + sHash(str);
    }

    public static String getTableName2(String str, String tableHead)
        throws Exception {
        if (tableHead == null || tableHead.equals(""))
            throw new Exception(
                "Exception in method getTableName of class Hash163:param tableHead is null");
        return tableHead + sHash2(str);
    }

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
        return (s_sum % TABLE_COUNT);
    }

    // 根据用户名获得HASH值
    static public int hash2(String str) {
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

    /**
     * 此处插入方法描述. 创建 日期: (2002-6-7 10:49:11)
     * 
     * @return java.lang.String
     * @param str
     *            java.lang.String
     */
    public static String sHash(String str)
        throws Exception {
        int sum = -1;
        String ret = "";
        if (str == null || str.length() > 40)
            throw new Exception(
                "Exception in method sHash of class Hash163:str is null or lenth > 40");
        sum = hash(str.trim());
        if ( (sum < 0) || (sum > TABLE_COUNT - 1))
            throw new Exception(
                "Exception in method sHash of class Hash163:error");
        if (sum < 10)
            ret = "0" + sum;
        else if (sum >= 10)
            ret = String.valueOf(sum);
        return (ret);
    }

    public static String sHash2(String str)
        throws Exception {
        int sum = -1;
        String ret = "";
        if (str == null || str.length() > 40)
            throw new Exception(
                "Exception in method sHash of class Hash163:str is null or lenth > 40");
        sum = hash2(str.trim());
        if ( (sum < 0) || (sum > USEE_TABLE_COUNT - 1))
            throw new Exception(
                "Exception in method sHash of class Hash163:error");
        if (sum < 10)
            ret = "0" + sum;
        else if (sum >= 10)
            ret = String.valueOf(sum);
        return (ret);
    }

    // 获取原始的hash值
    static public int hashValue(String str) {
        int l_power[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
            47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
            113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173};
        int s_sum, i;
        s_sum = 0;
        for (i = 0; i < str.length(); i++ ) {
            s_sum += str.charAt(i) * l_power[i];
        }
        return s_sum;
    }
}
