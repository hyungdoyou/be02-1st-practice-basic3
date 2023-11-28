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

            Socket socket= new Socket("192.168.0.114", 5555);

            Thread messageout = new MessageOutputThread(socket);
            Thread messagein = new MessageInputThread(socket);
            messageout.start();
            messagein.start();

            while(true) {

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
