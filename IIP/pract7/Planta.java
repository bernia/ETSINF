import iipUtil.Instant;
/** Classe Planta: representa l'ocupacio d'una planta de parking,
 *  amb els tickets associats als vehicles estacionats en
 *  la mateixa.
 *  @author IIP
 *  @version Curs 2016/2017
 */
public class Planta {
    // Atributs d'instancia
    private int numPlanta;
    private Ticket[] llocs;
    private int llocsLliures;
    
    /** Crea una Planta donats un numero de planta i un numero 
     *  de llocs.
     *  La planta, a l'inici, esta buida (sense vehicles).
     *  @param numP int, el numero de planta, numP >= 0.
     *  @param numLlocs int, el numero de llocs, numLlocs > 0.
     */
     public Planta(int numP, int numLlocs){
         numPlanta = numP;
         llocs = new Ticket[numLlocs];
         llocsLliures = numLlocs;
     }

    /** Torna el numero de planta.
     *  @return int, el numero de planta del parking.
     */
    public int getPlanta() {
        return numPlanta;
    }

    /** Torna el numero de llocs lliures.
     *  @return int, el numero de llocs lliures de la planta.
     */  
    public int getLlocsLliures() { 
        return llocsLliures;
    }

    /** Torna true si la planta esta plena o false 
     *  en cas contrari.
     *  @return boolean, true si planta plena (sense llocs lliures),
     *  false en cas contrari.
     */
    public boolean estaPlena() {
        boolean res = true;
        if (llocsLliures != 0) { res = false; }
        return res;
    }

    /** Torna el primer lloc lliure (de numero menor) en la planta, o 
      * -1 si no hi ha llocs lliures. 
      * @return int, numero del primer lloc lliure (de numero menor) 
      * en la planta o -1 si no hi ha llocs lliures.
      */
    public int primerLliure() {
        if (estaPlena()) { return -1; }
        int pos = 0;
        while (llocs[pos] != null) { pos++; }
        //Acaba quan hem trobat la primera plaça lliure (sentit ascendent)
        return pos;
    }

    /** Si hi ha llocs lliures, associa el ticket al primer lloc
     *  lliure (de numero menor).   
     *  Precondicio: el Ticket no esta associat a cap lloc.
     *  @param t Ticket, el ticket del vehicle a estacionar.     
     */
    // Usa estaPlena() i primerLliure()
    public void estacionar(Ticket t) {
        if ( !this.estaPlena()) {
            int pl = primerLliure();
            llocs[pl] = t;
            t.setLloc(pl);
            this.llocsLliures--;
        }
    }
       
    /** Comprova si un vehicle, donada la seua matricula, esta en la planta.
     *  @param m String, la matricula del vehicle a buscar.
     *  @return Ticket, el ticket associat al vehicle, si es troba, 
     *  o null en cas contrari.
     */
    public Ticket buscarTicket(String m) {
            //         Ticket res = null;
            //         for( int i = 0; m.compareTo(llocs[i].getMatricula()) != 0; i++){
            //             res = llocs[i];
            //         }
            //         return res;
            int pos = 0;
            while(pos < llocs.length) {
                if (llocs[pos] != null 
                && llocs[pos].getMatricula().equals(m)) {
                    return llocs[pos];
                }
                pos++;
            }
            return null;
    }

    /** Torna el numero de minuts trancorreguts des de l'entrada del
     *  vehicle que ocupa un lloc donat fins una hora d'eixida donada,
     *  actualitzant la planta.
     *  @param plz int, el numero de lloc. 
     *    Precondicio: 0 <= plz < llocs.length i llocs[plz] != null.
     *  @param hEix Instant, l'hora d'eixida. 
     *    Precondicio: posterior a l'hora d'entrada del vehicle.
     *  @return int, numero de minuts que el vehicle ha estat
     *  al parking.
     */
    public int retirar(int plz, Instant hEix) {
        int res = hEix.aMinuts() - (llocs[plz].getEntrada()).aMinuts();
        llocs[plz] = null;
        llocsLliures++;
        return res;
    }

    /** Retira tots els vehicles de la planta i torna el numero total 
     *  de minuts que els vehicles han estat en la planta fins 
     *  una hora d'eixida donada.
     *  @param hEix Instant, l'hora d'eixida. 
     *    Precondicio: posterior a l'hora d'entrada de tots 
     *    els vehicles de la planta.
     *  @return int, el numero total de minuts transcorreguts.
     */
    // Usa retirar(int, Instant)
    public int retirarTots(Instant hEix) {
        int res = 0;
        for(int i = 0; i < llocs.length; i++) {
            if(llocs[i] != null) {res += retirar(i, hEix);}
        }
        return res;
    }
  
    /** Torna un String amb l'ocupacio de la planta, amb 'X' ocupada, 
      * ' ' lliure. <br>
      * Format: <pre> PLANTA (en 3 posicions), espai, ocupacio 
      * ("  X" o "   "), espai, ..., ocupacio ("  X" o "   "), 
      * espai, '\n'</pre>
      * Exemple de format (Planta 2 amb 5 llocs, ocupats el 0, 2, 3 i 4): 
      * <pre> "--2---X-------X---X---X-" </pre>
      * S'ha utilitzat el - per a representar un espai en blanc.
      * @return String, representacio de l'ocupacio de la planta.
      */
    public String toString() {
        String res = "  " + this.getPlanta() + " ";
        for(int i = 0; i < llocs.length; i++) {
            if(llocs[i] == null) { res += "    "; }
            else { res += "  X "; }
        }
        res += "\n";
        return res;
    }
    
}
