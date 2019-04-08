// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool{ //max capacity
    public int kids = 0;
    public int inst = 0;
    public int capacity = 0;
    public void init(int ki, int cap)           {}

    public synchronized void kidSwims() throws InterruptedException     {
        while(((inst*2) <= kids) || (capacity+1 > 5)) {
            log.waitingToSwim();
            wait();}
        log.swimming();
        notifyAll();
        kids++;
        capacity++;
    }

    public synchronized void kidRests() throws InterruptedException     {log.resting(); notifyAll(); kids--; 
        capacity--;}

    public synchronized void instructorSwims() throws InterruptedException  {
        while(capacity+1 > 5) {
            log.waitingToSwim();
            wait();
        }
        log.swimming(); notifyAll(); inst++; 
        capacity++;}

    public synchronized void instructorRests() throws InterruptedException  {
        while((kids > 0 && inst == 1) || (((inst-1)*2) < kids)) {
            log.waitingToRest();
            notifyAll();
            wait();
        }
        log.resting();
        inst--;
        capacity--;
    }
}
