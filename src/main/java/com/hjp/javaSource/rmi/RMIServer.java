package com.hjp.javaSource.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @ClassName: RMIServer
 * @Description: https://blog.csdn.net/qq_28081453/article/details/83279066
 * @Author: huangjp
 * @Date: 2020/8/12 11:39
 */
public class RMIServer {

    public static void main(String[] args) throws RemoteException {
        // 实例化要暴露给远方的接口/方法
        Server server = new ServerImpl();
        // 服务注册中心，端口为1111
        Registry registry = LocateRegistry.createRegistry(1111);
        // 注册服务
        registry.rebind("server", server);
        System.out.println("producer服务准备就绪...");
    }

}
