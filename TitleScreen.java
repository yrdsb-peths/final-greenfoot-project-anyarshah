import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a title screen.
 * 
 * @author Anya Shah
 * @version 12/26/2022
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Game Title", 80);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        super(600, 500, 1, false);
        addObject(titleLabel, getWidth()/2, 50);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld l1 = new MyWorld();
            Greenfoot.setWorld(l1);
        }
    }
}
