package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Tommy Dalessio (tommy1344)
// -------------------------------------------------------------------------
/**
 *  The code representing the towers. Only allows disk to be stacked onto a
 *  disk of larger size
 * 
 *  @author tommy1344
 *  @version Mar 19, 2024
 */
public class Tower extends LinkedStack<Disk>
{
    //~ Fields ................................................................
    private Position position;

    //~ Constructors ..........................................................
    /**
     * Create a new Tower object.
     * @param pos - position to be assigned to the tower
     */
    public Tower(Position pos)
    {
        super();
        position = pos;
    }
    //~Public  Methods ........................................................
    /**
     * returns the position of the tower
     * @return position
     */
    public Position position()
    {
        return position;
    }
    
    /**
     * adds a disk to a tower
     * @Override
     * @param disk - disk being pushed onto the tower
     */
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException();
        }
        
        // adds a disk to the tower if the tower is empty or if the disk below
        // is bigger than the disk being added
        if (size() == 0)
        {
            super.push(disk);
            return;
        } 
        else if (peek().compareTo(disk) > 0)
        {
            super.push(disk);
            return;
        } 
        else 
        {
            // not a valid push so exception is thrown
            throw new IllegalStateException();
        }
    }
}
