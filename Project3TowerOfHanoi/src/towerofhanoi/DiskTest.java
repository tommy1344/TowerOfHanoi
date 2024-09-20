package towerofhanoi;

import student.TestCase;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Tommy Dalessio (tommy1344)

// -------------------------------------------------------------------------
/**
 *  Tests the methods of the Disk class
 * 
 *  @author tommy1344
 *  @version Mar 18, 2024
 */
public class DiskTest extends TestCase
{
    //~ Fields ................................................................
    private Disk testDisk1;
    private Disk testDisk2;
    private Disk testDisk3;
    private Disk testDisk4;
    private Disk testDisk5;
    private String testString;

    //~ Constructors ..........................................................
    
    /**
     * setUp() method 
    */
    public void setUp()
    {
        testDisk1 = new Disk(5);
        testDisk2 = new Disk(0);
        testDisk3 = new Disk(10);
        testDisk4 = new Disk(5);
        testDisk5 = null;
        testString = "Testing purposes";
    }

    
    //~Public  Methods ........................................................
    
    /**
     * test the compareTo method
     */
    public void testCompareTo()
    {
        assertTrue(testDisk1.compareTo(testDisk2) > 0);
        assertTrue(testDisk1.compareTo(testDisk3) < 0);
        assertEquals(testDisk1.compareTo(testDisk4), 0);
        assertEquals(testDisk1.compareTo(testDisk1), 0);
        
        // testing the correct exception is thrown if compared to a null disk
        try 
        {
            testDisk1.compareTo(testDisk5);
        } 
        catch (Exception e) 
        {
            assertTrue("", e instanceof IllegalArgumentException);
        }
    }
    /**
     * test the toString method
     */
    public void testToString() 
    {
        assertEquals(testDisk1.toString(), "5");
    }
    /**
     * test the equals method
     */
    public void testEquals()
    {
        assertTrue(testDisk1.equals(testDisk1));
        assertTrue(testDisk1.equals(testDisk4));
        assertFalse(testDisk1.equals(testDisk2));
        assertFalse(testDisk1.equals(testString));
        assertFalse(testDisk1.equals(testDisk5));
    }

}
