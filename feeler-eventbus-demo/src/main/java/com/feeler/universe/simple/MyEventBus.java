package com.feeler.universe.simple;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 0:18
 * @Description:
 */
public class MyEventBus {

    @Test
    public void testReceiveEvent() throws Exception {

        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();
        eventBus.register(listener);

        eventBus.post(new MyEvent(200));
        eventBus.post(new MyEvent(300));
        eventBus.post(new MyEvent(400));

        System.out.println("LastMessage:"+listener.getLastMessage());
    }

}
