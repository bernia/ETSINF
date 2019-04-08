/**
 * Classe ConjuntString. Implementacio d'un
 * conjunt de String mitjancant una sequencia
 * enllasada ordenada lexicograficament.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Curs 2016/17)
 */
public class ConjuntString {
    
    private NodeString primer;
    private int talla;
    
    /**
     * Crea un conjunt buit.
     */
    public ConjuntString() {
        primer = null;
        talla = 0;
    }

    /**
     * Insereix s en el conjunt.
     * Si s ja pertany al conjunt, aquest no canvia.
     *
     * @param s String. Element que s'insereix en el conjunt.
     */
    public void inserir(String s) {
        NodeString aux = this.primer;
        NodeString ant = null;
        int compara = -1;
        while (aux != null && compara < 0) {
            compara = aux.dada.compareTo(s);
            if (compara < 0) { 
                ant = aux;
                aux = aux.seguent;
            }
        }
        
        if (compara != 0) {
            talla++;
            if (ant != null) {
                ant.seguent = new NodeString(s, aux);
            } else {
                primer = new NodeString (s, aux);
            }
        }
    }
    
    /**
     * Comprova si s pertany al conjunt.
     *
     * @param s String.
     * @return true sii s pertany al conjunt.
     */
    public boolean pertany(String s) {
        NodeString aux = this.primer;
        NodeString ant = null;
        int compara = -1;
        while (aux != null && compara < 0) {
            compara = aux.dada.compareTo(s);
            if (compara < 0) { 
                ant = aux;
                aux = aux.seguent;
            }
        }
        if (compara == 0) { return true; }
        else { return false; }
    }

    
    /**
     * Elimina s del conjunt.
     * Si s no pertany al conjunt, el conjunt no canvia.
     *
     * @param s String.
     */
    public void eliminar(String s) {
        NodeString aux = this.primer;
        NodeString ant = null;
        int compara = -1;
        while (aux != null && compara < 0) {
            compara = aux.dada.compareTo(s);
            if (compara < 0) { 
                ant = aux;
                aux = aux.seguent;
            }
        }
        
        if (compara == 0) {
            if (ant == null) { //Hi ha un element com a molt
                primer = aux.seguent;
            } else {
                ant.seguent = aux.seguent;
            }
            talla--;
        }
    }
    
    /**
     * Retorna la talla o cardinal del conjunt.
     * @return la talla del conjunt.
     */
    public int talla() {      
        return talla; 
    }
    
    
    /**
     * Retorna el conjunt interseccio del conjunt i d'altre.
     *
     * @param altre ConjuntString.
     * @return el conjunt interseccio.
     */
    public ConjuntString interseccio(ConjuntString altre) {
        ConjuntString res = new ConjuntString();
        NodeString aux1 = this.primer;
        NodeString aux2 = altre.primer;
        NodeString ultResult = null;
        while (aux1 != null && aux2 != null) {
            int compara = aux1.dada.compareTo(aux2.dada);
            if (compara == 0) {
                if (ultResult == null) {
                        res.primer = new NodeString (aux1.dada);
                        ultResult = res.primer;
                } else {
                    ultResult.seguent = new NodeString (aux1.dada);
                    ultResult = ultResult.seguent;
                }
                res.talla++;
                aux2 = aux2.seguent;
                aux1 = aux1.seguent;
            } else if (compara > 0) {
                    aux2 = aux2.seguent;
            } else {
                aux1 = aux1.seguent;
            }
        }
        return res;
    }
    /**
     * Retorna el conjunt unio del conjunt i d'altre.
     *
     * @param altre ConjuntString.
     * @return el conjunt unio.
     */
    public ConjuntString unio(ConjuntString altre) {
        ConjuntString res = new ConjuntString();
        NodeString aux1 = this.primer;
        NodeString aux2 = altre.primer;
        NodeString ultResult = null;
        while (aux1 != null && aux2 != null) {
            int compara = aux1.dada.compareTo(aux2.dada);
            if (compara == 0) {
                if (ultResult == null) {
                        res.primer = new NodeString (aux1.dada);
                        ultResult = res.primer;
                } else {
                    ultResult.seguent = new NodeString (aux1.dada);
                    ultResult = ultResult.seguent;
                }
                res.talla++;
                aux2 = aux2.seguent;
                aux1 = aux1.seguent;
            } else if (compara > 0) {
                if (ultResult == null) {
                        res.primer = new NodeString (aux2.dada);
                        ultResult = res.primer;
                } else {
                    ultResult.seguent = new NodeString (aux2.dada);
                    ultResult = ultResult.seguent;
                }
                res.talla++;
                aux2 = aux2.seguent;
            } else {
                if (ultResult == null) {
                        res.primer = new NodeString (aux1.dada);
                        ultResult = res.primer;
                } else {
                    ultResult.seguent = new NodeString (aux1.dada);
                    ultResult = ultResult.seguent;
                }
                res.talla++;
                aux1 = aux1.seguent;
            }
        }
        
    
        while (aux1 != null) {
            if (ultResult == null) {
                    res.primer = new NodeString (aux1.dada);
                    ultResult = res.primer;
            } else {
                ultResult.seguent = new NodeString (aux1.dada);
                ultResult = ultResult.seguent;
            }
            res.talla++;
            aux1 = aux1.seguent;
        }
 
        while (aux2 != null) {
            if (ultResult == null) {
                    res.primer = new NodeString (aux2.dada);
                    ultResult = res.primer;
            } else {
                ultResult.seguent = new NodeString (aux2.dada);
                ultResult = ultResult.seguent;
            }
            res.talla++;
            aux2 = aux2.seguent;
        }
    
    
        return res;
    }
    
        
    /**
     * Retorna el llistat de les Strings en el conjunt, en ordre
     * lexicografic, i separats per canvis de linia.
     * Si el conjunt es buit retorna "", la String buida.
     *
     * @return llistat dels elements del conjunt.
     */
    public String toString() {
        String result = "";
        NodeString aux = this.primer;
        while (aux != null) {
            result += aux.dada + "\n"; 
            aux = aux.seguent; 
        }
        return result;
    }
    
}
