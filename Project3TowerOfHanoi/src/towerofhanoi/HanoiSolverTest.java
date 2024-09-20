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
 *  Test the methods of the HanoiSolver class
 * 
 *  @author tommy1344
 *  @version Mar 19, 2024
 */
public class HanoiSolverTest extends TestCase
{
    //~ Fields ................................................................
    private HanoiSolver testSolve;
    
    //~ Constructors ..........................................................
    
    /**
     * setUp() method 
    */
    public void setUp()
    {
        Disk testDisk1 = new Disk(10);
        Disk testDisk2 = new Disk(8);
        Disk testDisk3 = new Disk(6);
        testSolve = new HanoiSolver(3);
        testSolve.getTower(Position.LEFT).push(testDisk1);
        testSolve.getTower(Position.LEFT).push(testDisk2);
        testSolve.getTower(Position.LEFT).push(testDisk3);
    }

    //~Public  Methods ........................................................
    /**
     * test the disks method
    */
    public void testDisks()
    {
        assertEquals(testSolve.disks(), 3);
    }
    
    /**
     * test the getTower method
    */
    public void testGetTower()
    {
        assertEquals(testSolve.getTower(Position.DEFAULT), 
            testSolve.getTower(Position.MIDDLE));
        assertEquals(testSolve.getTower(Position.RIGHT), 
            testSolve.getTower(Position.RIGHT));
    }
    
    /**
     * test the toString method
    */
    public void testToString()
    {
        assertEquals(testSolve.toString(), "[6, 8, 10][][]");
    }

    /**
     * test the solve method
    */
    public void testSolve()
    {
        testSolve.solve();
        assertEquals("[][][6, 8, 10]", testSolve.toString());
    }
}
