package com.feeler.universe.extentevent;

import com.google.common.eventbus.Subscribe;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 0:56
 * @Description:
 */
public class NumberListener {
    private Number lastMessage;

    @Subscribe
    public void listen(Number integer) {
        lastMessage = integer;
        System.out.println("Number Message:"+lastMessage);
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}
