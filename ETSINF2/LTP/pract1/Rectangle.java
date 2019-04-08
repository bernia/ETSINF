

/**
 * class Rectangle.
 *
 * @author LTP
 * @version 2017-2018
 */
public class Rectangle extends Figure implements ComparableRange {
    private double base; 
    private double height;

    public Rectangle(double x, double y, double b, double h) {
        super(x, y);
        base = b;
        height = h;
    }

    public String toString() {
        return "Rectangle:\n\t" +
            super.toString() +
            "\n\tBase: " + base +
            "\n\tHeight: " + height;
    }
    
    public boolean equals(Object o){
        if(!(o instanceof Rectangle)){ return false;}
        Rectangle r = (Rectangle) o;
        return super.equals(r) && this.base == r.base
        && this.height == r.height;
    }
    
    public double area() {
        return base * height;
    }
    public double perimeter() {
        return 2 * (base + height);
    }
    
    public int compareToRange(Object o) {
        Rectangle r = (Rectangle) o;
        if( Math.abs(this.area() - r.area()) <= (this.area() + r.area())/10) {
            return 0;
        } else { return this.compareTo(o); }
    }
    
    public void print(char c) {
        int b = (int) base;
        int h = (int) height;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(c);
            }
            System.out.println();
        } 
    }
}
