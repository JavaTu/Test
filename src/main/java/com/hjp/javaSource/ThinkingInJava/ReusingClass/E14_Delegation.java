package com.hjp.javaSource.ThinkingInJava.ReusingClass;

/**
 * @author huangjp 2017-9-20 9:30
 * 测试代理
 **/
public class E14_Delegation {

    public static void main(String[] args) {
        Customer customer = new Customer(1);
        try {
            System.out.println("");
            System.out.println("Test finally");
            System.out.println("");
        }finally {
            customer.dispose(1);
        }
    }

    /*
     *  output : Shape construct
                Shape construct
                Circle construct
                Shape construct
                Line construct: 0, 0
                Shape construct
                Circle construct
                Shape construct
                Line construct: 1, 1
                Shape construct
                Circle construct
                Shape construct
                Line construct: 2, 4
                Customer construct

                Test finally

                Shape dispose
                Shape dispose
                Circle dispose
                Shape dispose
                Line dispose
                Shape dispose
                Line dispose
                Shape dispose
                Line dispose
     */
}

class SpaceShipControls{

    void up(int velocity){
        System.out.println("控制器起飞");
    }

    void down(int velocity){
        System.out.println("控制器降落");
    }
}

/**
 * 一个简单的代理
 */
class SpaceShipDelegation{

    private String name;
    private SpaceShipControls spaceShipControls = new SpaceShipControls();

    private SpaceShipDelegation(String name) {
        this.name = name;
    }

    private void up(int velocity){
        System.out.println(name + "起飞");
        spaceShipControls.up(velocity);
    }

    private void down(int velocity){
        System.out.println(name + "降落");
        spaceShipControls.down(velocity);
    }

    public static void main(String[] args) {
        SpaceShipDelegation spaceShip = new SpaceShipDelegation("飞船1号");
        spaceShip.up(1);
        spaceShip.down(1);
    }

    /*
     *  output : 飞船1号起飞
                 控制器起飞
                 飞船1号降落
                 控制器降落
     */
}

class Shape{
    Shape(int i) {
        System.out.println("Shape construct");
    }

    void dispose(int i){
        System.out.println("Shape dispose");
    }
}

class Circle extends Shape{
    Circle(int i){
        super(i);
        System.out.println("Circle construct");
    }

    void dispose(int i){
        super.dispose(i);
        System.out.println("Circle dispose");
    }
}

class Line extends Shape{
    private int start, end;

    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Line construct: " + start + ", " + end);
    }

    void dispose(int start, int end){
        super.dispose(start);
        System.out.println("Line dispose");
    }
}

class Customer extends Shape{

    private Circle circle;
    private Line[] lines = new Line[3];

    public Customer(int i) {
        super(i);
        for (int j = 0 ; j < 3; j++) {
            circle = new Circle(1);
            lines[j] = new Line(j, j*j);
        }
        System.out.println("Customer construct");
    }

    void dispose(int i){
        super.dispose(i);
        circle.dispose(i);
        for (int j = 0 ; j < 3; j ++) {
            lines[j].dispose(j, j*j);
        }
    }
}
