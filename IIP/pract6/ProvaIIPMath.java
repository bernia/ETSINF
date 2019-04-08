import java.util.Scanner;
import java.util.Locale;
/**
 * ProvaIIPMath permet que l'usuari compare el valor tornat per
 * les seues funcions sqrt(x) (arrel quadrada de x) i log(x) (logaritme de x)
 * amb els proporcionats pel Java en la seua llibreria Math.
 * 
 * @author (IIP-PRG-DSIC-ETSINF. pmarques)
 * @version (curs 2016-17)
 */
public class ProvaIIPMath {
    
    /** No es poden crear objectes d'aquest tipus. */
    private ProvaIIPMath() { }    
    
    public static void main(String[] args) {
        
        Scanner tcl = new Scanner(System.in).useLocale(Locale.US);
        
        System.out.println("Comparació de sqrt i log (IIPMath i Math).");
        System.out.println("Per acabar introduix un valor 0 o negatiu.\n");
        
        System.out.print("Valor: ");
        double valor = tcl.nextDouble();        
        
        while (valor > 0) { 
            
            double xr1 = IIPMath.sqrt(valor);
            double xr2 = Math.sqrt(valor); 
            System.out.printf(Locale.US, 
                    "%14s %+1.16e \n %14s %+1.16e %8s %1.3g%n",
                    "SQRT-- IIPMath:", xr1, "Math:", xr2, "|Diff|:",
                    Math.abs(xr1 - xr2));
            
            double xl1 = IIPMath.log(valor);
            double xl2 = Math.log(valor);  
          
            System.out.printf(Locale.US,
                   "%14s %+1.16e \n %14s %+1.16e %8s %1.3g%n",
                   "LOG -- IIPMath:", xl1, "Math:", xl2, "|Diff|:",
                   Math.abs(xl1 - xl2));
                
            System.out.printf("%1$6s %2$20s %3$18s%n", "------", 
                              "--------------------------------",
                              "-----------------");
            
            System.out.print("Valor: ");
            valor = tcl.nextDouble();
        }
    }
         
            
}
