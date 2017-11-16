package com.hjp.javaSource.ThinkingInJava.InnerClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjp 2017-11-15 15:35
 * 控制框架 命令设计模式 内部类
 **/
public class E24_GreenHouseInnerEvent {

    public static void main(String[] args) {
        GreenHouseController gc = new GreenHouseController();
        gc.addEvent(gc.new Bell(900));

        Event[] events = {gc.new FanOn(1000), gc.new FanOff(1200)};
        gc.addEvent(gc.new Restart(1300, events));
        gc.addEvent(gc.new Terminate(2600));
        gc.run();
    }
}
/*
    Output :
                Bing!
                fan is on
                fan is off
                Restart...
                Bing!
                fan is on
                fan is off
                exit...
 */

abstract class Event{
    private long eventTime;

    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start(){
        eventTime = System.currentTimeMillis() + delayTime;
    }

    public boolean ready(){
        return System.currentTimeMillis() >= eventTime;
    }

    public abstract void action();
}

class Controller{

    private List<Event> eventList = new ArrayList<>();  // 这里一定要new，否则无法获取到他的size

    public void addEvent(Event event){
        eventList.add(event);
    }

    public void run(){
        while (eventList.size() > 0){
            for (Event event:new ArrayList<>(eventList)){   //注意这里的写法，不直接写eventList，而是new一个List，这样可以防止remove导致的报错
                if (event.ready()){
                    System.out.println(event);
                    event.action();
                    eventList.remove(event);
                }
            }
        }
    }
}

class GreenHouseController extends Controller{

    private boolean fan = false;

    //开启风扇
    public class FanOn extends Event{
        public FanOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan = true;
        }

        @Override
        public String toString() {
            return "fan is on";
        }
    }

    //关闭风扇
    public class FanOff extends Event{
        public FanOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan = false;
        }

        @Override
        public String toString() {
            return "fan is off";
        }
    }

    //控制响铃，与其他Event不同，他在事件列表中增加一个bell对象
    public class Bell extends Event{
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public String toString() {
            return "Bing!";
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }
    }

    public class Restart extends Event{

        private Event[] eventList;

        public Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.eventList = events;
            for (Event event:events){
                addEvent(event);
            }
        }

        @Override
        public void action() {
            for (Event event:eventList){
                event.start();
                addEvent(event);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restart...";
        }
    }

    public class Terminate extends Event{

        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "exit...";
        }
    }

}