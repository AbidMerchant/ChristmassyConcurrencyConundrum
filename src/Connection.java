/**
 *
 * @author TDG and Abid
 */
public class Connection {
    ConnectionType connType;
    Conveyor belt;
    Sack sack;
    
    public Connection(ConnectionType ct, Conveyor c, Sack s)
    {
        connType = ct;
        belt = c;
        sack = s;
    }
}
