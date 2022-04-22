package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    // throws IOException = ����ó�� ����
    public static void main(String[] args) throws IOException{
        int port = 8888;
        ServerSocket socketServer = new ServerSocket(port);

        while(true){
            // Ŭ���̾�Ʈ�ʿ��� ���� �Ǹ� �Ʒ��� ����Ǵ� �޼ҵ�
            Socket sock = socketServer.accept();
            System.out.println("ip : " + sock.getInetAddress() + "�� ���� �Ǿ����ϴ�.");
            
            // �޼��� �޴� ������ ����
            ReceiveThread receiveThread = new ReceiveThread(sock);
            receiveThread.start();

            // �޼��� ������ ������ ����
            SendThread sendThead = new SendThread(sock);
            sendThead.start();
        }
    }
}
