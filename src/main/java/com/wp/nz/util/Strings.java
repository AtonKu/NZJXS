package com.wp.nz.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 *
 * @author gyt
 * @date 2017年8月23日 下午3:30:13
 */
public class Strings extends StringUtils{
    /**
     * 按照UUID生成随机字符串,注意：返回的字符串中将“-”替换成了“”
     * @return
     */
    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    /**
     * 判断字符串是否为空
     * @Title: isEmptyString
     * @param str
     * @return Boolean
     */
    public static boolean isEmptyString(String str){
        return str == null || str.trim().length() == 0;
    }

    /**
     * 将汉字转换为全拼
     * @param src
     * @return String
     */
    public static String getPinYin(String src) {
        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        // 设置汉字拼音输出的格式
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断能否为汉字字符
                // System.out.println(t1[i]);
                if (Character.toString(t1[i]).matches("[\\一-\\龥]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    // 将汉字的几种全拼都存到t2数组中
                    t4 += t2[0];// 取出该汉字全拼的第一种读音并连接到字符串t4后
                } else {
                    // 如果不是汉字字符，间接取出字符并连接到字符串t4后
                    t4 += Character.toString(t1[i]);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return t4;
    }

}
