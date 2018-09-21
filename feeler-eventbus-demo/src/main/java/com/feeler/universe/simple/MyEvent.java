package com.feeler.universe.simple;

/**
 * @Author: wanglei1
 * @Date: 2018/09/13 21:56
 * @Description:
 */
public class MyEvent {

    private final int message;

    public MyEvent(int message) {
        this.message = message;
        System.out.println("event message:"+message);
    }

    public int getMessage() {
        return message;
    }

}
