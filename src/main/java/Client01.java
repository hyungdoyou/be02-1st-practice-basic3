import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client01 {
    Socket socket;

    public Client01(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        try {
            Socket socket= new Socket("192.168.88.1", 6666);

            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            Scanner sc = new Scanner(System.in);
            System.out.print("ID를 입력해주세요 : ");
            String id = sc.nextLine();

            ps.println(id);

            Thread messageOut = new MessageOutputThread(socket);
            Thread messageIn = new MessageInputThread(socket);
            messageOut.start();
            messageIn.start();

            while(true) {

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
