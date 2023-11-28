import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ImageOutputThread extends Thread{
    Socket socket;

    public ImageOutputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            // 여기부터 요청하는 코드
            System.out.print("전송할 이미지 파일 이름을 입력하세요 : ");
            Scanner sc = new Scanner(System.in);
            OutputStream cos = socket.getOutputStream();
            PrintStream ps = new PrintStream(cos);

            String test2 = sc.nextLine();
            ps.println(test2);
            // 여기까지 요청하는 코드

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
