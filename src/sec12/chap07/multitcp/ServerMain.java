package sec12.chap07.multitcp;

import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {
    public static final int PORT_NUM = 3456;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        //  💡 5개의 쓰레드 풀
        ExecutorService es = Executors.newFixedThreadPool(5);
        ServerSocket serverSkt = new ServerSocket(PORT_NUM);

        while (true) {
            es.execute(new ServerRun(serverSkt.accept()));
        }
        //  💡 서버는 계속 틀어놔야 하므로 shutdown() 호출하지 않음
    }

}
