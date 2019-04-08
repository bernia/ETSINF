import java.util.Locale;
/** Classe MesuraCercaLineal: analisi empirica de l'algorisme de cerca lineal.
 *  @author PRG ETSInf
 *  @version Curs 2016-2017
 */
public class MesuraCercaLineal {
    // Constants que defineixen els parametres de mesura
    public static final int MAXTALLA = 100000, INITALLA = 10000; 
    public static final int INCRTALLA = 10000, REPETICIONS = 100000,
    REP_CASMILLOR = 2000000;
    public static final double NMS = 1e3;  // relacio micro - nanosegons

    // Per a crear l'array
    private static int[] crearArray(int talla) {
        int[] a = new int[talla];
        for (int i = 0; i < talla; i++) { a[i] = i; }
        return a;
    } 

    public static void mesuraCercaLineal() {   
        long ti = 0, tf = 0, tt = 0; // Temps inicial, final i total        
        // Imprimir capalera de resultats
        System.out.println("# Cerca lineal. Temps en microsegons");
        System.out.printf("# Talla      Pitjor     Millor    Promedi\n");
        System.out.printf("#----------------------------------------\n");

        // Aquest bucle repeteix el proces per a distintes talles
        for (int t = INITALLA; t <= MAXTALLA; t += INCRTALLA) {
            // Crear l'array
            int[] a = crearArray(t);
      
            // Estudi del cas pitjor: cercar un que no estiga, per exemple -1
            tt = 0;                          // Temps acumulat inicial a 0
            for (int r = 0; r < REPETICIONS; r++) {
                ti = System.nanoTime();      // Temps inicial
                AlgorismesMesurables.cercaLineal(a, -1);
                tf = System.nanoTime();      // Temps final
                tt += (tf - ti);             // Actualitzar temps acumulat
            }
            double tPitjor = (double) tt / REPETICIONS;  // Temps promedi 
                                                         // del cas pitjor
      
            // Estudi del cas millor: cercar a[0]
            // OJO: Com es massa rapid, 
            // el numero de repeticions es major
            tt = 0;                          // Temps acumulat inicial a 0
            for (int r = 0; r < REP_CASMILLOR; r++) {
                ti = System.nanoTime();      // Temps inicial
                AlgorismesMesurables.cercaLineal(a, a[0]);
                tf = System.nanoTime();      // Temps final
                tt += (tf - ti);             // Actualitzar temps acumulat
            }
            double tMillor = (double) tt / REP_CASMILLOR; // Temps promedi 
                                                          // del cas millor
      
            // Estudi del cas promedi: cercar un numero aleatori entre 0 i t-1
            tt = 0;                        // Temps acumulat inicial a 0
            for (int r = 0; r < REPETICIONS; r++) {
                int aux = (int) Math.floor(Math.random() * t); // valor a cercar
                ti = System.nanoTime();  // Temps inicial
                AlgorismesMesurables.cercaLineal(a, aux);
                tf = System.nanoTime();  // Temps final
                tt += (tf - ti);         // Actualitzar temps acumulat
            }
            double tPromed = (double) tt / REPETICIONS; // Temps promedi 
                                                        // del cas promedi

            // Imprimir resultats
            System.out.printf(Locale.US, "%8d %10.3f %10.3f %10.3f\n", 
                              t, tPitjor / NMS, tMillor / NMS, tPromed / NMS);
        }
    }

    public static void main(String[] args) {
        mesuraCercaLineal();
    }
}
