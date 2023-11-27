import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientFileTest {

    public static void main(String[] args) {
        try {
            Socket yhd = new Socket("192.168.88.1", 9999);

            // 여기부터 요청하는 코드
            System.out.print("서버에 요청할 메시지를 입력하세요 : ");
            Scanner sc = new Scanner(System.in);

            OutputStream cos = yhd.getOutputStream();
            PrintStream ps = new PrintStream(cos);

            String test2 = sc.nextLine();
            ps.println(test2);
            // 여기까지 요청하는 코드

            // 여기부터 요청받는 코드
            InputStream cis = yhd.getInputStream();
            BufferedInputStream brs = new BufferedInputStream(cis);

            FileOutputStream fileOutputStream = new FileOutputStream("c:\\test2\\" + test2);
            byte[] bytes = brs.readAllBytes();
            for(int i=0; i<bytes.length; i++) {
                fileOutputStream.write(bytes[i]);
                System.out.print(bytes[i]);
            }
            // 여기까지 요청받는 코드

            System.out.print("요청이 이뤄졌습니다.");

            yhd.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}