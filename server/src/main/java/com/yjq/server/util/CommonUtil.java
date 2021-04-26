package com.yjq.server.util;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2021-04-26 19:09
 */

/**
 * 通用工具类
 */
public class CommonUtil {

    /**
     * 验证字符串是否为空
     * @return
     */
    public static boolean isEmpty(String str) {
        if(str == null || "".equals(str)) {
            return true; //为空
        }else {
            return false; //不为空
        }
    }
}
