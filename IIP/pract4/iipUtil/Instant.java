package iipUtil;
import java.util.Scanner;
/**
 * <p>
 * Aquesta classe permet representar instants o marques de temps
 * (<code>Timestamp</code>) amb detall de minuts. Així, aquesta 
 * classe representa el moment o instant que defineix una hora,
 * en aquest cas, les hores i els minuts de la mateixa.
 * </p>
 * 
 *  @author IIP 
 *  @version Curs 2016-17
 */
public class Instant {   
    
    // ATRIBUTS:
    /** Variable entera per emmagatzemar les hores. 
     *  Ha de pertanyer al rang <code>[0,23]</code>. */
    private int hores;
    /** Variable entera per emmagatzemar els minuts. 
     *  Ha de pertanyer al rang <code>[0,59]</code>. */
    private int minuts;

    // CONSTRUCTORS:
    /**
     *  Crea un <code>Instant</code> amb el valor de
     *  les hores i els minuts que rep com arguments,
     *  <code>h</code> i <code>m</code> respectivament.
     *
     *  <p> Ha de complir-se la precondició: 
     *  <code>0 <= h < 24, 0 <= m < 60</code>. </p>
     */
    public Instant(int h, int m) {
        hores = h;
        minuts = m;
    }
    
    /**
     * Crea un <code>Instant</code> amb el valor de l'instant
     * actual UTC (temps universal coordinat).
     */
    public Instant() {
        long tMinTotal = System.currentTimeMillis() / (60 * 1000);
        long tMinActual = (int) (tMinTotal % (60 * 24));
        int tHoresHui = (int) (tMinActual / 60);
        int minutsHui = (int) (tMinActual % 60);
        hores = tHoresHui;
        minuts = minutsHui;    
    }
        
    
    // CONSULTORS I MODIFICADORS:
    /** Torna les <code>hores</code> de l’Instant. */
    public int getHores() { return hores; } 
    /** Torna els <code>minuts</code> de l’Instant. */
    public int getMinuts() { return minuts; }
    /** Actualitza les <code>hores</code> de l’Instant. */
    public void setHores(int hh) { hores = hh; }
    /** Actualitza els <code>minuts</code> de l’Instant. */
    public void setMinuts(int mm) { minuts = mm; }
    
   
    // ALTRES MÈTODES:
    /** Torna l'Instant en el format "<code>hh:mm</code>". */
    public String toString()  {
        String hh = "0" + hores;
        hh = hh.substring(hh.length() - 2);
        String mm = "0" + minuts;
        mm = mm.substring(mm.length() - 2);
        return hh + ":" + mm;
    }
   
    /** Torna <code>true</code> sii <code>o</code> és 
     *  un objecte de la classe <code>Instant</code>
     *  i les seues <code>hores</code> i <code>minuts</code>
     *  coincideixen amb els de l'objecte en curs. 
     */
    public boolean equals(Object o) {
        return o instanceof Instant
            && this.hores == ((Instant) o).hores
            && ((Instant) o).minuts == minuts;
    }
      
    /** Torna el número de minuts transcorreguts des de les 00:00 
     *  fins l'instant representat per l'objecte en curs.
     */
    public int aMinuts() {
        return hores * 60 + minuts;
    }
    
    /** Compara cronològicament l'instant de l'objecte en curs
     *  amb el de l'objecte de la classe <code>Instant</code> 
     *  referenciat per <code>altre</code>.
     *
     *  <p>
     *  El resultat és un valor:
     *  <ul>
     *     <li> negatiu si l'instant de l'objecte en curs 
     *     és anterior al de <code>altre</code>, </li>
     *     <li> zero si són iguals, </li>
     *     <li> positiu si l'Instant de l'objecte en curs 
     *     és posterior al de <code>altre</code>. </li>
     *  </ul>
     *  </p>
     */
    public int compareTo(Instant altre) {
        return this.aMinuts() - altre.aMinuts();        
    }
    

    // ACTIVITAT EXTRA:
    /** Torna un <code>Instant</code> a partir de la descripció 
     *  textual (<code>String</code>) en format "<code>hh:mm</code>".
     */
    
}
