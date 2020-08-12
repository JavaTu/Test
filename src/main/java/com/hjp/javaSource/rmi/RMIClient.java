package com.hjp.javaSource.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @ClassName: RMIClient
 * @Description:
 * @Author: huangjp
 * @Date: 2020/8/12 11:41
 */
public class RMIClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        // 服务注册中心，端口为1111
        Registry registry = LocateRegistry.getRegistry(1111);
        // 发现服务
        Server server = (Server)registry.lookup("server");
        // 调起服务
        server.m();
        System.out.println("远程调用完成...");
    }

}
