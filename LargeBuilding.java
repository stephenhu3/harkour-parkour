import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LargeBuilding extends Actor
{
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        shiftLeft();
        disappear();
    }
    
    public void shiftLeft() {
        setLocation(getX()-3,getY());
    }
    
    public void disappear() {
        if (getX() < getImage().getWidth()/2 -149) {  
                getWorld().removeObject(this);
        }
    }

 
    
    
}
