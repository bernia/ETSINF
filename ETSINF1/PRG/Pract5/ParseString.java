/**
 * ParseString permiteix separar en paraules una
 * String segons cert conjunt de separadors.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Curs 2016/17)
 */
public class ParseString {
    // Separadors per defecte:
    public static final String SEPARADORS = 
                      "[\\p{Space}\\p{Punct}\\p{Digit}¡¿]+";
    
    private String separadors;
    
    /**
     * Crea un ParseString amb la definicio de separadors
     * donats per defecte en ParseString.SEPARADORS.
     */
    public ParseString() {
        this.separadors = SEPARADORS;
    }        
    
    /**
     * Crea un ParseString amb la definicio de separadors
     * donats en sep.
     * @param sep String. Definicio de separadors a fer servir.
     */
    public ParseString(String sep) {
        this.separadors = sep;
    }    
    
    /**
     * Torna un array amb les paraules separades 
     * segons els separadors definits en la classe.
     * @param s String. La cadena a separar-se.
     * @return el array amb les paraules separades.
     */
    public String[] separar(String s) {
        return (s.trim()).split(this.separadors);
    }

}
