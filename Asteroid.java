import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The asteroid, obstacle to the astronaut.
 * 
 * @author Anya Shah
 * @version 12/28/2022
 */
public class Asteroid extends Actor
{
    int speed = 1;
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        MyWorld2 world = (MyWorld2) getWorld();
        if(getY() >= world.getHeight())
        {
            world.spawnAsteroid();
            getWorld().removeObject(this);
        }
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
