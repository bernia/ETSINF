package iipUtil;

import java.util.Scanner;
import iipUtil.Instant;


/**
 * Write a description of class practica4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class practica4 {
   public static void main(String[] args) {
  
    
    
    //Llegir hores i minuts del teclat
    Scanner teclat = new Scanner(System.in);
    System.out.println("Lectura de teclat d'una hora.");
    System.out.print(" -> Introduiu les hores (entre 0 i 23): ");
    int h = teclat.nextInt();
    System.out.print(" -> Introduiu els minuts (entre 0 i 59): ");
    int m = teclat.nextInt();
        
    //Crear instant amb eixes hores i minuts
    Instant hIntroduida = new Instant(h, m);
    
    //mostrar per pantalla 
    System.out.println("Hora introduïda: " + hIntroduida.toString());

    //Crear instnt amb l'hora UTC
    Instant hActual = new Instant();
    
    //Mostrar per pantalla 
    System.out.println("Hora actual: " + hActual.toString() + "(Temps UCT)");
    
    //Mostrar la diferència en minuts entre ambdues hores
    int dif = Math.abs(hIntroduida.aMinuts() - hActual.aMinuts());
    System.out.println("La diferència en minuts entre ambdues hores: " + dif);
    
    
    }
    
}