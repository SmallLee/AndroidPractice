package practice.lxn.cn.androidpractice;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public final static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * HH:mm:ss
     */
    public final static SimpleDateFormat sDateFormat2 = new SimpleDateFormat("HH:mm:ss");

    /**
     * yyyy-MM-dd HH:mm
     */
    public final static SimpleDateFormat YMD_HM = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public final static SimpleDateFormat YMD_HM2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    /**
     * yyyy-MM-dd
     */
    public final static SimpleDateFormat sDateFormatYMD = new SimpleDateFormat("yyyy-MM-dd");

    public final static SimpleDateFormat sDateFormatMD = new SimpleDateFormat("MM-dd HH:mm");

    public final static SimpleDateFormat sDateFormatMDText = new SimpleDateFormat("MM月dd日 HH:mm");

    /**
     * HH-mm
     */
    public final static SimpleDateFormat HM = new SimpleDateFormat("HH:mm");

    public static String getMyCallPhone(String time) {
        long ms = parseToLong(time);
        if(ms <= 0) ms = System.currentTimeMillis();
        return parseTime(YMD_HM, ms);
    }

    /**
     * 获取系统当前时间(时间形式) *
     */
    public static String getcurrentTimes() {
        return parseTime(sDateFormat, System.currentTimeMillis());
    }

    /**
     * *****************************************
     * 解析服务器返回的时间戳
     *
     * @return 年-月-日
     */
    public static String parserTimeYMD(String time) {
        return parseTime(sDateFormatYMD, parseToLong(time));
    }

    /**
     * *****************************************
     * 解析服务器返回的时间戳
     *
     * @return 年-月-日 时-分
     */
    public static String parserTimeYMDHM(String time) {
        return parseTime(YMD_HM, parseToLong(time));
    }

    /**
     * *****************************************
     * 解析服务器返回的时间戳
     *
     * @return 时：分：秒
     */
    public static String parserTimeHHMMSS(String time) {
        return parseTime(sDateFormat2, parseToLong(time));
    }

    /**
     * *****************************************
     * 解析服务器返回的时间戳
     *
     * @return 年/月/日 时-分
     */
    public static String parserTimeYMDHM2(String time) {
        return parseTime(YMD_HM2, parseToLong(time));
    }


    /**
     * *****************************************
     * 解析服务器返回的时间戳
     *
     * @return 月 日 时-分
     */
    public static String parserTimeMD(String time) {
        return parseTime(sDateFormatMDText, parseToLong(time));
    }

    /**
     * *****************************************
     * 解析服务器返回的时间戳
     *
     * @return 月-日 时-分
     */
    public static String parserTime(String time) {
        return parseTime(sDateFormatMD, parseToLong(time));
    }

    /**
     * *****************************************
     * 解析服务器返回的时间戳
     *
     * @return 年-月-日 时-分
     */
    public static String parsetDetailTime(String time) {
        return parseTime(YMD_HM, parseToLong(time));
    }

    /**
     *
     * @return 时-分
     */
    public static String parserTimeHM(String time) {
        return parseTime(HM, parseToLong(time));
    }


    /**
     * 时间（long） *
     */
    public static long getTime(SimpleDateFormat format, String strDate) {
        if (TextUtils.isEmpty(strDate)) {
            return 0;
        }
        try {
            Date date = format.parse(strDate);
            long time = date.getTime();
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean isExpried(long savedExprieTime) {
        if (savedExprieTime == 0) {
            return true;
        }
        long curTime = getTime(sDateFormatYMD, getcurrentTimes());
        return savedExprieTime < curTime;
    }

    public static boolean durating(String startAt, String endAt) {
        long start = getTime(sDateFormat, startAt);
        long end = getTime(sDateFormat, endAt);
        long cur = getTime(sDateFormat, parseTime(sDateFormat, System.currentTimeMillis()));
        return cur >= start && cur <= end;
    }

    public static String parseTime(SimpleDateFormat format, long time) {
        return format.format(new Date(time));
    }

    /**
     * ***********************
     * 转化时间格式
     *
     * @param orderTime   订单时间
     * @param from_now_on 多久
     * @return 转化成 年/月/日 时：分
     */
    public static String getDate(String orderTime, String from_now_on) {
        int ordertime = parseToInt(orderTime);
        int fromnowon = parseToInt(from_now_on);
        Long timestamp = parseToLong(String.valueOf(ordertime + fromnowon)) * 1000;
        String date = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm").format(new java.util.Date(timestamp));
        return date;
    }

    @SuppressLint("SimpleDateFormat")
    public static Date parseTimeFromString(String dateTime, String format) {
        SimpleDateFormat formatDate = new SimpleDateFormat(format);
        try {
            return formatDate.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint("SimpleDateFormat")
    public static String getStringWithFormat(Date dateTime, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f.format(dateTime);
    }

    public static String calculateTime(long seconds) {
        StringBuilder result = new StringBuilder();
        long day,hour,minute;
        //For Days
        if (seconds >= 60*60*24)
        {
            day = seconds/(60*60*24);
            seconds -= (60*60*24)*day;
            result.append(day+"天");
        }

        //For Hours
        if (seconds >= 60*60)
        {
            hour = seconds/(60*60);
            seconds -= 60*60*hour;
            result.append(hour+"小时");
        }

        //For Minutes
        if (seconds >= 60)
        {
            minute = seconds/60;
            seconds -= 60*minute;
            result.append(minute+"分");
        }

        result.append(seconds+"秒");

        return result.toString();
    }

    public static boolean isCurrentTimeBetween(String startTime, String endTime) {
        Date now = new Date();
        return isDateBetween(now, startTime, endTime);
    }

    public static boolean isDateBetween(Date date, String startTime, String endTime) {
        int minutes = date.getHours() * 60 + date.getMinutes();
        int startMinutes = getMinutes(startTime);
        int endMinutes = getMinutes(endTime);
        if (endMinutes > startMinutes) {
            return minutes > startMinutes && minutes <= endMinutes;
        } else {
            int time24 = getMinutes("24:00");
            return (minutes > startMinutes && minutes <= time24) || (minutes >= 0 && minutes < endMinutes);
        }
    }

    /**
     * @param time example:"12:01"
     * @return
     */
    public static int getMinutes(String time) {
        try {
            String[] segs = time.split(":");
            return parseToInt(segs[0]) * 60 + parseToInt(segs[1]);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 两个时间做差
     *
     * @param  start_time 单位秒
     * @param  end_time   单位秒
     * @return   时间差    单位是分
     */
    public static String getDiff(String start_time, String end_time){

        int start = parseToInt(start_time);
        int end = parseToInt(end_time);

        return (end-start)/60+"";

    }

    /**
     * 秒转 时间显示
     *
     * @param  seconds 单位秒
     * @return   时间显示 如 09:08:02    单位是分
     */
    public static String getMMSS(long seconds){
        StringBuilder result = new StringBuilder();
        long hour, minute, second;

        //For Hours
        if (seconds >= 60*60)
        {
            hour = seconds/(60*60);
            seconds -= 60*60*hour;
            result.append((hour<10?"0":"")+hour+":");
        }

        //For Minutes
        if (seconds >= 60)
        {
            minute = seconds/60;
            seconds -= 60*minute;
            result.append((minute<10?"0":"")+minute+":");
        }else{
            result.append("00:");
        }

        result.append((seconds<10?"0":"")+seconds);

        return result.toString();
    }

    /**
     * 将字符转换为整形数值
     * 说明: 默认十进制数值字符
     *
     * @param strValue : 字符串内容
     *
     * @return 转换后的整形数值
     */
    private static int parseToInt(String strValue) {
        return parseToInt(strValue, 0);
    }

    /**
     * 将字符转换为整形数值
     * 说明: 默认十进制数值字符
     *
     * @param strValue : 字符串内容
     * @param defaultValue : 转换失败默认返回值
     *
     * @return 转换后的整形数值
     */
    private static int parseToInt(String strValue, int defaultValue) {
        int value = defaultValue;
        try{
            if(!TextUtils.isEmpty(strValue)) {
                value = Integer.parseInt(strValue);
            }
        } catch(Exception ex) {

        }
        return value;
    }

    /**
     * 将字符转换为整形数值
     * 说明: 默认十进制数值字符
     *
     * @param strValue : 字符串内容
     *
     * @return 转换后的长整形数值
     */
    private static long parseToLong(String strValue) {
        return parseToLong(strValue, (long) 0);
    }

    /**
     * 将字符转换为整形数值
     * 说明: 默认十进制数值字符
     *
     * @param strValue : 字符串内容
     * @param defaultValue : 转换失败默认返回值
     *
     * @return 转换后的长整形数值
     */
    private static long parseToLong(String strValue, long defaultValue) {
        long value = defaultValue;
        try{
            if(!TextUtils.isEmpty(strValue)) {
                value = Long.parseLong(strValue);
            }
        } catch(Exception ex) {

        }
        return value;
    }

    public static String getHHmm(long mills){

        SimpleDateFormat df = new SimpleDateFormat("HH:mm", Locale.getDefault());

        return df.format(new Date(mills));
    }
}
