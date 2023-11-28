import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MessageOutputThread extends Thread {
    Socket socket;

    public MessageOutputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            //OutputStreamWriter osw = new OutputStreamWriter(os);
            //BufferedWriter bow = new BufferedWriter(osw);
            PrintStream ps = new PrintStream(os);
            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.print("송신할 메시지를 입력하세요 : ");
                String message = sc.nextLine();
                if(message.endsWith(".jpg")) {
                    ps.println(message);
                    FileInputStream fis = new FileInputStream("c:\\test3\\" + message);

                    BufferedOutputStream bos = new BufferedOutputStream(os);
                    byte[] bytes = fis.readAllBytes();
                    for(int i=0; i<bytes.length; i++) {
                        bos.write(bytes[i]);
                    }
                    bos.flush();
                    fis.close();
                } else {
                    ps.println(message);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
