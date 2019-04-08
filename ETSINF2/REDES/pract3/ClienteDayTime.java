import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class ClienteDayTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClienteDayTime
{
   public static void main(String []args) throws UnknownHostException, IOException {
       Socket s = new Socket("ntp.upv.es",13);
       Scanner entrada = new Scanner(s.getInputStream());
       System.out.println(entrada.nextLine());
    }
}
