 


/**
 * class Figure.
 * 
 * @author LTP 
 * @version 2017-18
 */

public abstract class Figure implements Comparable {
    protected double x;
    protected double y;
    
    public Figure(double x, double y) {
        this.x = x; 
        this.y = y; 
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Figure)) { return false; }
        Figure f = (Figure) o;
        return x == f.x && y == f.y;
    }
    
    public String toString() {
        return "Position: (" + x + ", " + y + ")"; 
    }
    
    public abstract double area();
    
    public abstract double perimeter();
    
    public int compareTo(Object o) {
        Figure x = (Figure) o;
        int res;
        if (this.area() > x.area()) { 
            res = (int) (this.area() - x.area());
        }
        else if (this.area() < x.area()) {
            res = (int) (x.area() - this.area());
        } else { res = 0; }
        return res;
    }
}