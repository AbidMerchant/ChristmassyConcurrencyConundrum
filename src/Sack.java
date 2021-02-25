/**
 *
 * @author Abid & TDG
 */
public class Sack
{
    int id;
    int current_index = 0;
    Present[] accumulation;
    
    public Sack(int id, int capacity)
    {
        accumulation = new Present[capacity];
        this.id = id;
    }

    //TODO - Add more methods
    public boolean isSpaceAvailable() {
    	return current_index<accumulation.length;
    }
    
    public synchronized boolean addPresent(Present present) {
    	if(!isSpaceAvailable()) {
    		System.out.println("Turntable went to wait state forever");
    		try { wait(); } catch (Exception e) {} // Turn table goes to wait state forever
    		return false;
    	}
    	else {
    		accumulation[current_index++] = present;
    		return true;
    	}
    }
}
