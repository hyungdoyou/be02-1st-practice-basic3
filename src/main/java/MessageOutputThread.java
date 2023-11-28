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
                 Scanner sc = new Scanner(System.in);
                 OutputStream os = socket.getOutputStream();
                 PrintStream ps = new PrintStream(os);

                 System.out.println("클라이언트의 ID 를 입력하세요 : ");
                 String client1 = sc.nextLine();
                 ps.println(client1);

            while(true) {
                String test2 = sc.nextLine();
                ps.println(test2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
