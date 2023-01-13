import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions for 3rd level of game.
 * 
 * @author Anya Shah
 * @version 01/13/2023
 */
public class Instructions3 extends World
{
    public Instructions3()
    {    
        super(600, 500, 1, false);
        Label level = new Label("LEVEL 3", 80);
        addObject(level, 300, 83);
        Label objects = new Label("Avoid the shark, save the fish", 43);
        objects.setFillColor(Color.PINK);
        addObject(objects, 300, 165);
        Label arrows = new Label("Use \u2191, and \u2913 to move", 50);
        arrows.setFillColor(Color.PINK);
        addObject(arrows, 300, 290);
        Label start = new Label("Press <space> to start", 45);
        start.setFillColor(Color.PINK);
        addObject(start, 300, 415);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MyWorld3());
        }
    }
}
