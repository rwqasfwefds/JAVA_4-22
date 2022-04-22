package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
    private final Socket socket;
    private Scanner scanner = new Scanner(System.in);

    // 생성자
    public SendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            // 네트웍 패킷 전송 준비
            DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());

            String sendString;
            while(true){
                // 콘솔 입력
                sendString = scanner.nextLine();
                // 네트웍으로 문자열 전송
                sendWriter.writeUTF(sendString);
                // 문자를 보내면 buffer이라는 임시 저장공간에 문자들을 집어넣음
                // 이 저장공간은 어느정도 차면 보내는 식인데 이 flush라는 함수를 쓰면
                // 그냥 바로바로 보내라 라는 거임
                sendWriter.flush();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
