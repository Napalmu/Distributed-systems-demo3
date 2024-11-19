package fi.utu.tech.assignment3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 12345);
        Socket s2 = new Socket("127.0.0.1", 12345);
        s.getOutputStream().write(("Hello World").getBytes("utf-8"));
        s2.getOutputStream().write(("Hello from another thread!").getBytes("utf-8"));
        s.close();
        s2.close();
    }

}
