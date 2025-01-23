
package sec12.chap07.multitcp;

import static sec12.chap07.multitcp.ServerMain.HOST;
import static sec12.chap07.multitcp.ServerMain.PORT_NUM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ClientRun implements Runnable {
    private static int lastId = 0;
    private final int ID = ++lastId;
    private Random random = new Random();

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(0, 10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (
                Socket skt = new Socket(HOST, PORT_NUM);

                OutputStream os = skt.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);

                InputStream is = skt.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
        ) {
            String toSend = ID + "번 요청";
            pw.println(toSend);
            System.out.println("📣 전송 : " + toSend);

            // ⭐️ 이 부분에서 서버로부터의 딜레이 발생

            System.out.println("✅ 응답 : " + br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}