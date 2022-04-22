package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
    private final Socket socket;

    // �ܼ� �Է� �ޱ�
    Scanner scanner = new Scanner(System.in);

    public SendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            // OutputStream�� �ֻ��� �θ�, DataOutputStream ��� �� �� ��üȭ �� ����
            // getOutputStream �갡 ������ ����� ���� ���� �޾����ݾ�
            // �ٵ� DataOutputStream��� �����ָ� ��ǻ�� ���� �ٲ㼭 ��Ʈ���� ���� �غ� �ϴ°���
            DataOutputStream sendWrite = new DataOutputStream(socket.getOutputStream());

            String sendString;
            while (true){
                // �ܼ� �Է� ó��
                sendString = scanner.nextLine();
                // �ܼ� �Է� ���� �κ��� ����
                sendWrite.writeUTF(sendString);
                // ���ۿ� �ִ� �޼����� ��� �ٲ㼭 ���
                sendWrite.flush();
            }
        }catch(IOException e){ // IOException = ����� ����
            e.printStackTrace();
        }
    }
    
}
