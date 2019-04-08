import java.util.Locale;
/** Classe MesuraOrdenacio: Estudi empiric de costs dels metodes d'ordenacio.
 *  @author PRG - ETSInf
 *  @version Curs 2016-2017
 */
class MesuraOrdenacio {
    // Constants que defineixen els parametres de mesura
    public static final int REPETICIONS = 200;
    public static final double NMS = 1e3;
    public static final int MAXTALLA = 10000, INITALLA = 1000; 
    public static final int INCRTALLA = 1000;
    
    /* Genera un array d'int de talla t amb valors compresos entre 0 i t-1.
     * @param t int, la talla.
     * @result int[], l'array generat.
     */
    private static int[] crearArrayAleatori(int t) { 
        int[] a = new int[t];
        for (int i = 0; i < t; i++) {
            a[i] = (int) (Math.random() * t);
        }
        return a;
    }
  
    /* Genera un array d'int de talla t ordenat de forma creixent.
     * @param t int, la talla.
     * @result int[], l'array generat.
     */
    private static int[] crearArrayOrdCreixent(int t) { 
        int[] a = new int[t];
        for (int i = 0; i < t; i++) {
            a[i] = i;
        }
        return a;
    }

    /* Genera un array d'int de talla t ordenat de forma decreixent.
     * @param t int, la talla.
     * @result int[], l'array generat.
     */
    private static int[] crearArrayOrdDecreixent(int t) { 
        int[] a = new int[t];
        for (int i = 0; i < t; i++) {
            a[i] = t-i;
        }
        return a;
    }

    public static void mesuraSeleccio() { 
        long tt = 0;
        int[] a;
        System.out.println("# Selecció directa. Temps en microsegons");
        System.out.printf("# Talla      Promedi\n");
        System.out.printf("#-----------------------\n");
        
        for (int t = INITALLA; t <= MAXTALLA; t += INCRTALLA) {
            tt = 0;
            for (int i = 0; i < REPETICIONS; i++) {
                a = crearArrayAleatori(t);
                long ti = System.nanoTime();
                AlgorismesMesurables.seleccio(a);
                long tf = System.nanoTime();
                tt += (tf - ti); 
            }
            double tPromed = (double) tt / (REPETICIONS * NMS);
            System.out.println("    " + t + "    " + tPromed);
        }
        
    }

    public static void mesuraInsercio() { 
        long ti = 0, tf = 0, tt = 0;
        int[] a,b,c;
        System.out.println("# Inserció. Temps en microsegons");
        System.out.printf("# Talla      Pitjor     Millor    Promedi\n");
        System.out.printf("#----------------------------------------\n");
        
        for (int t = INITALLA; t <= MAXTALLA; t += INCRTALLA) {
            tt = 0;
            for (int r = 0; r < REPETICIONS; r++) {
                c = crearArrayOrdDecreixent(t);
                ti = System.nanoTime();
                AlgorismesMesurables.insercio(c);
                tf = System.nanoTime();
                tt += (tf - ti);    
            }
            double tPitjor = (double) tt / REPETICIONS;
            
            tt = 0;
            for (int r = 0; r < REPETICIONS; r++) {
                b = crearArrayOrdCreixent(t);
                ti = System.nanoTime();
                AlgorismesMesurables.insercio(b);
                tf = System.nanoTime();
                tt += (tf - ti);
            }
            double tMillor = (double) tt / REPETICIONS;
            
            tt = 0;
            for (int r = 0; r < REPETICIONS; r++) {
                a = crearArrayAleatori(t);
                ti = System.nanoTime();
                AlgorismesMesurables.insercio(a);
                tf = System.nanoTime();
                tt += (tf - ti);    
            }
            double tPromed = (double) tt / REPETICIONS;
            
            System.out.printf(Locale.US, "%8d %10.3f %10.3f %10.3f\n", 
                              t, tPitjor / NMS, tMillor / NMS, tPromed / NMS);
        }
    }
  
    public static void mesuraMergeSort() { 
        // Completar
    }

    public static void us() {
        System.out.println("Us: java MesuraOrdenacio numero_algorisme");
        System.out.println("   on numero_algorisme es:");
        System.out.println("   1 -> Insercio");
        System.out.println("   2 -> Seleccio");
        System.out.println("   3 -> MergeSort");
    }

    public static void main(String[] args) {        
        if (args.length != 1) {
            us();            
        }
        else {
            try {
                int a = Integer.parseInt(args[0]);
                switch (a) {
                    case 1: 
                        mesuraInsercio();
                        break;
                    case 2: 
                        mesuraSeleccio();
                        break;
                    case 3: 
                        mesuraMergeSort();
                        break;
                    default: 
                        us();
                }
            } catch (Exception e) {
                us(); 
            }
        }
    }
}
