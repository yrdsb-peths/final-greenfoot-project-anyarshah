import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The diver.
 * 
 * @author Anya Shah
 * @version 01/10/2023
 */
public class Diver extends Actor
{
    /**
     * Moves the astronaut up and down using the arrow keys.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(2);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(2);
        }
    }
}
