package com.hjp.javaSource.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: ServerSocket
 * @Description:
 * @Author: huangjp
 * @Date: 2020/8/12 15:19
 */
public class ServerSocketTest {

    public static void main(String[] args) throws IOException {

        // 初始化服务端socket并且绑定1111端口
        ServerSocket serverSocket  = new ServerSocket(1111);
        System.out.println("server socket连接已就绪，开始接收信息...");

        //等待客户端的连接
        while (true){
            Socket socket = serverSocket.accept();

            // 获取输入流
            InputStream inputStream = socket.getInputStream();
            InputStreamReader in = new InputStreamReader(inputStream);
            BufferedReader bufferedReader =new BufferedReader(in);

            // 读取一行数据
            System.out.println(bufferedReader.readLine());
        }
    }
}
