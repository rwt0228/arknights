package com.rwt.arknights.common.util;

import org.springframework.util.DigestUtils;

public class MD5Utils {

    public static String addSalt(String pwd, String salt) {
        String res = DigestUtils.md5DigestAsHex((pwd + salt).getBytes());
        return res;
    }
}
