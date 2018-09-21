package com.feeler.universe.multiple;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 0:47
 * @Description:
 */
public class MyMultipleEvents {

    @Test
    public void testMultipleEvents() throws Exception {

        EventBus eventBus = new EventBus("testMultiple");
        MultipleListener multiListener = new MultipleListener();
        eventBus.register(multiListener);

        eventBus.post(new Integer(100));
        eventBus.post(new Integer(200));
        eventBus.post(new Integer(300));
        eventBus.post(new Long(800));
        eventBus.post(new Long(800990));
        eventBus.post(new Long(800882934));

        System.out.println("LastInteger:"+multiListener.getLastInteger());
        System.out.println("LastLong:"+multiListener.getLastLong());
    }
}
