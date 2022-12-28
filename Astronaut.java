import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The astronaut.
 * 
 * @author Anya Shah
 * @version 12/28/2022
 */
public class Astronaut extends Actor
{
    /**
     * Moves the astronaut using the arrow keys.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        capture();
        nextLevel();
    }
    public void capture()
    {
        /**
         * If astronaut hits asteroid:
         * Game over appears on screen.
         * Game stops.
         */
        if(isTouching(Asteroid.class))
        {
            MyWorld2 world = (MyWorld2) getWorld();
            world.gameOver();
            Greenfoot.stop();
        }
        /**
         * Removes the star from the screen when the astronaut catches it.
         * Spawns another star.
         * Increases the score.
         * Everytime the score is a multiple of 5, an asteroid gets spawned.
         */
        if(isTouching(Star.class))
        {
            removeTouching(Star.class);
            MyWorld2 world = (MyWorld2) getWorld();
            world.spawnStar();
            world.increaseScore();
            world.increaseScore();
            if(world.score % 5 == 0)
            {
                world.spawnAsteroid();   
            }
        }
    }
    /**
     * Once the score is 30, 2 labels appear on the screen.
     * One says the player beat the first level.
     * The other one instructs the player on what to do to move on.
     * Once the player clicks the spacebar, they move on to the next level.
     */
    public void nextLevel()
    {
        MyWorld2 world = (MyWorld2) getWorld();
        if(world.score == 30)
        {
            Label nextLevelLabel = new Label("You beat this level!", 55);
            nextLevelLabel.setFillColor(Color.GREEN);
            world.addObject(nextLevelLabel, 300, 175);
            Label moveOnLabel = new Label("Press <space> to move on.", 55);
            moveOnLabel.setFillColor(Color.GREEN);
            world.addObject(moveOnLabel, 300, 325);
            if(Greenfoot.isKeyDown("space"))
            {
                Greenfoot.setWorld(new MyWorld3());
            }
        }
    }
}
