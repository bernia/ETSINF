import iipUtil.Instant;
/**
 *  Classe Entrada.   
 *  
 *  @author (IIP. Grau en Informatica. ETSINF, UPV)   
 *  @version Curs 2016/17
 */
public class Entrada {
    // Definicio CONSTANTS per a calcular el preu de l'entrada:
    /** Preu Base a partir del qual es calcula el preu final */
    public static final double PREU_BASE = 7.60;
   
    /** Edat senior */
    public static final int SENIOR = 65;
    /** Descompte per espectador major de 65 anys (SENIOR) */
    public static final double DESCOMPTE_SENIOR = 0.3;
   
    /** Descompte per ser el dia de l'espectador */
    public static final double DESCOMPTE_DIA_ESPECTADOR = 0.8;
  
    /** Descompte per ser festiu */
    public static final double DESCOMPTE_FESTIU = 1.2;
  
    /** Descompte per ser vespra de festiu */
    public static final double DESCOMPTE_VESPRA = 1.1;
  
    /** Descompte per ser client */
    public static final double CLIENT = 0.8;
   
    // Definicio d'ATRIBUTS d'INSTANCIA PRIVATS
    private String titol;
    private String cinema;
    private Instant horaSessio;

    /** Crea una Entrada amb titol t, cinema c, hores hs,
     *  i minuts ms de la sessio.
     */
    public Entrada(String t, String c, int hs, int ms) {
   
     titol = t;
     cinema = c;
     horaSessio = new Instant(hs,ms);
   
    }  

    /** Torna el titol de la pel.licula de l'Entrada. */
    public String getTitol() { return titol; }
    
    /** Torna el cinema de l'Entrada. */
    public String getCinema() { return cinema; }
 
    /** Torna l'hora de la sessio de l'Entrada. */
    public Instant getHoraSessio() { return horaSessio; }
   
    /** Actualitza a t el titol de la pelicula de l'Entrada. */
    public void setTitol(String t) { titol = t; }
    
    /** Actualitza a c el cinema de l'Entrada. */
    public void setCinema(String c) { cinema = c; }
    
    /** Actualitza a hs l'hora de la sessio de l'Entrada. */
    public void setHoraSessio(Instant hs) { horaSessio = hs; }
    
    /** Torna un String amb les dades de l'Entrada. 
     *  El format de l'eixida es com el de l'exemple seguent:
     *   "Anochece en La India", projectada en Cines Babel, a les 22:30
     *   Preu base: 7.60 euros
     */
    public String toString() {
        return "\"" + titol + "\", projectada en " + cinema + ", a les " 
            + horaSessio + "\nPreu base: " + PREU_BASE + " euros";
    }

    /** Comprova si o es una Entrada amb les mateixes dades 
     *  que l'Entrada actual. */
    public boolean equals(Object o) {
        return o instanceof Entrada
        && this.titol == ((Entrada) o).titol
        && this.cinema == ((Entrada) o).cinema
        && this.horaSessio.getHores() == ((Entrada) o).horaSessio.getHores()
        && this.horaSessio.getMinuts() == ((Entrada) o).horaSessio.getMinuts();
        
    }
   
    /** Calcula el preu final de l'Entrada aplicant al preu base 
     *  els descomptes segons l'edat de l'espectador, el dia de 
     *  la sessio (espectador, festiu o vespra) i si te targeta 
     *  de client o no.
     */ 
    public double preuFinal(int edat, boolean diaEspec, boolean festiu, 
        boolean vespra, boolean tClient) {
        double resultat = 0; 
            if (edat >= SENIOR) { resultat = PREU_BASE * DESCOMPTE_SENIOR; }
                else if (diaEspec) { resultat = PREU_BASE * DESCOMPTE_DIA_ESPECTADOR; }
                     else if (festiu) { resultat = PREU_BASE * DESCOMPTE_FESTIU; }
                          else if (vespra) { resultat = PREU_BASE * DESCOMPTE_VESPRA; }
                               else { resultat = PREU_BASE; }
            if (tClient) { resultat = 0.8 * resultat; }
        return resultat;
    }  
}
