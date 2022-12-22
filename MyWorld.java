import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world where the mouse and snake live.
 * 
 * @author Anya Shah 
 * @version 12/21/2022
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     */
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    public MyWorld()
    {   
        super(600, 500, 1, false); 
        // Create a snake
        Snake snake = new Snake();
        addObject(snake, 100, 400);
        // Spawns a mouse randomly in the world.
        spawnMouse();
        // Spawns a bomb randomly in the world.
        spawnBomb();
        // Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        // Create a test animal
        testAnimal();
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
        bomb.setSpeed(level);
        int x = Greenfoot.getRandomNumber(501);
        int y = 10;
        addObject(bomb, x + 50, y);
    }
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 2);
    }
    public void testAnimal()
    {
        GreenfootImage tA = new GreenfootImage(score + 1, 10);
        tA.drawRect(200, 400, score + 1, 10);
    }
}