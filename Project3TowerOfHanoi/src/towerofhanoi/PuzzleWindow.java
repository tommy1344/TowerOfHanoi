package towerofhanoi;
// Virginia Tech Honor Code Pledge:
//
// Project 3
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Tommy Dalessio (tommy1344)
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
/**
* The main front-end work and the view for the Tower of Hanoi puzzle
*
* @author tommy1344
* @version 3/19/2024
*/
public class PuzzleWindow implements Observer 
{
    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    /**
    * A factor in which the width of the disks are multiplied by
    */
    public static final int WIDTH_FACTOR = 15;
    /**
    * The vertical gap between each disk on the tower
    */
    public static final int DISK_GAP = 0;
    /**
    * The height of each disk on the tower
    */
    public static final int DISK_HEIGHT = 15;
    /**
    * Creates a new PuzzleWindow view for a given HanoiSolver game
    *
    * @param g the game to create a view for
    */
    public PuzzleWindow(HanoiSolver g) 
    {
        this.game = g;
        game.addObserver(this);
        
        // declaring window
        window = new Window("Tower of Hanoi");
        window.setSize(500,1000);
        
      //The height and Y location of each pole are the same
        int poleHeight = 400;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape((150 - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        middle = new Shape(((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        right = new Shape(((window.getGraphPanelWidth() - 150) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        
        for (int width = (game.disks() + 1) * WIDTH_FACTOR;
            width > WIDTH_FACTOR;
            width -= WIDTH_FACTOR) 
        {
            // adds the disks to the window
           Disk visualDisk = new Disk(width);
           game.getTower(Position.LEFT).push(visualDisk);
           window.addShape(visualDisk);
           moveDisk(Position.LEFT);
           
       }
        // adds pillars to window
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        
        // adds solve button to window
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }
    private void moveDisk(Position position) 
    {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        switch(position)
        {
            case LEFT:
                currentPole = left;
                break;
            case RIGHT:
                currentPole = right;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            default:
                currentPole = middle;
                break;
        }
        
        // calculating and moving the disk to the desired coordinates
        int xCord = currentPole.getX() - currentDisk.getWidth()/2 
            + currentPole.getWidth()/2;
        int yCord = currentPole.getY() + currentPole.getHeight()
            - (game.getTower(position).size() * DISK_HEIGHT);
        currentDisk.moveTo(xCord, yCord);
    }
    
    /**
    * Updates the view whenever a disk is moved in the back-end
    *
    * @param o The observable that triggered the update
    * @param arg arguments sent by the game; should be a position
    */
    @Override
    public void update(Observable o, Object arg) 
    {
        if (arg.getClass() == Position.class) 
        {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }
    /**
    * Runs when the Solve button is clicked, tells the puzzle to start solving
    *
    * @param button the button that was clicked
    */
    public void clickedSolve(Button button) 
    {
        button.disable();
        new Thread() 
        {
            public void run() 
            {
            game.solve();
            }
        }.start();
    }
    private void sleep() 
    {
        try 
        {
        Thread.sleep(500);
        }
        catch (Exception e) 
        {
        }
    }
}