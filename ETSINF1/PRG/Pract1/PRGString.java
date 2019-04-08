/**
 * Classe PRGString practica 1
 *
 * @author Javi
 * @version 14 feb 2017
 */

public class PRGString {
    private static final String AMB = "ÁÉÍÓÚÀÈÒÏÜ";
    private static final String SENSE = "AEIOUAEOIU";
    public static boolean esPrefixe(String a, String b) {
        if (a.length() < 1) { return true; }
        else {
            if (a.length() > b.length()) { return false; }
            if (a.charAt(0) != b.charAt(0)) {
                return false;
            } else { return esPrefixe(a.substring(1), b.substring(1)); }
        }
    }
    
    public static boolean esSubcadena(String a, String b) {
        if (a.length() < 1) { return true; }
        else {
            if (a.length() > b.length()) { return false; }
            
            if (esPrefixe(a, b)) { return true; }
            else { return esSubcadena(a, b.substring(1)); }
        }
    }
    
    public static boolean esPalindromSA(String a) {
        if (a.length() <= 1) { return true; }
        else {
            if (!Character.isLetter(a.charAt(0))) { 
                return esPalindromSA(a.substring(1));
            }
            
            if (!Character.isLetter(a.charAt(a.length() - 1))) { 
                return esPalindromSA(a.substring(0, a.length() - 1));
            }
            
            if (a.toUpperCase().charAt(0) 
                != a.toUpperCase().charAt(a.length() - 1)) {
                return false;
            } else { return esPalindromSA(a.substring(1, a.length() - 1)); }
        }
    }
    
    public static char accent(char a) {
        int pos = AMB.indexOf(a);
        if (pos != -1) {
            return SENSE.charAt(pos);
        } else { return a; }
    }
    
    public static boolean esPalindrom(String a) {
        if (a.length() <= 1) { return true; }
        else {
            if (!Character.isLetter(a.charAt(0))) { 
                return esPalindrom(a.substring(1));
            }
            
            if (!Character.isLetter(a.charAt(a.length() - 1))) { 
                return esPalindrom(a.substring(0, a.length() - 1));
            }
            
            if (accent(a.toUpperCase().charAt(0)) 
                != accent(a.toUpperCase().charAt(a.length() - 1))) {
                return false;
            } else { return esPalindrom(a.substring(1, a.length() - 1)); }
        }
    }
}
