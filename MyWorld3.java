import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 3 of the game: The world where the sailor, fish, and shark exist. 
 * 
 * @author Anya Shah 
 * @version 01/09/2023
 */
public class MyWorld3 extends World
{
    /**
     * Constructor for objects of class MyWorld3.
     */
    public MyWorld3()
    {    
        super(600, 500, 1, false);
        // Create a diver.
        Diver diver = new Diver();
        addObject(diver, 500, 250);
    }
}
