package server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ReceiveThread extends Thread {
    private final Socket socket;

    // ������
    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // ä�ÿ��� �޼��� �޴� �κ� �غ�
            DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());

            String receiveString;

            while (true) {
                // ���� �޼��� ���� �޼ҵ�
                receiveString = tmpbuf.readUTF();
                System.out.println("���� : " + receiveString);
            }
        } catch (SocketException e1) {
            System.out.println("���� ������ ����Ǿ����ϴ�.");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

}
