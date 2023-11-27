import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSockeMain {
    public static void main(String[] args) {
        try {
            //서버로 접속하는 코드
            Socket clientSocket = new Socket("192.168.0.114", 9999);

            OutputStream cos = clientSocket.getOutputStream();
            cos.write(100);

            InputStream cis = clientSocket.getInputStream();
            int num = cis.read();
            System.out.println(num);

            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
