package com.feeler.universe.deadevent;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 0:50
 * @Description: 如果EventBus发送的消息都不是订阅者关心的称之为Dead Event
 */
public class DeadEventListener {

    boolean notDelivered = false;

    @Subscribe
    public void listen(DeadEvent event) {
        notDelivered = true;
    }

    public boolean isNotDelivered() {
        return notDelivered;
    }
}
