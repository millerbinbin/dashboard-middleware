package com.jd.logistics.cloud.data.commons.helper;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/17 14:04
 */
public class MD5Helper {
    public static String getMD5Password(String password, String salt) {
        salt = salt.toLowerCase();
        return new Md5PasswordEncoder().encodePassword(password, salt);
    }

    public static boolean validateMD5Password(String password, String username, String encryptPwd) {
        String md5Pwd = getMD5Password(password, username);
        return md5Pwd.equals(encryptPwd);
    }


}
