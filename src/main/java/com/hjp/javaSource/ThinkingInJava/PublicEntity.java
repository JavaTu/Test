package com.hjp.javaSource.ThinkingInJava;

/**
 * @author huangjp 2018-03-14 19:39
 * 公共实体类
 **/
public class PublicEntity {

    private String attribute1;

    private String attribute2;

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    @Override
    public boolean equals(Object obj) {

        System.out.println("开始执行PublicEntity的equals方法");

        if (obj == this){
            return true;
        }

        if (obj instanceof PublicEntity){
            PublicEntity entity = (PublicEntity) obj;
            String attribute1 = entity.attribute1;
            if (attribute1 == this.attribute1){
                return true;
            }
            if (attribute1 != null && attribute1.equals(this.attribute1)){
                return true;
            }
        }

        return false;
    }
}
