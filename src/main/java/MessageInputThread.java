import java.io.*;
import java.net.Socket;

public class MessageInputThread extends Thread {
    Socket socket;

    public MessageInputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);

            while (true) {
                String message = bir.readLine();
                if (message.endsWith(".jpeg")) {

                    InputStream cis = socket.getInputStream();
                    BufferedInputStream brs = new BufferedInputStream(cis);

                    FileOutputStream fileOutputStream = new FileOutputStream("c:\\test2\\" + message);
                    byte[] bytes = brs.readAllBytes();
                    for (int i = 0; i < bytes.length; i++) {
                        fileOutputStream.write(bytes[i]);
                    }
                    // 여기까지 요청받는 코드
                } else {
                    System.out.println("수신받은 메시지입니다 : " + message);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
