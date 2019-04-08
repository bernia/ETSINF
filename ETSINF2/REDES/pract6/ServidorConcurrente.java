import java.util.Scanner;
import java.io.*;
import java.net.*;
/**
 * Write a description of class ServidorConcurrente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ServidorConcurrente
{
    public static void main(String[] args) throws 
                            IOException {
       int puerto = 7777;
       ServerSocket servidor = new ServerSocket(puerto);
       while(true) {
           Socket cliente = servidor.accept();
           Servicio Cl = new Servicio(cliente);
           Cl.start();
           Scanner recibe = new Scanner(cliente.getInputStream());
           PrintWriter envia = new PrintWriter(cliente.getOutputStream(),true);
           while (recibe.nextLine() != "FIN") {
               envia.println(recibe.nextLine());
            }
           servidor.close();
        }
                            
   }
}
