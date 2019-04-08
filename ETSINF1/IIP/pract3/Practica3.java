import java.util.Scanner;
/**
 *  Classe Practica3.
 *  Una primera classe amb lectura de dades des de teclat, 
 *  i us d'operacions amb int, long, Math i String.
 *  Conte tres errors de compilacio.
 *  @author IIP 
 *  @version Curs 2016-17
 */
public class Practica3 {
    
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Lectura de teclat d'una hora.");
        System.out.print(" -> Introduiu les hores (entre 0 i 23): ");
        int h = teclat.nextInt();
        String hh = "0" + h;
        hh = hh.substring(hh.length() - 2);
        System.out.print(" -> Introduiu els minuts (entre 0 i 59): ");
        int m = teclat.nextInt();
        String mm = "0" + m;
        mm = mm.substring(mm.length() - 2);
        System.out.println("Hora introduida: " + hh + ":" + mm);
        
        long tMinTotal = System.currentTimeMillis() / (60 * 1000);
        long tMinActual = (int) (tMinTotal % (60 * 24));
        int tHoresHui = (int) (tMinActual / 60);
        String hores = "0" + tHoresHui;
        hores = hores.substring(hores.length() - 2);
        int minutsHui = (int) (tMinActual % 60);
        String minuts = "0" + minutsHui;
        minuts = minuts.substring(minuts.length() - 2);
        System.out.println("Hora actual: " + hores + ":" + minuts 
            + " (Temps UTC)");
        int difHores = Math.abs(h - tHoresHui); 
        int difMinHora = Math.abs(m - minutsHui);
        int difMin = (difHores * 60) + difMinHora; 
        System.out.println("Diferència de minuts entre ambdues hores: " 
            + difMin + " (" + difHores + " hores i " + difMinHora 
            + " minuts )");       
        
        //Calcul lectura d'hora d'altra manera (Activitat extra)
        Scanner teclat2 = new Scanner(System.in);
        System.out.println("Dónam una altra hora.");
        System.out.print(" -> Introdueix les hores (entre 0 i 23): ");
        int h2 = teclat2.nextInt();
        int hDesenes = h2 / 10;
        int hUnitats = h2 % 10;
        String hhh = "" + hDesenes + hUnitats;
        System.out.print(" -> Introdueix els minuts (entre 0 i 59): ");
        int m2 = teclat2.nextInt();
        int mDesenes = m2 / 10;
        int mUnitats = m2 % 10;       
        String mmm = "" + mDesenes + mUnitats;
        System.out.println("Hora introduida: " + hhh + ":" + mmm);
        
        
        System.out.println("Es anterior l'hora " + hh + ":" + mm
                           + " a l'hora actual?:");
        boolean esAnterior = h < tHoresHui || h == tHoresHui && m < minutsHui;
        System.out.println(esAnterior);
        
        System.out.println("Es capicua l'hora " + hh + ":" + mm + " ?: ");
        boolean esCapicua = hh.charAt(0) == mm.charAt(mm.length()-1)
                            && hh.charAt(hh.length()-1) == mm.charAt(0);
        System.out.println(esCapicua);
        
 
    }
}
