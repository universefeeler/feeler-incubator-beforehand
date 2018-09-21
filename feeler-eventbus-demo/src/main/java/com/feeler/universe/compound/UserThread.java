package com.feeler.universe.compound;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 1:19
 * @Description:
 */
public class UserThread extends Thread {

    private Socket connection;
    private EventBus channel;
    private BufferedReader in;
    private PrintWriter out;

    public UserThread(Socket connection, EventBus channel) {
        this.connection = connection;
        this.channel = channel;
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(connection.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Subscribe
    public void recieveMessage(String message) {
        if (out != null) {
            System.out.println("recieveMessage:"+message);
            StringBuilder sb = new StringBuilder(message);
            sb.reverse();
            out.println(sb.toString());
        }
    }

    @Override
    public void run() {
        try {
            String input;
            while ((input = in.readLine()) != null) {
                channel.post(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reached eof
        channel.unregister(this);
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        in = null;
        out = null;
    }

}
