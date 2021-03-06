package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    // throws IOException = 예외처리 던짐
    public static void main(String[] args) throws IOException{
        int port = 8888;
        ServerSocket socketServer = new ServerSocket(port);

        while(true){
            // 클라이언트쪽에서 연결 되면 아래가 실행되는 메소드
            Socket sock = socketServer.accept();
            System.out.println("ip : " + sock.getInetAddress() + "와 연결 되었습니다.");
            
            // 메세지 받는 쓰레드 실행
            ReceiveThread receiveThread = new ReceiveThread(sock);
            receiveThread.start();

            // 메세지 보내는 쓰레드 실행
            SendThread sendThead = new SendThread(sock);
            sendThead.start();
        }
    }
}
