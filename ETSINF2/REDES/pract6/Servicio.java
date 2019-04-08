import java.util.Scanner;
import java.io.*;
import java.net.*;
/**
 * Write a description of class Servicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Servicio extends Thread
{
   Socket cliente;
   
   public Servicio(Socket t) {
       cliente = t; 
    }
   
   public void run() {
       try{
       Scanner entrada = new Scanner(cliente.getInputStream());
       String var = "";
       while(!(var.equals("FIN"))) {
           PrintWriter pw = new PrintWriter(entrada.getOutputStream());
           pw.print(var);
           var = sc.nextLine();
        }
    } catch (IOException e) {e.printStackTrace();}
    }
}
