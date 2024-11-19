package fi.utu.tech.assignment1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws IOException {
        // TODO: Asiakasohjelma
        Socket s = new Socket("127.0.0.1", 12345);
    }

}
