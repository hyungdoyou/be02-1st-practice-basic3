import java.io.*;
import java.net.Socket;
import java.sql.Struct;

public class ImageInputThread extends Thread{
    Socket socket;

    public ImageInputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 여기부터 요청받는 코드
            InputStream cis = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(cis);
            InputStreamReader isr = new InputStreamReader(cis);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();

            FileOutputStream fileOutputStream = new FileOutputStream("c:\\test2\\" + message);
            byte[] bytes = bis.readAllBytes();
            for(int i=0; i<bytes.length; i++) {
                fileOutputStream.write(bytes[i]);
            }
            // 여기까지 요청받는 코드
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
