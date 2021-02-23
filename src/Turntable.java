import java.util.HashMap;
import java.util.*;

/**
 *
 * @author Nick
 */
public class Turntable extends Thread
{
    String id;
    
    private Present curr_present = null;

	static int N = 0;
    static int E = 1;
    static int S = 2;
    static int W = 3;
    
    Connection[] connections = new Connection[4];
        
    // global lookup: age-range -> SackID
    static HashMap<String, Integer> destinations = new HashMap<>();
    
    // this individual table's lookup: SackID -> output port
    HashMap<Integer, Integer> outputMap = new HashMap<>();
    
    public Turntable (String ID)
    {
        id = ID;
    }
    
	// Port is the direction of connection (N-E-S-W)
    public void addConnection(int port, Connection conn)
    {
        connections[port] = conn;
        
        if(conn != null)
        {
            if(conn.connType == ConnectionType.OutputBelt)
            {
                Iterator<Integer> it = conn.belt.destinations.iterator();
                while(it.hasNext())
                {
                    outputMap.put(it.next(), port);
                } //(1,0) || (sack_id, direction)
            }
            else if(conn.connType == ConnectionType.OutputSack)
            {
                outputMap.put(conn.sack.id, port);
            }
        }
    }
    
    public void run()
    {
        // TODO
		// 1. Input Belt: If present is available | Get the present | Calculate time | Deliver the present
		while(true) {
			curr_present = null;
			int inputPort = -1;
			
			// Fetch present from any Input Conveyer belt
			while(curr_present == null) {
				for(int i=0; i<4; i++) {
					if(connections[i]!=null && connections[i].connType == ConnectionType.InputBelt) {
						Conveyor curr_belt = connections[i].belt;
						
						if(curr_belt.isPresentAvailable()) {
							inputPort = i;
							curr_present = curr_belt.deliverPresentToTurnTable();
							try {Thread.sleep(750);} catch (Exception e) { } // Time taken to receive the gift 
							break;
						}
					}
				}
			}
			
			
			// check the output port
			String ageRange = curr_present.ageRange;
			int destinationSackId = destinations.get(ageRange);
			int outputPort = outputMap.get(destinationSackId);
			
			
			// Check if the turntable will move to deliver the present (Table will not move for N-S (0-2), E-W(1-3))
			if(Math.abs(inputPort - outputPort) != 2) {
				try {Thread.sleep(500);} catch (Exception e) { } // Time taken to turn the table 90 degrees.
			}
			
			
			// deliver present to belt/sack
			
			if(connections[outputPort].connType == ConnectionType.OutputBelt) {
				Conveyor output_belt = connections[outputPort].belt;
				
				output_belt.addPresent(curr_present);
				curr_present = null;
			}
			else {
				Sack output_sack = connections[outputPort].sack;
				
				if(output_sack.addPresent(curr_present))
					curr_present = null;
			}
			
			
			try {Thread.sleep(750);} catch (Exception e) { } // Time taken to deliver the present
		}
    }
    
    public Present getCurr_present() {
		return curr_present;
	}

	public void setCurr_present(Present curr_present) {
		this.curr_present = curr_present;
	}
}
