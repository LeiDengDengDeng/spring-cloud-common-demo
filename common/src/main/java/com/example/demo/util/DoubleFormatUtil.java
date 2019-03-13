package com.example.demo.util;

import java.text.DecimalFormat;

/**
 * double小数格式化工具类
 *
 * @author deng
 * @date 2018/11/13
 */
public class DoubleFormatUtil {
    private DoubleFormatUtil() {
    }

    /**
     * 将double保留numOfDecimalPlace位小数后返回
     *
     * @param num
     * @param numOfDecimalPlace eg:当该参数为2时，输入0.33666会返回0.34
     * @return
     */
    public static double formatDouble(double num, int numOfDecimalPlace) {
        String format = getFormatString(numOfDecimalPlace);
        return Double.parseDouble(new DecimalFormat(format).format(num));
    }

    /**
     * 将double转换为百分数
     *
     * @param num
     * @param numOfDecimalPlace eg:当该参数为2时，输入0.33666会返回33.67%
     * @return
     */
    public static String formatDoubleToPercent(double num, int numOfDecimalPlace) {
        String format = getFormatString(numOfDecimalPlace) + "%";
        return new DecimalFormat(format).format(num);
    }

    private static String getFormatString(int numOfDecimalPlace) {
        StringBuilder format = new StringBuilder("0.0");
        for (int i = 1; i < numOfDecimalPlace; i++) {
            format.append("0");
        }
        return format.toString();
    }
}
