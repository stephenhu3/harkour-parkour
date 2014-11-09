import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cour extends Actor
{
    /**
     * Act - do whatever the Cour wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movementCour();
    }    
    
    public void movementCour() {
        if (Greenfoot.isKeyDown("d")) {
            moveCourRight();
        }
    
        if (Greenfoot.isKeyDown("a")) {
            moveCourLeft();
        }
    
        if (Greenfoot.isKeyDown("w")) {
            moveCourUp();
        }
        
        if (Greenfoot.isKeyDown("s")) {
            moveCourDown();
        }        
    }
    
    public void moveCourRight() {
        setLocation(getX()+3,getY());
    }

    public void moveCourLeft() {
        setLocation(getX()-3,getY());
    }

    public void moveCourUp() {
        setLocation(getX(),getY()-4);
    }

    public void moveCourDown() {
        setLocation(getX(),getY()+2);
    }
}

