import java.util.*;
/**
 * class FiguresGroup.
 * 
 * @author LTP 
 * @version 2017-18
 */

public class FiguresGroup implements Printable {
    private static final int NUM_FIGURES = 10;
    private Figure[] figuresList = new Figure[NUM_FIGURES];
    private int numF = 0;
    
    public void add(Figure f) { figuresList[numF++] = f; }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < numF; i++) {
            s += "\n" + figuresList[i];
        }
        return s;
    }

    private boolean found(Figure f) {
        for (int i = 0; i < numF; i++) {
        	if (figuresList[i].equals(f)) return true;
        }
        return false;
    }

    private boolean included(FiguresGroup g) {
		for (int i = 0; i < g.numF; i++) {
        	if (!found(g.figuresList[i])) return false;
        }
		return true;
    }
    
    public boolean equals(Object o){
        if(!(o instanceof FiguresGroup)) {return false;}
        FiguresGroup f = (FiguresGroup) o;
        return this.included(f) && f.included(this);
    }
    
    public double area() {
        double res = 0;
        for (int i = 0; i < numF; i++) {
            res += figuresList[i].area();
        }
        return res;
    }
    
    public double greatestFigure() {
        double major = 0;
        for (int i = 0; i < numF; i++) {
            if(figuresList[i].area() >= major){
                major = figuresList[i].area();
            }
        }
        return major;
    }
    
    public List orderedList() {
        List l = new LinkedList();
        if (numF > 0) { l.add(figuresList[0]); }
        for (int i = 1; i < numF; i++) {
            int j = l.size() - 1;
            while(j >= 0 && figuresList[i].compareTo(l.get(j)) < 0) {
                l.add(j,figuresList[i]);
                j--;
            }
            l.add(j + 1, figuresList[i]);
        }
        return l;
    }
    
    public void print (char c) {
        for (int i = 0; i < numF; i++) {
            if (figuresList[i] instanceof Circle) {
                Circle s = (Circle) figuresList[i];
                s.print(c);
            } else if (figuresList[i] instanceof Rectangle) {
                Rectangle r = (Rectangle) figuresList[i];
                r.print(c);
            }
        }
    }
}