
/**
 * Write a description of class Hilo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hilo extends Thread
{
   String message;
   
   public Hilo(String t) {
       message = t; 
    }
   
   public void run() {
       for(int i=0; i<10; i++) {
           System.out.println(message);
           try {
               sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
       }
    }
    
   public static void main (String[] args) {
       Hilo h = new Hilo("Hola");
       h.start();
       Hilo v = new Hilo("Caracola");
       v.start();
       Hilo t = new Hilo("gominola");
       t.start();
    }
}
