import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world where the mouse and snake live.
 * 
 * @author Anya Shah 
 * @version 12/20/2022
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     */
    public int score = 0;
    Label scoreLabel;
    public MyWorld()
    {   
        super(600, 500, 1, false); 
        // Create a snake
        Snake snake = new Snake();
        addObject(snake, 100, 400);
        // Spawns a mouse randomly in the world.
        spawnMouse();
        // Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
    }
    public void spawnMouse()
    {
        Mouse mouse = new Mouse();
        int x = Greenfoot.getRandomNumber(501);
        int y = Greenfoot.getRandomNumber(401);
        addObject(mouse, x + 50, y + 50);
    }
    public void spawnBomb()
    {
        Bomb bomb = new Bomb();
        int x = Greenfoot.getRandomNumber(501);
        int y = Greenfoot.getRandomNumber(401);
        addObject(bomb, x + 50, y + 50);
    }
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
}
