import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world where the mouse and snake live.
 * 
 * @author Anya Shah 
 * @version 12/19/2022
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        super(600, 500, 1, false);
        
        Snake snake = new Snake();
        addObject(snake, 100, 400);
    }
}
