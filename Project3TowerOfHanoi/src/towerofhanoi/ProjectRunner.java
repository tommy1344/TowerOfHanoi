package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Tommy Dalessio (tommy1344)
// -------------------------------------------------------------------------
/**
 *  ProjectRunner class used to create and run the project
 * 
 *  @author tommy1344
 *  @version Mar 19, 2024
 */
public class ProjectRunner
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................
    /**
     * Create a new ProjectRunner object.
     */
    public ProjectRunner()
    {
        
    }

    //~Public  Methods ........................................................
    /**
     * Creates a default instance of 6 disks and runs the program
     * @param args - declares a different amount of disks
     */
    public static void main(String[] args)
    {
        int disks = 6;
        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver game = new HanoiSolver(disks);
        PuzzleWindow puzzWin = new PuzzleWindow(game);
    }

}
