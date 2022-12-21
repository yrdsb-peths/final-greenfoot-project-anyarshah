import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bomb, obstacle to the snake.
 * 
 * @author Anya Shah
 * @version 12/20/2022
 */
public class Bomb extends Actor
{
    public void act()
    {
        int x = getX();
        int y = getY();
        setLocation(x, y);
    }
}
