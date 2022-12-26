import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The snake.
 * 
 * @author Anya Shah
 * @version 12/26/2022
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
    public void eat()
    {
        /**
         * Removes the mouse from the screen when the snake touches it.
         * Spawns a new mouse once one is eaten.
         * Increases the score.
         * Each time 10 mice are eaten, a bomb gets spawned.
         * If 15 mice are eaten, player moves to the next level.
         */
        if(isTouching(Mouse.class))
        {
            removeTouching(Mouse.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnMouse();
            world.increaseScore();
            if(world.score % 10 == 0)
            {
                world.spawnBomb();   
            }
            if(world.score == 15)
            {
                world.nextLevel();   
            }
        }
        // Stops the game and "game over" appears on the screen if the snake touches the bomb.
        if(isTouching(Bomb.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
            Greenfoot.stop();
        }
        // Stops the game and "game over" appears on the screen if the snake reaches the edge.
        if(isAtEdge())
        {
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
            Greenfoot.stop();
        }
    }
}
