import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The astronaut.
 * 
 * @author Anya Shah
 * @version 12/28/2022
 */
public class Astronaut extends Actor
{
    /**
     * Moves the astronaut using the arrow keys.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
    }
}
