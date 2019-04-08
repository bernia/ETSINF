import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class ClienteDayTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClienteEco
{
   public static void main(String []args) throws UnknownHostException, IOException {
       Socket s = new Socket("zoltar.redes.upv.es",7);
       PrintWriter eixida = new PrintWriter(s.getOutputStream(),true);
       eixida.println("¡¡Hola Mundo!!");
       eixida.flush();
       Scanner entrada = new Scanner(s.getInputStream());
       System.out.println(entrada.nextLine());
    }
}
