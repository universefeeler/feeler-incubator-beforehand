package com.feeler.universe.extentevent;

import com.google.common.eventbus.Subscribe;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 1:09
 * @Description:
 */
public class IntegerListener {

    private Integer lastMessage;

    @Subscribe
    public void listen(Integer integer) {
        lastMessage = integer;
        System.out.println("Integer Message:"+lastMessage);
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}
