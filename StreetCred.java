import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StreetCred extends Actor
{
    
    /**
     * Act - do whatever the StreetCred wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    boolean collide = false;
    public void act() 
    {
        //checkCollision();
        shiftLeft();
        disappear();
        touchingGround();
        touchingLargeBuilding();
    }
   
    
    public void shiftLeft() {
        setLocation(getX()-5,getY());
    }
    
    public void disappear() {
        if (getX() < getImage().getWidth()/2 -1) {  
            collide = true;
            getWorld().removeObject(this);
        }
    }
    
    public void touchingGround(){
        Actor touchingGround;
        if (collide == false) {
            touchingGround = getOneObjectAtOffset(0,0, Ground.class);
            if (touchingGround != null) {
                World world;
                world = getWorld();
                world.removeObject(touchingGround);
                touchingGround = null;
                getWorld().removeObject(this);
                //collide = true;
            }
        }
    }
    
    public void touchingLargeBuilding(){
        Actor touchingLargeBuilding;
            if (collide == false) {
                touchingLargeBuilding = getOneObjectAtOffset(0,0, LargeBuilding.class);
                if (touchingLargeBuilding != null) {
                    World world;
                    world = getWorld();
                    world.removeObject(touchingLargeBuilding);
                    touchingLargeBuilding = null;
                    getWorld().removeObject(this);
                    collide = true;
                }
            }
    }
    
}
