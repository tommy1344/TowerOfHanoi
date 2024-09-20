package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Tommy Dalessio (tommy1344)
// -------------------------------------------------------------------------
/**
 *  An enum representing the three tower positions and the default position
 * 
 *  @author tommy1344
 *  @version Mar 19, 2024
 */
public enum Position
{
    /**
     * Represents the leftmost tower
     */
    LEFT, 
    
    /**
     * Represents the middle tower
     */
    MIDDLE, 
    
    /**
     * Represents the rightmost tower
     */
    RIGHT, 
    
    /**
     * Represents the default tower
     */
    DEFAULT;
    
    /**
     * Creates a new Position object.
     */
    private Position()
    {
        
    }
}
