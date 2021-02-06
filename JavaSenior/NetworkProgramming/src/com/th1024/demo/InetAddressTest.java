package com.th1024.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络编程中两个主要问题
 * 1. 如何准确地定位网络上一台或多台主机；定位主机上的特定应用
 * 2. 找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素
 * 1. IP和端口号
 * 2. 网络通信协议：TCP/IP模型（应用层、传输层、网络层、物理+数据链路层）
 *
 * 三、通信要素一：IP和端口号
 * 1. IP：唯一的标识Internet上的计算机（通信实体）
 * 2. 在Java中使用InetAddress类代表IP
 * 3. IP分类：IPV4 / IPV6；万维网 / 局域网
 * 4. 域名：www.baidu.com / www.google.com
 * 5. 本地回路地址：127.0.0.1 对应着localhost
 * 6. 实例化InetAddress：getByName() / getLocalHost()
 *    两个常用方法：getHostName() / getHostAddress()
 * 7. 端口号：标识正在计算机上运行的进程
 *    要求：不同的进程有不同的端口号；范围：16位整数 0~65535
 * 8. 端口号与IP地址的组合得出一个网络套接字：Socket
 *
 *
 * @author TuHong
 * @create 2021-02-06 10:55
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.0.109");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.google.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);
            //获取本机ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName()
            System.out.println(inet2.getHostName());
            //getHostAddress()
            System.out.println(inet2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
