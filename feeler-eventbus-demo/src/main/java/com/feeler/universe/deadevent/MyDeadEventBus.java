package com.feeler.universe.deadevent;

import com.feeler.universe.simple.MyEvent;
import com.google.common.eventbus.EventBus;
import org.junit.Test;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 0:52
 * @Description: 说明：如果没有消息订阅者监听消息， EventBus将发送DeadEvent消息，这时我们可以通过log的方式来记录这种状态。
 */
public class MyDeadEventBus {

    @Test
    public void testDeadEventListeners() throws Exception {

        EventBus eventBus = new EventBus("testDeadEvent");
        DeadEventListener deadEventListener = new DeadEventListener();
        eventBus.register(deadEventListener);

        eventBus.post(new MyEvent(200));
        eventBus.post(new MyEvent(300));

        System.out.println("deadEvent:"+deadEventListener.isNotDelivered());

    }
}
