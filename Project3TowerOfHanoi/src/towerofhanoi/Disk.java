package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Tommy Dalessio (tommy1344)

// -------------------------------------------------------------------------
/**
 *  Used to represent disk objects and complete basic operations such as 
 *  equals, toString, and compareTo
 * 
 *  @author tommy1344
 *  @version Mar 18, 2024
 */
public class Disk extends Shape implements Comparable<Disk>
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Disk object.
     * @param width - the width of the disk
     */
    public Disk(int width)
    {
        super(0, 0, width, 20);
        TestableRandom randomGenerator = new TestableRandom();
        
        // red green blue values for the background color
        int r = randomGenerator.nextInt(255);
        int g = randomGenerator.nextInt(255);
        int b = randomGenerator.nextInt(255);
        
        Color diskBackColor = new Color(r, g, b);
        setBackgroundColor(diskBackColor);
    }

    //~Public  Methods ........................................................
    /**
     * Compares 2 disk to determine the bigger one
     * @return int - 1 if the input disk is smaller, 0 if they are the same size
     * and -1 if the input disk is bigger
     * @param otherDisk - the disk being input and compared to
     */
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            // if otherDisk is null, an exception will be thrown
            throw new IllegalArgumentException("otherDisk is null");
        }
        if (this.getWidth() < otherDisk.getWidth())
        {
            return -1;
        } 
        else if (this.getWidth() > otherDisk.getWidth())
        {
            return 1;
        } 
        else 
        {
            return 0;
        }
    }
    
    /**
     * Turns the disk width into a string
     * @return string of disk width
     */
    public String toString()
    {
        return "" + getWidth();
    }
    
    /**
     * Asserts if the input object is equal to the checked object
     * @param obj - object being input and checked
     * @return true if equal, false if not
     */
    public boolean equals(Object obj)
    {
        if ( obj == null )
        {
            return false;
        }
        if ( this.getClass() == obj.getClass() )
        {
            Disk other = (Disk)obj;
            return other.getWidth() == this.getWidth();
        }
        
        return false;
    }

}
