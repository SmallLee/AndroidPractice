package practice.lxn.cn.androidpractice.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *
 */

public class Util {
    private static DecimalFormat mDecimalFormat;

    /**
     * @param number 接受的数字
     * @param digit  保留的小数点位数
     * @return 保留指定小数位后的数字
     */
    public static double getFormatNumber(double number, int digit) {
//        Double value = number;
//        if (value.intValue() == number) {
//            int result = value.intValue();
//            return result;
//        }
        if (mDecimalFormat == null) {
            mDecimalFormat = new DecimalFormat();
        }
        if (digit == 1) {
            mDecimalFormat.applyPattern("#.0");
        } else {
            mDecimalFormat.applyPattern("#.00");
        }
        return  digit < 1 ? 0 : Double.parseDouble(mDecimalFormat.format(number));
    }

    public static double getFormatNumber(double number) {
        //包含小数点
       return getFormatNumber(number,2);
    }

    public static String addDouble(Double d1,Double d2) {
        //需要转化为String才不会精度丢失
        BigDecimal bigDecimal = new BigDecimal(d1.toString());
        BigDecimal bigDecimal2 = new BigDecimal(d2.toString());
        return bigDecimal.add(bigDecimal2).toString();
    }

    public static String subtractDouble(Double d1,Double d2) {
        //需要转化为String才不会精度丢失
        BigDecimal bigDecimal = new BigDecimal(d1.toString());
        BigDecimal bigDecimal2 = new BigDecimal(d2.toString());
        return bigDecimal.subtract(bigDecimal2).toString();
    }
}
