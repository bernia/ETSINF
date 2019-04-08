import iipUtil.Instant;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
/** Classe Parking: representa l'ocupacio de les plantes d'un parking 
 *  junt amb la tarifa en euros per minut.
 *  @author IIP
 *  @version Curs 2016/2017
 */
public class Parking {
    /** Numero de llocs per planta. */
    public static final int LLOCS_X_PLANTA = 5;
    // Atributs d'instancia
    private Planta[] plantes;
    private double tarifa;
    
    /** Crea un parking a partir del numero de plantes 
     *  i la tarifa en euros per minut.
     *  El parking, a l'inici, esta buit.
     *  @param numPlt int, el numero de plantes, numPlt > 0.      
     *  @param tf double, la tarifa en euros per minut, tf > 0.
     */
    public Parking(int numPlt, double tf) {
        plantes = new Planta[numPlt];
        for(int i = 0; i < plantes.length; i++) {
            Planta x = new Planta(i, LLOCS_X_PLANTA);
            plantes[i] = x;
        }
        tarifa = tf;
    }

    /** Crea un parking a partir de les dades d'un fitxer 
     *  el nom del qual se passa com parametre.<br>
     *  Format del fitxer:
     *  <pre>
     *  plantes 
     *  tarifa
     *  planta matricula hores minuts
     *  ...
     *  planta matricula hores minuts
     *  </pre>
     *  Les dades son correctes (no hi ha vehicles ni llocs repetits, 
     *  les plantes i les hores son correctes). 
     *  @param nomFitx String, el nom del fitxer amb les dades.
     */
    public Parking(String nomFitx) {
        Scanner in = null;
        try {
            in = new Scanner(new File(nomFitx)).useLocale(Locale.US);
            int numPlt = in.nextInt(); 
            double tf = in.nextDouble();

            plantes = new Planta[numPlt];
            for (int i = 0; i < plantes.length; i++) {
                plantes[i] = new Planta(i, LLOCS_X_PLANTA);
            }            
            tarifa = tf;
            
            while (in.hasNext()) {
                int plt = in.nextInt(); 
                String mat = in.next(); 
                int h = in.nextInt(); 
                int m = in.nextInt();
                Ticket t = new Ticket(mat, new Instant(h, m));
                t.setPlanta(plt);
                plantes[plt].estacionar(t);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\n***ERROR***: " 
                + "No es pot accedir al fitxer " + nomFitx);
        } finally {
            if (in != null) { in.close(); }
        }          
    }

    /** Torna el numero de plantes.
     *  @return int, numero de plantes del parking.
     */
    public int getNumPlantes() { return plantes.length; }
    
    /** Torna la tarifa.
     *  @return double, tarifa del parking en euros per minut.
     */
    public double getTarifa() { return tarifa; }

    /** Actualitza la tarifa.
     *  @param tf double, la nova tarifa 
     *  (en euros per minut), tf > 0.
     */
    public void setTarifa(double tf) { tarifa = tf; }

    /** Comprova si el parking esta ple.
     *  @return boolean, true si ple, o false en cas contrari.
     */
    // Usa estaPlena() de Planta
    public boolean estaPle() {
        boolean res = true;
        for(int i = 0; i < getNumPlantes(); i++) {
            if(!plantes[i].estaPlena()) { res = false; }
        }
        return res;
    }

    /** Donat el ticket associat a un vehicle, estaciona el vehicle
     *  en la planta de numero menor amb llocs lliures, en el lloc 
     *  de numero menor.
     *  Precondicio: parking amb llocs lliures i vehicle no present.
     *  @param t Ticket, el ticket del vehicle a estacionar.
     */
    // Usa estaPlena() i estacionar(Ticket) de Planta i
    // setPlanta(int) de Ticket
    public void estacionar(Ticket t) {
        int pl = 0;
        while(plantes[pl].estaPlena()){
            pl++;
        }
        t.setPlanta(pl);
        plantes[pl].estacionar(t);
    }
    
    /** Donats el ticket associat a un vehicle i un numero de planta 
     *  de preferencia, estaciona el vehicle en aquesta planta, si hi ha 
     *  llocs lliures, o si no, en el planta mes propera amb llocs lliures, 
     *  seguint l'estrategia del butlleti.   
     *  Precondicio: parking amb llocs lliures i vehicle no present.      
     *  @param t Ticket, el ticket del vehicle a estacionar.       
     *  @param pref int, la planta de preferencia.
     */
    // Usa estaPlena() i estacionar(Ticket) de Planta i
    // setPlanta(int) de Ticket
    public void estacionar(Ticket t, int pref) {
         if(!plantes[pref].estaPlena()) { t.setPlanta(pref); plantes[pref].estacionar(t); }
         else {
            int mes = pref;
            int menys = pref;
            boolean trobat = false;
            while (!trobat) {
                mes++;
                menys--;
                if (menys >= 0 && plantes[menys].estaPlena() == false) {
                    trobat = true;
                    pref = menys;
                } else if (mes < plantes.length && plantes[mes].estaPlena() == false) {
                    trobat = true;
                    pref = mes;
                }
            }
            t.setPlanta(pref);
            plantes[pref].estacionar(t);
         }
    }

    /** Comprova si un vehicle de matricula donada esta al parking. 
     *  @param m String, la matricula del vehicle a buscar.
     *  @return Ticket, el ticket associat al vehicle de matricula 
     *  donada, si es troba, o null si no es troba.
     */
    
    //Usa buscarTicket(String) de Planta
    public Ticket buscarTicket(String m){
        int pl = 0;
        while(pl < plantes.length) {
            if(plantes[pl].buscarTicket(m) != null){
                return plantes[pl].buscarTicket(m);
            }
            pl++;
        }
        return null;
        
    }
    
    /** Retira del parking, donada una hora d'eixida, el vehicle 
     *  associat al ticket donat i torna l'import a pagar.
     *  @param t Ticket, el ticket associat al vehicle a retirar. e
     *       Precondicio: sempre esta.
     *  @param hEix Instant, l'hora d'eixida del vehicle. 
     *       Precondicio: posterior a l'hora d'entrada.
     *  @return double, import en euros a pagar.
     */
    // Usa retirar(int, Instant) de Planta
    public double retirar (Ticket t, Instant hEix) {
        return plantes[t.getPlanta()].retirar(t.getLloc(), hEix) * tarifa;
        
    }

    /** Buida el parking, retirant tots els vehicles, suposant   
     *  que son les 23:59, i torna l'import total.
     *  @return double, import total en euros a pagar per 
     *  tots els vehicles retirats del parking.
     */
    // Usa retirarTots(Instant) de Planta
    public double buidarParking(){
        int min = 0;
        int pl = 0;
        Instant hora = new Instant(23,59);
        while ( pl < plantes.length ) {
            min += plantes[pl].retirarTots(hora);
            pl++;
        }
        return min * tarifa;
    }
  
    /** Torna un String que representa l'ocupacio del parking, 
     *  amb 'X' ocupada, amb ' ' lliure.
     *  Ha de col.locar una primera linia amb els numeros de 
     *  lloc corresponents.<br>
     *  Exemple: el seguent String representa un parking, amb 
     *  3 plantes i 5 llocs per planta, en el que estan ocupats:
     *  en la planta 0, els llocs 0, 1 i 3;
     *  en la planta 1, els llocs 1, 2 i 4;
     *  en la planta 2, els llocs 0 i 1.
     *  <pre>
     *          "      0   1   2   3   4 
     *             0   X   X       X    
     *             1       X   X       X
     *             2   X   X             " </pre>
     *  @return String, representacio del parking.
     */
    // Usa toString() de Planta
    public String toString() {
        String res = "      0   1   2   3   4 \n";
        for(int pl = 0; pl < plantes.length; pl++ ){
            res += plantes[pl].toString();
    }
    return res;
   }
}
