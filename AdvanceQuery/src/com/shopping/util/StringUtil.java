package com.shopping.util;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class StringUtil {

    public static boolean hasLength(String string) {
        return string != null && !"".equals(string.trim());
    }

}
