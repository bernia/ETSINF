// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool{ //max kids/instructor
    public int kids = 0;
    public int inst = 0;
    public void init(int ki, int cap)           {}
    public synchronized void kidSwims() throws InterruptedException     {
        while(inst == 0) {
            log.waitingToSwim();
            wait();
        }
        while((inst*2) <= kids) {
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
        while(((inst-1)*2) < kids) {
                log.waitingToRest();
                notifyAll();
                wait();}
        log.resting();
        inst--;
    }
}
