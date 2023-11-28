import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) {
        try {
            Socket yhd = new Socket("192.168.0.114", 7777);

            System.out.print("서버에서 보낸 메시지입니다 : ");
            InputStream cis = yhd.getInputStream();
            InputStreamReader isr = new InputStreamReader(cis);
            BufferedReader br = new BufferedReader(isr);

            String str = br.readLine();
            System.out.println(str);
            //int num = cis.read();
            //System.out.println(num);

            System.out.print("서버에 요청할 메시지를 입력하세요 : ");
            Scanner sc = new Scanner(System.in);

            OutputStream cos = yhd.getOutputStream();
            PrintStream ps = new PrintStream(cos);

            String test2 = sc.nextLine();
            ps.println(test2);
            //int test2 = sc.nextInt();
            //cos.write(test2);

            yhd.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
