import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class ClienteDayTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClienteSMTP
{
   public static void main(String []args) throws UnknownHostException, IOException {
       //System.setProperty("line.separator","\r\n");
       Socket s = new Socket("smtp.upv.es",25);
       Scanner entrada = new Scanner(s.getInputStream());
       System.out.println(entrada.nextLine());
       PrintWriter eixida = new PrintWriter(s.getOutputStream(),true);
       eixida.println("HELO rdc18.redes.upv.es");
       eixida.flush();
       System.out.println(entrada.nextLine());
       s.close();
    }
}
