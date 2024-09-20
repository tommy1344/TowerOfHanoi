package towerofhanoi;

import java.util.Observable;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Tommy Dalessio (tommy1344)
// -------------------------------------------------------------------------
/**
 *  the class which solves the Hanoi puzzle
 * 
 *  @author tommy1344
 *  @version Mar 19, 2024
 */
public class HanoiSolver extends Observable
{
    //~ Fields ................................................................
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    
    //~ Constructors ..........................................................
    /**
     * Create a new HanoiSolver object.
     * @param numDisks - value to be assigned to numDisks
     */
    public HanoiSolver(int numDisks)
    {
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        this.numDisks = numDisks;
    }

    //~Public  Methods ........................................................
    
    /**
     * Returns the number of disks
     * @return number of disks
     */
    public int disks()
    {
        return numDisks;
    }
    
    // ----------------------------------------------------------
    /**
     * returns the tower at an inputed position
     * @param pos - the inputed position
     * @return the tower at the desired position
     */
    public Tower getTower(Position pos)
    {
        switch(pos)
        {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            default:
                return middle;
        }
    }
    
    /**
     * creates a string out of the 3 towers going from left to middle to right
     * @return the string of the 3 towers
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(left.toString());
        s.append(middle.toString());
        s.append(right.toString());
        return s.toString();
    }
    
    /**
     * moves the top disk of source tower to the top of destination tower
     * @param source - source tower which disk is taken from
     * @param destination - destination tower which disk is given to
     */
    private void move(Tower source, Tower destination)
    {
        Disk moveDisk = source.pop();
        destination.push(moveDisk);
        setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * solves the towers, moving the disks from the start tower to the end tower
     * @param currentDisks - amount of disks on the starting tower
     * @param startPole - starting pole
     * @param tempPole - pole used for moving the disks
     * @param endPole - ending pole
     */
    private void solveTowers(int currentDisks, Tower startPole, Tower tempPole,
        Tower endPole) 
    {
        if (currentDisks == 1)
        {
            move(startPole, endPole);
            return;
        } 
        solveTowers(currentDisks - 1, startPole, endPole, tempPole);
        move(startPole, endPole);
        solveTowers(currentDisks - 1, tempPole, startPole, endPole);

        
    }
    
    /**
     * calls the solveTowers method with input parameters
     */
    public void solve()
    {
        solveTowers(left.size(), left, middle, right);
    }
    

}
