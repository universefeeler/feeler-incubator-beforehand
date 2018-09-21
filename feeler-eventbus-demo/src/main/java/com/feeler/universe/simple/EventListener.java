package com.feeler.universe.simple;

import com.google.common.eventbus.Subscribe;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 0:16
 * @Description:
 */
public class EventListener {

    public int lastMessage = 0;

    @Subscribe
    public void listen(MyEvent event) {
        lastMessage = event.getMessage();
        System.out.println("Message:"+lastMessage);
    }

    public int getLastMessage() {
        return lastMessage;
    }

}
