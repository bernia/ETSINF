import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.PrintWriter;
import java.io.*;
import java.io.Serializable;
/**
 * Classe Banc per a representar un conjunt de comptes.
 * @author PRG 
 * @version Curs 2016/17
 */
public class Banc implements Serializable {    
    public final static int MAX_COMPTES = 100;
    /** Array d'objectes Compte. */
    private Compte[] comptes;
    /** Número actual de comptes i primer índex  
     *  disponible a l'array comptes. */
    private int numComptes;
    /** Número màxim de comptes. */

    /**
     * Crea un banc sense comptes (pot tenir un màxim de MAX_COMPTES comptes).
     */
    public Banc() {
        this.comptes = new Compte[MAX_COMPTES];
        this.numComptes = 0;
    }

    /**
     * Torna el número actual de comptes.
     * @return int, número actual de comptes.
     */
    public int getNumComptes() { return numComptes; }
    
    /**
     * Permet inserir el Compte c al banc. Si el banc està complet,
     * duplica el número de comptes que poden haver al banc.
     * @param c Compte a inserir.
     */
    public void inserir(Compte c) {
        if (numComptes >= comptes.length) { duplica(); }  
        comptes[numComptes++] = c;
    }
    
    /**
     * Duplica la grandària de l'array comptes.
     */
    private void duplica() {
        Compte[] aux = new Compte[2 * comptes.length];
        for (int i = 0; i < comptes.length; i++) { aux[i] = comptes[i]; }
        comptes = aux;
    }

    /**
     * Torna el compte amb número de compte n.
     * Si aquest comtpe no existeix, torna null.
     * @param n int que indica el número de compte.
     * @return Compte, el comtpe resultat.
     */
    public Compte getCompte(int n) {
        int i = 0;
        while (i < numComptes && comptes[i].getNumCompte() != n) { i++; }
        if (i < numComptes) { return comptes[i]; }
        else { return null; }
    }

    /**
     * Torna una String amb tota la informació del banc.
     * El format és un compte per línia.
     * @return String.
     */
    public String toString() {
        if (numComptes == 0) { return "No hi ha comptes al banc"; }
        else {
            String res = "";
            for (int i = 0; i < numComptes; i++) { res += comptes[i] + "\n"; }
            return res;
        }        
    }
    
    /**
     * Lectura d'un fitxer de text dels comptes d'un banc.
     * @param f Scanner per realitzar la lectura de fitxer de text.
     */
    public void carregarFormatText(Scanner f) {
        /* Primera aproximacio: usant nextInt() i nextDouble() */
        while(f.hasNext()) {
            try {
                int numCompte = f.nextInt();
                double saldoInicial = f.nextDouble();
                if ( numCompte < 10000 || numCompte > 99999
                || saldoInicial < 0) {
                    System.out.println("Línia no vàlida");
                }
                else if (getCompte(numCompte) != null) {
                    System.out.println("El compte " + numCompte + " ja existeix.");
                } else {
                    Compte c = new Compte(numCompte, saldoInicial);
                    inserir(c);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError de format en la lectura" );
            } finally {
                f.nextLine();
            }
        }
    }
    
    /**
     * 
     * 
     * 
     */
    public void guardarFormatText(PrintWriter f) { 
//         /** Primera versió; toString() de Compte */
//         for (int i = 0; i < numComptes; i++) { f.println(comptes[i]); }
        
        /** Segona versió: toString() de Banc */
        if (numComptes > 0) { f.print(this.toString()); }
        
    }
    
    public void guardarFormatObjecte(ObjectOutputStream f) throws IOException {
        f.writeObject(this);
    }
    
    public void carregarFormatObjecte(ObjectInputStream f)
        throws ClassNotFoundException, IOException {
        Banc b = (Banc) f.readObject();
        for (int i = 0; i < b.numComptes; i++) {
            int numCompte = b.comptes[i].getNumCompte();
            if(this.getCompte(numCompte) == null) {
                this.inserir(b.comptes[i]);
            } else {
                System.out.println("El compte " + numCompte + " ja existeix.");
            }
            
        }
    }
}
