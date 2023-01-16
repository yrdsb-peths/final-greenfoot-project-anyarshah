import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The astronaut.
 * 
 * @author Anya Shah
 * @version 12/28/2022
 */
public class Astronaut extends Actor
{
    GreenfootSound starSound = new GreenfootSound("star_sound.mp3");
    GreenfootSound gameOverSound = new GreenfootSound("game_over.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];
    
    // Direction the astronaut is facing.
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Astronaut()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/astronaut_idle/idle" + i + ".png");
            idleRight[i].scale(70, 90);
        }
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/astronaut_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(70, 90);
        }
        animationTimer.mark();
        // Sets intital astronaut image.
        setImage(idleRight[0]);
    }
    // Animates astronaut.
    int imageIndex = 0;
    public void animateAstronaut()
    {
        if(animationTimer.millisElapsed() < 120)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);   
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        if(facing.equals("left"))
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    /**
     * Moves the astronaut using the arrow keys.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing = "left";
        }
        animateAstronaut();
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
            world.score = 0;
            gameOverSound.play();
            Greenfoot.stop();
        }
        /**
         * Removes the star from the screen when the astronaut catches it.
         * Spawns another star.
         * Increases the score.
         */
        if(isTouching(Star.class))
        {
            MyWorld2 world = (MyWorld2) getWorld();
            starSound.play();
            removeTouching(Star.class);
            world.spawnStar();
            world.increaseScore();
            world.increaseScore();
            // If the score is a multiple of 8, an asteroid and a star appears.
            if(world.score % 8 == 0)
            {
                world.spawnAsteroid();
                world.spawnStar();
            }
        }
    }
    /**
     * Once the score is 30, 2 labels appear on the screen.
     * One says the player beat the level.
     * The other one instructs the player on what to do to move on.
     * Once the player clicks the spacebar, they move on to the next level.
     */
    public void nextLevel()
    {
        if(MyWorld2.score >= 30)
        {
            MyWorld2 world = (MyWorld2) getWorld();
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
