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
        save();
    }
    public void save()
    {
        MyWorld3 world = (MyWorld3) getWorld();
        /**
         * Removes the fish from the screen when the diver saves it.
         * Spawns another fish.
         * Increases the score.
         * Spawns another shark.
         */
        if(isTouching(Fish.class))
        {
            removeTouching(Fish.class);
            world.spawnFish();
            world.increaseScore();
            // Every time the diver saves ten fish, another shark spawns. 
            if(world.score % 10 == 0)
            {
                world.spawnShark();
            }
        }
        /**
         * If diver touches shark:
         * Game over appears on screen.
         * Game stops.
         */
        if(isTouching(Shark.class))
        {
            world.gameOver();
            Greenfoot.stop();
        }
    }
}
