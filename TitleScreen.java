import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a title screen.
 * 
 * @author Anya Shah
 * @version 01/13/2023
 */
public class TitleScreen extends World
{
    public TitleScreen()
    {    
        super(600, 500, 1, false);
        Label titleLabel = new Label("Catch and Avoid", 80);
        addObject(titleLabel, 300, 125);
        prepare();
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new Instructions1());
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Snake(), 150, 250);
        addObject(new Astronaut(), 300, 250);
        addObject(new Diver(), 450, 250);
        Label label2 = new Label("Press <space> for instructions", 45);
        addObject(label2, 300, 375);
    }
}
