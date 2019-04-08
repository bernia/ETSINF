import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class ClienteDayTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClienteHTTP
{
   public static void main(String []args) throws UnknownHostException, IOException {
       //System.setProperty("line.separator","\r\n");
       Socket s = new Socket("www.upv.es",80);
       Scanner entrada = new Scanner(s.getInputStream());
       PrintWriter eixida = new PrintWriter(s.getOutputStream(),true);
       eixida.println("GET / HTTP/1.0\r\n\r\n");
       eixida.flush();
       while(entrada.hasNext()){
           System.out.println(entrada.nextLine());
       }
       s.close();
    }
}
