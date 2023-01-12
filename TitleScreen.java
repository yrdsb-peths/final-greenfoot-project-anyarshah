import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a title screen.
 * 
 * @author Anya Shah
 * @version 01/12/2023
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Game Title", 80);
    public TitleScreen()
    {    
        super(600, 500, 1, false);
        addObject(titleLabel, 300, 60);
        prepare();
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("3 Levels", 80);
        addObject(label, 300, 160);
        addObject(new Snake(), 150, 250);
        // addObject(new Astronaut(), 300, 250);
        // addObject(new Diver(), 450, 250);
    }
}
