import java.net.*;
import java.io.*;
/**
 * Exercici2
 */
public class exercici2
{
    public static void main(String[] args) throws SocketException {
        DatagramSocket cliente = new DatagramSocket();
        System.out.println(cliente.getLocalPort());
    }
}
