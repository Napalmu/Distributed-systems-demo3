package fi.utu.tech.assignment2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 12345);
        var os = s.getOutputStream();
        String stringToSend = "Hello World";
        byte[] bytesToSend = stringToSend.getBytes("utf-8");
        os.write(bytesToSend);
        os.close();
    }

}
