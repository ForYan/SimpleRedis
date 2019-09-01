package com.For;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Time: 11:01
 */
public class Server {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Server.class);
    public void run(int port) throws IOException {
        try( ServerSocket serverSocket = new ServerSocket(port)) {

            try (Socket socket = serverSocket.accept()){

            while (true) {
                    logger.info("{} 已连接。", socket.getInetAddress().getHostName());
                    InputStream is = socket.getInputStream();
                    OutputStream os = socket.getOutputStream();
                    Command command = Protocol.readCommand(is);
                    command.run(os);
                } }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    public static void main(String[] args) throws IOException {
        new Server().run(6379);
    }
}
