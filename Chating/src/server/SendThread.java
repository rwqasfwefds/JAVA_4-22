package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
    private final Socket socket;
    private Scanner scanner = new Scanner(System.in);

    // ������
    public SendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            // ��Ʈ�� ��Ŷ ���� �غ�
            DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());

            String sendString;
            while(true){
                // �ܼ� �Է�
                sendString = scanner.nextLine();
                // ��Ʈ������ ���ڿ� ����
                sendWriter.writeUTF(sendString);
                // ���ڸ� ������ buffer�̶�� �ӽ� ��������� ���ڵ��� �������
                // �� ��������� ������� ���� ������ ���ε� �� flush��� �Լ��� ����
                // �׳� �ٷιٷ� ������ ��� ����
                sendWriter.flush();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
