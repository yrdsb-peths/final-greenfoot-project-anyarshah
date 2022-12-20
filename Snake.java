import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The snake.
 * 
 * @author Anya Shah
 * @version 12/20/2022
 */
public class Snake extends Actor
{
    /**
     * Moves the snake in the direction of the pressed key.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
            move(2);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(2);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
            move(2);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(2);
        }
        eat();
    }
    /**
     * Removes the mouse from the screen when the snake touches it.
     * Spawns a new mouse once one is eaten.
     */
    public void eat()
    {
        if(isTouching(Mouse.class))
        {
            removeTouching(Mouse.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnMouse();
        }
    }
}
