package com.hjp.javaSource.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @ClassName: Server
 * @Description: 服务接口继承Remote，必要项，因为远程调用底层基于JDK动态代理实现。
 * @Author: huangjp
 * @Date: 2020/8/12 14:04
 */
public interface Server extends Remote {

    // 注意必须抛出RemoteException异常
    void m() throws RemoteException;

}
