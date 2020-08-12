package com.hjp.javaSource.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @ClassName: ClientSocketTest
 * @Description:
 * @Author: huangjp
 * @Date: 2020/8/12 15:24
 */
public class ClientSocketTest {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",1111);
        System.out.println("客户端Socket已连接...");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String msg = "你好，我是客户端Alice，我现在还不够强大，只能跟你说一句话┭┮﹏┭┮";
        writer.write(msg);
        writer.flush();
        writer.close();

        // 单向聊天系统宣告失败。
        /*Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()){
            msg = scan.nextLine();
            System.out.println("客户端发送：" + msg);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(msg);
            writer.flush();
            writer.close();
        }
        scan.close();*/
    }

}
