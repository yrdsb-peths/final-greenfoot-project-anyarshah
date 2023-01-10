import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 3 of the game: The world where the sailor, fish, and shark exist. 
 * 
 * @author Anya Shah 
 * @version 01/09/2023
 */
public class MyWorld3 extends World
{
    /**
     * Constructor for objects of class MyWorld3.
     */
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    public MyWorld3()
    {    
        super(600, 500, 1, false);
        // Create a diver.
        Diver diver = new Diver();
        addObject(diver, 500, 250);
        // Spawns a fish randomly in the world.
        spawnFish();
        // Spawns a shark randomly in the world.
        spawnShark();
        // Creates a score label. 
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
    }
    public void spawnFish()
    {
        Fish fish = new Fish();
        fish.setSpeed(level);
        int x = 10;
        int y = Greenfoot.getRandomNumber(401);
        addObject(fish, x, y + 50);
    }
    public void spawnShark()
    {
        Shark shark = new Shark();
        shark.setSpeed(level);
        int x = 10;
        int y = Greenfoot.getRandomNumber(401);
        addObject(shark, x, y + 50);
    }
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    public void decreaseBy2()
    {
        score -= 2;
        scoreLabel.setValue(score);
    }
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 2);
    }
}
