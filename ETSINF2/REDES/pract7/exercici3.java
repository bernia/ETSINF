import java.net.*;
import java.io.*;
/**
 * Exercici3
 */
public class exercici3
{
    public static void main(String[] args) throws  IOException, SocketException {
        String ms = new String("ESKEREEEEEEEEEEEEEEE\n");
        DatagramSocket cliente = new DatagramSocket();
        DatagramPacket dp = new DatagramPacket(ms.getBytes(),
            ms.getBytes().length,InetAddress.getByName("rdc00.redes.upv.es"),7777);
        cliente.send(dp);
    }
}
