import java.util.Locale;
import java.util.Scanner;
/** 
 *  Classe VendaEntrades.
 *  
 *  @author (IIP. Grau en Informatica. ETSINF, UPV)  
 *  @version Curs 2016/17
 */
public class VendaEntrades {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);

        // Lectura de les dades i creacio de l'Entrada
        System.out.println("Caracteristiques de l'entrada: ");
        System.out.print("   Titol: ");
        String titol = teclat.nextLine();
        System.out.print("   Cinema: ");
        String cinema = teclat.nextLine();
        System.out.print("   Hora Sessió: ");
        int hores = teclat.nextInt();
        System.out.print("   Minut Sessió: ");
        int minuts = teclat.nextInt();
        
    
        Entrada e = new Entrada(titol, cinema, hores, minuts);

        // Lectura de dades per a aplicar descomptes
        // variables a utilitzar inicialitzades per defecte a false
        boolean diaEspectador = false, festiu = false, 
                vespra = false, targetaClient = false;
    
        System.out.print("Edat? ");
        int edat = teclat.nextInt(); teclat.nextLine();
    
        System.out.print("Es el dia de l'espectador? "); 
        String res = teclat.next().toUpperCase();
        if (res.equals("SI")) { diaEspectador = true; }

        // Lectura de la RESTA de dades per a 
        // aplicar DESCOMPTES         
        System.out.print("Es dia festiu? "); 
        String res2 = teclat.next().toUpperCase();
        if (res2.equals("SI")) { festiu = true; }
        
        System.out.print("Es vespra de festiu? "); 
        String res3 = teclat.next().toUpperCase();
        if (res3.equals("SI")) { vespra = true; }
        
        System.out.print("Té la targeta de client? "); 
        String res4 = teclat.next().toUpperCase();
        if (res4.equals("SI")) { targetaClient = true; }
    
    
        // Calcul del preu final de l'Entrada e, 
        // invocant al metode preuFinal
        double pFinal = e.preuFinal(edat, diaEspectador, festiu, vespra,
                        targetaClient);

        System.out.println("El preu final de l'entrada es: "  
            + String.format("%.2f", pFinal) + " euros");
    }
}