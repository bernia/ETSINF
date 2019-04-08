import java.util.*;
/**
 * class FiguresGroupUse.
 * 
 * @author LTP 
 * @version 2017-18
 */
public class FiguresGroupUse {
    public static void main(String[] a) { 
    	List l = new LinkedList(); // O new ArrayList();
    Random r = new Random();
    for (int i = 0; i < 100; i++) {
        if (r.nextInt(2) == 0) {
            double b = r.nextDouble() * 10;
            double h = r.nextDouble() * 10;
            l.add(new Rectangle(1, 1, b, h));
        }
        else {
            double b = r.nextDouble() * 10;
            l.add(new Square(1, 1, b)); 
        } 
    }
    for (int i = 0; i < 100; i++) {
        Rectangle fi = (Rectangle) l.get(i);
        for (int j = i + 1; j < 100; j++) {
            Rectangle fj = (Rectangle) l.get(j);
            if (fi.compareToRange(fj) == 0) {
                System.out.print("Figuras iguales: "
                    + fi.getClass().getName() + " " + i
                    + " y " + fj.getClass().getName() + " " + j
                    + "\n Areas: " + fi.area()
                    + ", " + fj.area() + "\n");
            }
        }
    }

   }
}