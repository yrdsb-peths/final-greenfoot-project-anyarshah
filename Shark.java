import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The shark, obstacle to the diver.
 * 
 * @author Anya Shah
 * @version 01/09/2023
 */
public class Shark extends Actor
{
    int speed = 1;
    public void act()
    {
        int x = getX() + speed;
        int y = getY();
        setLocation(x, y);
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
