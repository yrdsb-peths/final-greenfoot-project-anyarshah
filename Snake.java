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
        nextLevel();
    }
    public void eat()
    {
        /**
         * Removes the mouse from the screen when the snake touches it.
         * Spawns a new mouse once one is eaten.
         * Increases the score.
         * Each time 10 mice are eaten, a bomb gets spawned.
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
    /**
     * Once 15 mice are eaten, 2 labels appear on the screen.
     * Once says the player beat the first level.
     * The next instructs the player on what to do to move on.
     * Once the player clicks the spacebar, they move on to the next level.
     */
    public void nextLevel()
    {
        MyWorld world = (MyWorld) getWorld();
        if(world.score == 15)
        {
            Label nextLevelLabel = new Label("You beat this level!", 55);
            world.addObject(nextLevelLabel, 300, 175);
            Label moveOnLabel = new Label("Press <space> to move on.", 55);
            world.addObject(moveOnLabel, 300, 325);
            if(Greenfoot.isKeyDown("space"))
            {
                Greenfoot.setWorld(new MyWorld2());
            }
        }
    }
}
