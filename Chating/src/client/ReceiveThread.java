package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveThread extends Thread{
    private final Socket socket;
    private String receiveString;

    // �Ű����� 1��¥�� ������
    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            // ��Ʈ���� ���� ���� �����͸� �غ��ϴ� �ܰ�
            DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());

            while(true){
                // ���� �޼��� �б�
                receiveString = tmpbuf.readUTF();
                if(receiveString == null){
                    System.out.println("���� ������ ����Ǿ����ϴ�.");
                } else {
                    System.out.println("���� : " + receiveString);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
