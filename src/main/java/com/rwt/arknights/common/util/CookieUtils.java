package com.rwt.arknights.common.util;

import javax.servlet.http.Cookie;

public class CookieUtils {

    public static Cookie getCookie(String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        return cookie;
    }
}
