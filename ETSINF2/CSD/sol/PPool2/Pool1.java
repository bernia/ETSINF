// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool {   //no kids alone
    public int kids = 0;
    public int inst = 0;
    public void init(int ki, int cap)           {}
    public synchronized void kidSwims() throws InterruptedException     {
        while(inst == 0) {
        log.waitingToSwim();
        wait();
        }
        log.swimming();
        notifyAll();
        kids++;
    }
    public synchronized void kidRests() throws InterruptedException     {log.resting(); notifyAll(); kids--;}
    public synchronized void instructorSwims() throws InterruptedException  {log.swimming(); notifyAll(); inst++;}
    public synchronized void instructorRests() throws InterruptedException  {
        while(kids > 0 && inst == 1) {
        log.waitingToRest();
        notifyAll();
        wait();
        }
        log.resting();
        inst--;
    }
}
