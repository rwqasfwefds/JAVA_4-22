package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
    private final Socket socket;

    // 콘솔 입력 받기
    Scanner scanner = new Scanner(System.in);

    public SendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            // OutputStream이 최상위 부모, DataOutputStream 얘는 좀 더 구체화 된 개념
            // getOutputStream 얘가 받으면 사람이 쓰는 언어로 받아지잖아
            // 근데 DataOutputStream얘로 던져주면 컴퓨터 언어로 바꿔서 네트웍에 보낼 준비를 하는거임
            DataOutputStream sendWrite = new DataOutputStream(socket.getOutputStream());

            String sendString;
            while (true){
                // 콘솔 입력 처리
                sendString = scanner.nextLine();
                // 콘솔 입력 받은 부분을 전송
                sendWrite.writeUTF(sendString);
                // 버퍼에 있는 메세지를 즉시 바꿔서 출력
                sendWrite.flush();
            }
        }catch(IOException e){ // IOException = 입출력 예외
            e.printStackTrace();
        }
    }
    
}
