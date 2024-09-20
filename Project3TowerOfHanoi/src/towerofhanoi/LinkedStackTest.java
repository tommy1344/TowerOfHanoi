package towerofhanoi;
import java.util.EmptyStackException;
import student.TestCase;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Tommy Dalessio (tommy1344)
// -------------------------------------------------------------------------
/**
 *  Tests the methods of the LinkedStack class
 * 
 *  @author tommy1344
 *  @version Mar 18, 2024
 */
public class LinkedStackTest extends TestCase
{
    //~ Fields ................................................................ 
    private LinkedStack<String> testStack1;
    private LinkedStack<String> testStack2;
    private LinkedStack<String> testStack3;

    //~ Constructors ..........................................................
    
    /**
     * setUp() method 
    */
    public void setUp()
    {
        testStack1 = new LinkedStack<String>();
        testStack1.push("Test1");
        testStack2 = new LinkedStack<String>();
        testStack3 = new LinkedStack<String>();
        testStack3.push("Test1");
        testStack3.push("Test2");
    }
    
    //~Public  Methods ........................................................
    
    /**
     * test the size method
     */
    public void testSize()
    {
        assertEquals(testStack1.size(), 1);
        assertEquals(testStack2.size(), 0);
    }
    
    /**
     * test the isEmpty method
     */
    public void testIsEmpty()
    {
        assertFalse(testStack1.isEmpty());
        assertTrue(testStack2.isEmpty());
    }
    
    /**
     * test the clear method
     */
    public void testClear()
    {
        testStack3.clear();
        assertTrue(testStack3.isEmpty());
        assertEquals(testStack3.size(), 0);
    }
    
    /**
     * test the toString method
     */
    public void testToString()
    {
        assertEquals(testStack2.toString(), "[]");
        assertEquals(testStack3.toString(), "[Test2, Test1]");
    }
    
    /**
     * test the push method
     */
    public void testPush()
    {
        testStack1.push("Test2");
        assertEquals(testStack1.peek(), "Test2");
        assertEquals(testStack1.size(), 2);
    }
    
    /**
     * test the peek method
     */
    public void testPeek()
    {
        assertEquals(testStack1.peek(), "Test1");
        
        // testing the correct exception is thrown when stack is empty
        try 
        {
            testStack2.peek();
        } 
        catch (Exception e) 
        {
            assertTrue("", e instanceof EmptyStackException);
        }
        
    }
    
    /**
     * test the pop method
     */
    public void testPop()
    {
        assertEquals(testStack1.pop(), "Test1");
        // testing the correct exception is thrown when stack is empty
        try {
            testStack2.pop();
        } 
        catch (Exception e) 
        {
            assertTrue("", e instanceof EmptyStackException);
        }
    }

}
