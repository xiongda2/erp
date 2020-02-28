package com.bdqn.erp;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class TestMd5 {

    public static void main(String[] args) {
        String password = "123456";//要加密的字符串
        String salt = "04A93C74C8294AA09A8B974FD1F4ECBB";//盐
        Integer hashIterations = 2;//散列次数
        /*
        //1.不加盐的md5
        Md5Hash md5 = new Md5Hash(password);
        System.out.println(md5.toString());

        //2.加盐的md5
        md5 = new Md5Hash(password, salt);
        System.out.println(md5.toString());

        //3.加盐再设置散列次数的md5
        md5 = new Md5Hash(password, salt, hashIterations);
        System.out.println(md5.toString());

        //4.利用SimpleHash来设置md5(上面三种都可以通过这个来设置，这里举例加盐加散列次数的)
        //第一个参数是算法名称，这里指定md5，第二个是要加密的密码，第三个参数是加盐，第四个是散列次数
        SimpleHash hash = new SimpleHash("md5", password, salt,hashIterations);
        System.out.println(hash.toString());

         */
        //3.加盐再设置散列次数的md5
        Md5Hash md5 = new Md5Hash(password, salt, hashIterations);
        System.out.println(md5.toString());
    }
}
