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
        endGame();
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
    /**
     * Once the score is 45, 3 labels appear on the screen.
     * One says the player beat the game.
     * The other one thanks the player for playing.
     * Once the player clicks the spacebar, they can restart the game.
     */
    public void endGame()
    {
        MyWorld3 world = (MyWorld3) getWorld();
        if(world.score == 45)
        {
            Label gameDone = new Label("You beat the game!", 55);
            gameDone.setFillColor(Color.PINK);
            world.addObject(gameDone, 300, 125);
            Label thanks = new Label("Thanks for playing!", 55);
            thanks.setFillColor(Color.PINK);
            world.addObject(thanks, 300, 250);
            Label restart = new Label("Press <space> to restart.", 55);
            restart.setFillColor(Color.PINK);
            world.addObject(restart, 300, 375);
            if(Greenfoot.isKeyDown("space"))
            {
                Greenfoot.setWorld(new MyWorld());
            }
        }       
    }
}
