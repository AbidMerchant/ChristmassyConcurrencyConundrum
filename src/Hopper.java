/**
 *
 * @author TDG & Abid
 */
public class Hopper extends Thread
{
    int id;
    Conveyor belt;
    int speed;
	double wait_time = 0.0;
	
	int current_index,start_index;
    Present[] collection;
    
    public Hopper(int id, Conveyor con, int capacity, int speed)
    {
        collection = new Present[capacity];
        this.id = id;
        belt = con;
        this.speed = speed;
        
        //TODO
        current_index = 0;
        start_index = 0;
    }
    
	// To fill the hopper
    public void fill(Present p)
    {	
        collection[current_index++] = p;
    }

    public void run()
    {
        // Start filling the conveyer belt
		while(start_index < current_index) {
			long startTime = System.currentTimeMillis();
			
			addPresentToBelt();
			try {Thread.sleep(speed * 1000);} catch (Exception e) { } // Hoppers preset speed of working
			
			long endTime = System.currentTimeMillis();
			
			wait_time += endTime-startTime;
		} 
    }
    
    // TODO Add more methods?
	
	// Method to fill the conveyor belt
    public void addPresentToBelt() {
    	belt.addPresent(collection[start_index++]);
    }
}
