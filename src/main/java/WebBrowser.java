import java.io.*;
import java.net.Socket;

public class WebBrowser {
    public static void main(String[] args) throws IOException {
        Socket cs = new Socket("192.168.0.114",9999);

        OutputStream os = cs.getOutputStream();
        PrintStream ps = new PrintStream(os);

        ps.println("GET / HTTP/1.1");
        ps.println("Host: 192.168.0.114");
        ps.println();

        InputStream is = cs.getInputStream();  // 바이트 단위로 받음
        InputStreamReader isr = new InputStreamReader(is);  // 바이트 단위를 글자 단위로 받고 싶어서 다시 받음
        BufferedReader br = new BufferedReader(isr);  // 성능을 좋게 하기 위해 버퍼드 리더를 추가해줌

        String result = null;
        while((result = br.readLine()) != null) {
            System.out.println(result);
        }

        cs.close();
        br.close();
        ps.close();
    }
}
