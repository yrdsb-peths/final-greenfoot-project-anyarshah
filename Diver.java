import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The diver.
 * 
 * @author Anya Shah
 * @version 01/11/2023
 */
public class Diver extends Actor
{
    GreenfootImage[] idleUp = new GreenfootImage[8];
    GreenfootImage[] idleDown = new GreenfootImage[8];
    
    // Direction the diver is facing.
    String facing = "up";
    SimpleTimer animationTimer = new SimpleTimer();
    public Diver()
    {
        for(int i = 0; i < idleUp.length; i++)
        {
            idleUp[i] = new GreenfootImage("images/diver_idle/idle" + i + ".png");
            idleUp[i].scale(90, 40);
        }
        for(int i = 0; i < idleDown.length; i++)
        {
            idleDown[i] = new GreenfootImage("images/diver_idle/idle" + i + ".png");
            idleDown[i].mirrorVertically();
            idleDown[i].scale(90, 40);
        }
        animationTimer.mark();
        // Sets the intial image of the diver.
        setImage(idleUp[0]);
    }
    // Animates the diver.
    int imageIndex = 0;
    public void animateDiver()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("up"))
        {
            setImage(idleUp[imageIndex]);
            imageIndex = (imageIndex + 1) % idleUp.length;
        }
        if(facing.equals("down"))
        {
            setImage(idleDown[imageIndex]);
            imageIndex = (imageIndex + 1) % idleDown.length;
        }
    }
    /**
     * Moves the astronaut up and down using the arrow keys.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(2);
            facing = "up";
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(2);
            facing = "down";
        }
        animateDiver();
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
