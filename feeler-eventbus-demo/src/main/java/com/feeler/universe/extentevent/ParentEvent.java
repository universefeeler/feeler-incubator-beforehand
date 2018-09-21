package com.feeler.universe.extentevent;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 1:01
 * @Description:
 */
public class ParentEvent {

    private final int message;

    public ParentEvent(int message) {
        this.message = message;
        System.out.println("parent event message:"+message);
    }

    public int getMessage() {
        return message;
    }
}
