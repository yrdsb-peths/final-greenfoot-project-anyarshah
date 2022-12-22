import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bomb, obstacle to the snake.
 * 
 * @author Anya Shah
 * @version 12/21/2022
 */
public class Bomb extends Actor
{
    int speed = 1;
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.spawnBomb();
        }
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
