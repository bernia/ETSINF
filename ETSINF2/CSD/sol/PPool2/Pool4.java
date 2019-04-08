// CSD feb 2013 Juansa Sendra

public class Pool4 extends Pool { //kids cannot enter if there are instructors waiting to exit
    public int kids = 0;
    public int inst = 0;
    public int capacity = 0;
    public int instWtoRest = 0;
    public void init(int ki, int cap)           {}

    public synchronized void kidSwims() throws InterruptedException     {
        while(((inst*2) <= kids) || (capacity+1 > 5) || (instWtoRest >=1)) {
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
            instWtoRest++;
            notifyAll();
            wait();
            instWtoRest--;
        }
        log.resting();
        inst--;
        capacity--;
    }
}
