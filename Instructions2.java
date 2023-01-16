import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions for 2nd level of the game.
 * 
 * @author Anya Shah
 * @version 01/13/2023
 */
public class Instructions2 extends World
{
    public Instructions2()
    {    
        super(600, 500, 1, false); 
        Label level = new Label("LEVEL 2", 80);
        addObject(level, 300, 83);
        Label objects = new Label("Avoid the asteroid, catch the star", 43);
        objects.setFillColor(Color.GREEN);
        addObject(objects, 300, 165);
        Label arrows = new Label("Use \u2190, and \u2192 to move", 50);
        arrows.setFillColor(Color.GREEN);
        addObject(arrows, 300, 290);
        Label start = new Label("Press <space> to start", 45);
        start.setFillColor(Color.GREEN);
        addObject(start, 300, 415);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MyWorld2());
        }
    }
}
