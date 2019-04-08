// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool {   //no kids alone
    private int instructors = 0, kids = 0;
    public void init(int ki, int cap) {}
    
    public synchronized void kidSwims() throws InterruptedException{
        while (instructors < 1) {
            log.waitingToSwim();
            wait();
        }
        kids++;
        log.swimming();
    }
    
    public synchronized void kidRests() {
        kids--;
        log.resting();
    }
    
    public synchronized void instructorSwims() {
        instructors++;
        notifyAll();
        log.swimming();
    }
    
    public synchronized void instructorRests() throws InterruptedException{
        while (instructors <= 1 && kids > 0) {
            log.waitingToRest();
            wait();
        }
        instructors--;
        notifyAll();
        log.resting(); 
    }
    
}
