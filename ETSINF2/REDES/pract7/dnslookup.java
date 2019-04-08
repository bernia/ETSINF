import java.net.*;
/**
 * Ejercicio 1 practica 7
 */
public class dnslookup
{
    public static void main (String[] args) throws UnknownHostException {
        InetAddress ipServer = InetAddress.getByName(args[0]);
        System.out.println(ipServer.toString());
    }
}
