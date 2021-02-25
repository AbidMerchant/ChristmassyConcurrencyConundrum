import java.util.HashSet;
/**
 *
 * @author Abid & TDG
 */
 
public class Conveyor
{
    int id;
    private Present[] presents; // The requirements say this must be a fixed size array
    
    public Present[] getPresents() {
		return presents;
	}

	public void setPresents(Present[] presents) {
		this.presents = presents;
	}

	public  HashSet<Integer> destinations = new HashSet();  
    
    // TODO - add more members?
    int start;
    int end;
     
    public Conveyor(int id, int size)
    {
        this.id = id;
        presents = new Present[size];
        
        //TODO - more construction likely!
        start = -1;
        end = -1;
    }
	
	// Should be Sack ID
    public void addDestination(int hopperID)
    {
        destinations.add(hopperID);
    }

    // TODO - add more functions
  
	// To check if space is available on belt
    public boolean isSpaceAvailable() {
    	if((end - start) < presents.length) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    // To check if present is available on belt (Turntable will use it)
    public boolean isPresentAvailable() {    	
    	if(start!=-1 && start < end) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    // Hopper/Turntable adds a present to Conveyer belt
    public synchronized void addPresent(Present present) {
    	
    	if(!isSpaceAvailable()) {
    		// Hopper is in wait state as not space is available on belt
    		try { wait(); } catch (Exception e) {} 
    	}
    	
    	// Empty  
    	if(start == -1) {
    		start = 0;
    		end = 0;
    	}
    	presents[end%presents.length] = present;
    	end++;
    }
	
    // Turn table receives a present from belt
	public synchronized Present deliverPresentToTurnTable() {
		Present present = null;

		present= presents[start%presents.length];
		start++;
		
		notifyAll(); // to notify hopper that space is available on belt now
		
		return present;
	}
}