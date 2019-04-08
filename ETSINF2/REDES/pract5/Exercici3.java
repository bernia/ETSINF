import java.util.Scanner;
import java.io.*;
import java.net.*;
/**
 * Write a description of class ServerTcp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exercici3 {
    public static void main(String args[]) throws IOException {
            ServerSocket ss=new ServerSocket(8000);            
            while(true){ 
                Socket s=ss.accept();
                System.setProperty("line.separator","\r\n");
                Scanner recibe = new Scanner(s.getInputStream());
                PrintWriter envia = new PrintWriter(s.getOutputStream());
                envia.print("HTTP/1.0 200 OK \r\n");
                envia.print("Content-Type: text/plain \r\n");
                envia.print("\r\n");
                String pri = recibe.nextLine();
                while(!pri.equals("")) {
                    envia.println(pri);
                    envia.flush();
                    pri = recibe.nextLine();
                }
                s.close();
            }
    } 
}
