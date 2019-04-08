// CSD Mar 2013 Juansa Sendra

public class LimitedTable extends RegularTable { //max 4 in dinning-room
    private int fils;
    public static final int MAX_CAP = 4;
    public LimitedTable(StateManager state) {super(state); fils = 0;}
    
    public synchronized void enter(int id) throws InterruptedException {
        while (fils > 3) {
            state.wenter(id);
            wait();
        }
        fils++;
        state.enter(id);
    }
    
    public synchronized void exit(int id) {
        fils--;
        state.exit(id);
        if (fils == (MAX_CAP - 1)) { notifyAll(); }
    }
}
