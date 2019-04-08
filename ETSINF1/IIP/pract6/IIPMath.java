/**
 * La classe IIPMath implementa algunes operacions matematiques:
 * IIPMath.sqrt(double) i IIPMath.log(double).
 *
 * @author (IIP-PRG-DSIC-ETSINF)
 * @version (Year 2016-17)
 */
public class IIPMath {
    
    // A COMPLETAR
    public final static double LOG_2 = 0.6931471805599453;
        
    /**
     * Torna l'arrel quadrada de x >= 0, amb error epsilon > 0. 
     * @param x. El valor, que ha de ser igual o major que zero.
     * @param epsilon. El valor de l'error màxim.
     * @return double. L’arrel de x amb error màxim epsilon.
     */
    public static double sqrt(double x, double epsilon) {
        double res = 0;
        double tAnt = 999999999;
        double tAct = (x + 1) / 2.0;
        double dif = tAnt - tAct; 
        double e = epsilon;
        if (x == 0) { res = 0; }
        else {
            while (dif >= e) {
                tAnt = tAct;
                tAct = (tAnt + (x / tAnt)) / 2.0;
                dif = tAnt-tAct;
            }   
        }
        res = tAct;
        return res;
    }            

    /**
     * Torna l'arrel quadrada de x >= 0, amb error 1e-15. 
     * @param x. El valor, que ha de ser igual o major que zero.
     * @return double. L’arrel de x amb error màxim 1e-15.
     */
    public static double sqrt(double x) {    
//         double res = 0;
//         double arrel = x;
//         res = IIPMath.sqrt(arrel, 1e-15);
//         return res;
    return sqrt(x, 1e-15);
    }  
                    
    /* ******************************************************** */
    /* ******************************************************** */
    /* ******************************************************** */
                
    /**
     * Torna log(z), 1/2 <= z < 1, amb error epsilon > 0.
     * @param z. El valor, que ha de ser igual o major que 1/2 i menor que 1.
     * @param epsilon. L'error màxim amb valor positiu.
     * @return double. El logaritme del valor x.
     */
    public static double logBase(double z, double epsilon) {
        double res = 0;
        double y = (1 - z) / (1 + z);
        double e = epsilon;
        double tAct = y;
        double tAnt  = tAct;
        double k = 1.0;
        double sum = y;
        while (tAct >= e) {
            tAct = y * y * (((2 * k) - 1) / ((2 * k) + 1)) * tAnt;
            k++;
            sum = sum + tAct;
            tAnt = tAct;
        }
        //         tAct = y * y * (((2 * k) - 1) / ((2 * k) + 1)) * tAnt;
        //         k++;
        //         sum += tAct;
        
        res = (-2) * sum ;
        return res;
        
    }
            
    /**
     * Torna log(x), x > 0, amb error epsilon > 0.
     * @param x. El valor del qual es vol calcular el log.
     * @param epsilon. L'error màxim, ambv 
     */
    public static double log(double x, double epsilon) {
        if (x<0) { return Double.NaN; }
        if (x==0) {return Double.NEGATIVE_INFINITY;}
        if (x==1) {return 0;}
        int m = 0;
        double z = x;
        if (z>=1) { 
            //Càlcul de m y z, amb x*2^m = z i 1/2 <= < < 1
            while (z>=1) { z = z / 2; m++; }
            //Càlcul del log x
            return m * LOG_2 + logBase(z, epsilon);
        
        }
        else if (z < 0.5) {
                //Càlcul de m y z, amb x*2^m = z i 1/2 <= < < 1
                while (z < 0.5) {z = z * 2; m++; }
                //Càlcul del log x
                return -m * LOG_2 + logBase(z, epsilon);
            }
            else { return logBase(z, epsilon); }
    }
   
    /**
     * Torna log(x), x > 0, amb error 1e-15.
     * @param x. El valor del qual es vol calcular el log.
     */
    public static double log(double x) {    
        return log(x, 1e-15);
    }
                        
}