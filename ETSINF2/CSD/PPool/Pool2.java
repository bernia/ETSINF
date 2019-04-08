// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool{ //max kids/instructor
    private int instructors = 0, kids = 0;
    private int ki;
    public void init(int ki, int cap) {
        this.ki = this.ki;
    }
    
    public synchronized void kidSwims() throws InterruptedException{
        while (kids >= ki*instructors ) {
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
    
    public synchronized void instructorSwims() {
        log.swimming();
        instructors++;
        notifyAll();
    }
    
    public synchronized void instructorRests() throws InterruptedException{
        while (kids > ((instructors-1)*ki) ) {
            log.waitingToRest();
            wait();
        }
        log.resting();
        instructors--;
        notifyAll();
    }
}
