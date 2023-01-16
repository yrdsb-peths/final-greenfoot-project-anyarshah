import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The snake.
 * 
 * @author Anya Shah
 * @version 12/27/2022
 */
public class Snake extends Actor
{
    GreenfootSound snakeSound = new GreenfootSound("snake_sound.mp3");
    GreenfootSound bombSound = new GreenfootSound("bomb_sound.mp3");
    GreenfootSound gameOverSound = new GreenfootSound("game_over.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[6];
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    GreenfootImage[] idleUp = new GreenfootImage[6];
    GreenfootImage[] idleDown = new GreenfootImage[6];
    // Direction the snake is facing.
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Snake()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/snake_idle/idle" + i + ".png");
            idleRight[i].scale(80, 70);
        }
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/snake_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80, 70);
        }
        for(int i = 0; i < idleUp.length; i++)
        {
            idleUp[i] = new GreenfootImage("images/snake_idle/idle" + i + ".png");
            idleUp[i].scale(80, 70);
        }
        for(int i = 0; i < idleDown.length; i++)
        {
            idleDown[i] = new GreenfootImage("images/snake_idle/idle" + i + ".png");
            idleDown[i].scale(80, 70);
        }
        animationTimer.mark();
        // Sets the initial image of the snake.
        setImage(idleRight[0]);
    }
    // Animates the snake.
    int imageIndex = 0;
    public void animateSnake()
    {
        if(animationTimer.millisElapsed() < 175)
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
     * Moves the snake in the direction of the pressed key.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
            move(2);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(0);
            setRotation(270);
            move(2);
            facing = "up";
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(0);
            move(-2);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(0);
            setRotation(90);
            move(2);
            facing = "down";
        }
        animateSnake();
        eat();
        nextLevel();
    }
    public void eat()
    {
        /**
         * Removes the mouse from the screen when the snake touches it.
         * Spawns a new mouse once one is eaten.
         * Increases the score.
         * Snake sound plays.
         * Each time 10 mice are eaten, a bomb gets spawned.
         */
        if(isTouching(Mouse.class))
        {
            MyWorld world = (MyWorld) getWorld();
            snakeSound.play();
            removeTouching(Mouse.class);
            world.spawnMouse();
            world.increaseScore();
            if(world.score % 10 == 0)
            {
                world.spawnBomb();   
            }
        }
        /**
         * If snake touches bomb:
         * Bomb sound plays.
         * Game over appears on screen.
         * Game stops.
         */
        if(isTouching(Bomb.class))
        {
            MyWorld world = (MyWorld) getWorld();
            bombSound.play();
            world.gameOver();
            world.score = 0;
            gameOverSound.play();
            Greenfoot.stop();
        }
        /**
         * If snake touches edge:
         * Game over appears on screen.
         * Game stops.
         */
        if(isAtEdge())
        {
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
            world.score = 0;
            gameOverSound.play();
            Greenfoot.stop();
        }
    }
    /**
     * Once 15 mice are eaten, 2 labels appear on the screen.
     * One says the player beat the first level.
     * The other one instructs the player on what to do to move on.
     * Once the player clicks the spacebar, they move on to the next level.
     */
    public void nextLevel()
    {
        if(MyWorld.score == 20)
        {
            MyWorld world = (MyWorld) getWorld();
            Label nextLevelLabel = new Label("You beat this level!", 55);
            nextLevelLabel.setFillColor(Color.BLUE);
            world.addObject(nextLevelLabel, 300, 175);
            Label moveOnLabel = new Label("Press <space> to move on.", 55);
            moveOnLabel.setFillColor(Color.BLUE);
            world.addObject(moveOnLabel, 300, 325);
            if(Greenfoot.isKeyDown("space"))
            {
                Greenfoot.setWorld(new Instructions2());
            }
        }
    }
}
