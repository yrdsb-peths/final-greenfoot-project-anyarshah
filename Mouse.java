import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The mouse.
 * 
 * @author Anya Shah
 * @version 12/19/2022
 */
public class Mouse extends Actor
{
    public void act()
    {
        int x = getX();
        int y = getY();
        setLocation(x, y);
    }
}
