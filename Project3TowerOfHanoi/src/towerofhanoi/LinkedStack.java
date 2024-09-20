package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Tommy Dalessio (tommy1344)

// -------------------------------------------------------------------------
/**
 *  Linked stack of type T class which allows for creation and editting of a 
 *  linked stack
 * 
 *  @author tommy1344
 *  @version Mar 18, 2024
 * @param <T> 
 */
public class LinkedStack<T> implements StackInterface<T>
{
    //~ Fields ................................................................
    private int size;
    private Node topNode;

    
    //~ Constructors ..........................................................
    
    /**
     * Create a new LinkedStack object.
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }
    
    /**
     * returns the size variable
     * @return size
     */
    public int size()
    {
        return size;
    }
    
    /**
     * checks if the stack is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /**
     * clears the stack
     */
    public void clear()
    {
        topNode = null;
        size = 0;
    }
    
    /**
     * Turns the stack into a string using string builder
     * @return stack in string form
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node p = topNode;
        while (p != null) {
            if (s.length() > 1) {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
        }
        s.append("]");
        return s.toString();
    }
    
    /**
     * pushes a new Node to the top of the stack
     * @param anEntry - entry being pushed to the top of the stack
     */
    public void push(T anEntry) 
    {
        topNode = new Node(anEntry, topNode);
        size++;
    }
    
    /**
     * returns the data of the node at the top of the stack without 
     * changing the stack
     * @return topNode data
     */
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }
    
    /**
     * returns the data of the node at the top of the stack and then removes it
     * @return topNode data
     */
    public T pop()
    {
        T top = peek();
        topNode = topNode.getNextNode();
        size--;
        return top;
    }

    //~Public  Methods ........................................................
    private class Node
    {
      //~ Fields ..............................................................
        private T data;
        private Node next;
      //~ Constructors ........................................................
        
        /**
         * Create a new Node object.
         * @param newData - data which is assigned to the node
         */
        public Node(T newData)
        {
            data = newData;
            next = null;
        }
        /**
         * Create a new Node object.
         * @param newData - data which is assigned to the node
         * @param nextNode - the next node in the stack
         */
        public Node(T newData, Node nextNode)
        {
            data = newData;
            next = nextNode;
        }
        /**
         * assigns the next node in the stack
         * @param nextNode - the next node being assigned to
         */
        public void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
        
        /**
         * returns the next node in the stack
         * @return the next node in the stack
         */
        public Node getNextNode()
        {
            return next;
        }
        
        /**
         * returns the data of the selected node
         * @return data
         */
        public T getData()
        {
            return data;
        }
    }

}

