import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 2 of the game: The world where the astronaut, star, and asteroid exist.
 * 
 * @author Anya Shah
 * @version 12/26/2022
 */
public class MyWorld2 extends World
{
    /**
     * Constructor for objects of class MyWorld2.
     */
    public MyWorld2()
    {    
        super(600, 500, 1, false);
        // Create an astronaut
        Astronaut astronaut = new Astronaut();
        addObject(astronaut, 100, 400);
    }
}
