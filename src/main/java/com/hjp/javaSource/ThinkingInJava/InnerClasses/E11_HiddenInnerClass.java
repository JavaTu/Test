package com.hjp.javaSource.ThinkingInJava.InnerClasses;

/**
 * @author huangjp 2017-10-25 9:52
 * 隐藏的内部类
 **/
public class E11_HiddenInnerClass {
    public static void main(String[] args) {
        OuterS outerS = new OuterS();
        SimpleInterface s1 = outerS.getI();
        // ! HiddenInner h1 = outerS.getH(); 返回类型不能是HiddenInner，因为它是私有的，但可以是SimpleInterface的
        SimpleInterface h1 = outerS.getH();
        // ! HiddenInner sh = (HiddenInner) s1; 这样向下转型也是不行的
        s1.f();
        h1.f();
    }
    /*
        Output :
                    HiddenInner.f()...
                    HiddenInner.f()...
     */
}

class OuterS{

    private class HiddenInner implements SimpleInterface{
        @Override
        public void f() {
            System.out.println("HiddenInner.f()...");
        }
    }

    public SimpleInterface getI(){
        return new HiddenInner();
    }

    public HiddenInner getH(){
        return new HiddenInner();
    }
}
