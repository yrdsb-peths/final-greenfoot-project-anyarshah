import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions for 1st level of game.
 * 
 * @author Anya Shah
 * @version 01/13/2023
 */
public class Instructions1 extends World
{
    public Instructions1()
    {    
        super(600, 500, 1, false);
        Label level = new Label("LEVEL 1", 80);
        addObject(level, 300, 83);
        Label objects = new Label("Avoid the bomb, eat the mouse", 43);
        objects.setFillColor(Color.BLUE);
        addObject(objects, 300, 165);
        Label arrows = new Label("Use \u2190, \u2191, \u2192, and \u2913 to move", 50);
        arrows.setFillColor(Color.BLUE);
        addObject(arrows, 300, 290);
        Label start = new Label("Press <space> to start", 45);
        start.setFillColor(Color.BLUE);
        addObject(start, 300, 415);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
