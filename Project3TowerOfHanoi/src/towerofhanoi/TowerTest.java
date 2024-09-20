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
 *  Test the tower method
 * 
 *  @author tommy1344
 *  @version Mar 19, 2024
 */
public class TowerTest extends TestCase
{
    //~ Fields ................................................................
    private Tower testTower1;
    private Tower testTower2;
    private Disk testDisk1;
    private Disk testDisk2;
    private Disk testDisk4;

    //~ Constructors ..........................................................
    
    /**
     * setUp() method 
    */
    public void setUp()
    {
        Position leftPos = Position.LEFT;
        testTower1 = new Tower(leftPos);
        testTower2 = new Tower(leftPos);
        testDisk1 = new Disk(5);
        testDisk2 = new Disk(1);
        testDisk4 = null;
    }

    
    //~Public  Methods ........................................................
    /**
     * test the Position method
     */
    public void testPosition()
    {
        assertEquals(testTower1.position(), Position.LEFT);
        assertNotSame(testTower2.position(), Position.RIGHT);
    }
    
    /**
     * test the Push method
     */
    public void testPush()
    {
        testTower1.push(testDisk2);
        // testing the correct exception is thrown when a null disk is passed
        try 
        {
            testTower1.push(testDisk4);
        } 
        catch (Exception e) 
        {
            assertTrue("", e instanceof IllegalArgumentException);
            
        }
        // testing the correct exception is thrown when a larger disk is passed
        try 
        {
            testTower1.push(testDisk1);
        } 
        catch (Exception e) 
        {
            assertTrue("", e instanceof IllegalStateException);
        }
    }

}
