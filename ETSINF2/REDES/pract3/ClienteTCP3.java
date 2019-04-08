import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 */
public class ClienteTCP3
{
   public static void main(String []args) {
       try{
           Socket s = new Socket("www.upv.es",80);
           System.out.println("Puerto remoto: " + s.getPort());
           System.out.println("IP remota: " + s.getInetAddress());
           System.out.println("Puerto local: " + s.getLocalPort());
           System.out.println("IP local: " + s.getLocalAddress());
           s.close();
       } catch (UnknownHostException e) {
           System.out.println("Nombre de servidor desconocido");
       } catch (IOException e) {
           System.out.println("No es posible realizar conecsion"); 
       }
    }
}
