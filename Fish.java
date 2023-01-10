import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The fish.
 * 
 * @author Anya Shah 
 * @version 01/10/2023
 */
public class Fish extends Actor
{
    int speed = 1;
    public void act()
    {
        int x = getX() + speed;
        int y = getY();
        setLocation(x, y);
        
        MyWorld3 world = (MyWorld3) getWorld();
        if(getX() >= world.getWidth())
        {
            world.decreaseBy2();
            world.spawnFish();
            getWorld().removeObject(this);
        }
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
