package com.hjp.javaSource.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @ClassName: ServerImpl
 * @Description: 服务实现类继承UnicastRemoteObject实现服务接口
 * @Author: huangjp
 * @Date: 2020/8/12 11:37
 */
public class ServerImpl extends UnicastRemoteObject implements Server {

    protected ServerImpl() throws RemoteException {
        super();
    }

    @Override
    public void m() {
        System.out.println("m....");
    }
}
