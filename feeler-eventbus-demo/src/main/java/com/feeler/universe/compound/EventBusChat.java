package com.feeler.universe.compound;

import com.google.common.eventbus.EventBus;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 1:21
 * @Description: 用telnet命令登录：telnet 127.0.0.1 4444 ，如果你连接多个实例你会看到任何消息发送被传送到其他实例
 *                 https://www.cnblogs.com/peida/p/EventBus.html
 */
public class EventBusChat {

    public static void main(String[] args) {
        EventBus channel = new EventBus();
        ServerSocket socket;
        try {
            socket = new ServerSocket(4444);
            while (true) {
                Socket connection = socket.accept();
                UserThread newUser = new UserThread(connection, channel);
                channel.register(newUser);
                newUser.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
