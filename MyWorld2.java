import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 2 of the game: The world where the astronaut, star, and asteroid exist.
 * 
 * @author Anya Shah
 * @version 12/27/2022
 */
public class MyWorld2 extends World
{
    /**
     * Constructor for objects of class MyWorld2.
     */
    int level = 1;
    public MyWorld2()
    {    
        super(600, 500, 1, false);
        // Creates an astronaut.
        Astronaut astronaut = new Astronaut();
        addObject(astronaut, 100, 400);
        // Spawns an asteroid randomly in the world.
        spawnAsteroid();
    }
    public void spawnAsteroid()
    {
        Asteroid asteroid = new Asteroid();
        asteroid.setSpeed(level);
        int x = Greenfoot.getRandomNumber(501);
        int y = 10;
        addObject(asteroid, x + 50, y);
    }
}
