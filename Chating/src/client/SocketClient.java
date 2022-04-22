package client;

import java.io.IOException;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException{
        // ���� ������ Ŭ���̾�Ʈ �ʿ��� ip, port��ȣ�� ������
        Socket sock = new Socket("localhost", 8888);

        System.out.println("������ ���ӵǾ����ϴ�.");

        // ���� �޼��� ó�� ������ ȣ��
        ReceiveThread receiveThread = new ReceiveThread(sock);
        receiveThread.start();

        // ���� �޼��� ó�� ������ ȣ��
        SendThread sendThread = new SendThread(sock);
        sendThread.start();
    }
}
