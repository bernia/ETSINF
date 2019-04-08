package librerias.implementaciones;
 
import librerias.modelos.Queue;
import java.util.ArrayList;
 
/**
 * class QueueAL<T>
 * It is the implementation of a Queue<T>
 * using a generic ArrayList.
 *
 * @author LTP
 * @version 2017-18
 * @param <T>
 */
 
public class QueueAL<T> implements Queue<T> {
   
    ArrayList<T> theArray;
    int first;
    int last;
    int size;
   
    /** The object constructor */
    public QueueAL() {
        theArray = new ArrayList<T>();
        first = 0;
        last = -1;
        size = 0;
    }
 
    /** It returns the content of the queue
     *  according to the following format:
     *   <- item0 <- item1 <- item2 <- ... <- itemN
     *  where N = size() - 1
     *  and each item is concatenated
     *  according to the format defined in its type
     *  @return the content of the queue
     */
    public String toString() {
        String s = "";
        for ( T e : theArray ) {
            s += " <- " + e;
        }
        /** An alternative loop */
        // for (int k = 0; k < size(); k++) {
        //     s += " <- " + theArray.get(k);
        // }
        return s;
    }
 
    // Implementation of the operations defined
    // in the Queue<T> interface
 
    // Methods that change the queue' state
    /** Inserts the element at the end of the queue
     *  @param e element to be inserted
     */  
    public void enqueue(T e) {
        theArray.add(e);
        last++;
        size++;
    }
 
    /** Queries and extracts the first element,
     *  only if the queue is not empty
     *  @return the first element
     */
    public T dequeue() {
        if (size > 0) {
            T aux = theArray.get(first);
            first++;
            size--;
            return aux;
        } else { return null; }
    }
 
    // Methods that query the queue' state
    /** Queries the number of elements of the queue
     *  @return the number of elements
     */
    public int size() {
        return size;
    }
 
    /** Queries the first element, in order of insertion,
     *  only if the queue is not empty
     *  @return the first element
     */
    public T first() {
        return theArray.get(first);
    }
 
    /** Verifies if the queue is empty
     *  @return true iif the queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
}