// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool{ //max capacity
    private int instructors = 0, kids = 0;
    private int ki,cap;
    public void init(int ki, int cap) {
        this.ki = ki;
        this.cap = cap;
    }
    
    public synchronized void kidSwims() throws InterruptedException{
        while (kids >= ki*instructors || kids+instructors >= cap) {
            log.waitingToSwim();
            wait();
        }
        log.swimming();
        kids++;
    }
    
    public synchronized void kidRests() {
        log.resting();
        kids--;
        notifyAll();
    }
    
    public synchronized void instructorSwims() throws InterruptedException {
        while (kids+instructors >= cap) {
            log.waitingToSwim();
            wait();
        }
        log.swimming();
        instructors++;
        notifyAll();
    }
    
    public synchronized void instructorRests() throws InterruptedException{
        while ( kids > ((instructors-1)*ki) ) {
            log.waitingToRest();
            wait();
        }
        log.resting();
        instructors--;
        notifyAll();
    }
}
