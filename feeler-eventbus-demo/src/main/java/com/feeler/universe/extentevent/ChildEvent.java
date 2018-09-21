package com.feeler.universe.extentevent;

import com.feeler.universe.extentevent.ParentEvent;

/**
 * @Author: wanglei1
 * @Date: 2018/09/14 1:02
 * @Description:
 */
public class ChildEvent extends ParentEvent {

    private final int message;

    public ChildEvent(int message) {
        super(message);
        this.message = message;
        System.out.println("child event message:"+message);
    }
}
