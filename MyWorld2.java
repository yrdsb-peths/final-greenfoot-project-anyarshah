import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 2 of the game: The world where the astronaut, star, and asteroid exist.
 * 
 * @author Anya Shah
 * @version 12/28/2022
 */
public class MyWorld2 extends World
{
    /**
     * Constructor for objects of class MyWorld2.
     */
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    public MyWorld2()
    {    
        super(600, 500, 1, false);
        // Creates an astronaut.
        Astronaut astronaut = new Astronaut();
        addObject(astronaut, 100, 400);
        // Spawns an asteroid randomly in the world.
        spawnAsteroid();
        // Spawns a star randomly in the world.
        spawnStar();
        // Creates score label.
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
    }
    public void spawnAsteroid()
    {
        Asteroid asteroid = new Asteroid();
        asteroid.setSpeed(level);
        int x = Greenfoot.getRandomNumber(501);
        int y = 10;
        addObject(asteroid, x + 50, y);
    }
    public void spawnStar()
    {
        Star star = new Star();
        star.setSpeed(level);
        int x = Greenfoot.getRandomNumber(501);
        int y = 10;
        addObject(star, x + 50, y);
    }
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    public void decreaseScore()
    {
        score--;
        scoreLabel.setValue(score);
    }
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 2);
    }
}