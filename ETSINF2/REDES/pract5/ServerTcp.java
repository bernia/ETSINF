import java.util.Scanner;
import java.io.*;
import java.net.*;
/**
 * Write a description of class ServerTcp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ServerTcp {
    public static void main(String args[]) throws IOException {
            ServerSocket ss=new ServerSocket(7777);            
            while(true){ 
                Socket s=ss.accept();
                System.out.println("Objeto ServerSocket");
                System.out.println("Adreça local:" + ss.getInetAddress());
                System.out.println("Port local:" + ss.getLocalPort());
                System.out.println("Objeto Socket");
                System.out.println("Adreça local:" + s.getLocalAddress());
                System.out.println("Port local:" + s.getLocalPort());
                System.out.println("Adreça:" + s.getInetAddress());
                System.out.println("Port:" + s.getPort());
                Scanner recibe = new Scanner(s.getInputStream());
                PrintWriter envia = new PrintWriter(s.getOutputStream(),true);
                envia.println(recibe.nextLine());
                System.out.println("Se ha conectado un cliente al servidor");
                s.close();
            }
    } 
}


