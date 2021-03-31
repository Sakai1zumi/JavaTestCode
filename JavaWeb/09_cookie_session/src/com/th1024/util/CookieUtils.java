package com.th1024.util;

import javax.servlet.http.Cookie;

/**
 * @author TuHong
 * @create 2021-03-31 21:07
 */
public class CookieUtils {

    public static Cookie findCookie(String name, Cookie[] cookies){
        if(name == null || cookies == null || cookies.length == 0){
            return null;
        }

        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
