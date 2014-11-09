import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnemyBird extends Enemy
{
    /**
     * Act - do whatever the EnemyBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int timer = 100;
    boolean collide = false;
    public void act() 
    {
        flyLeft();
        disappear();
        flapWings();
        //touchingHark();
    }    
    
    public void flyLeft() {
        if (collide == false) {
            setLocation(getX()-1,getY());
        }
    }
    
    public void flapWings() {
        if (collide == false) {
        timer = timer -1;
        if (timer >= 50) {
            setImage("birdup.png");
            setLocation(getX(),getY()-2);
        }
        
        if (timer <= 49) {
            setImage("birddown.png");
            setLocation(getX(),getY()+2);
        }
        
        if (timer <= 0) {
            timer = 100;
        }
    }
    }
    
    public void disappear() {
        if (collide == false) {
            if (getX() < getImage().getWidth()/2 +1) {  
                collide = true;
                getWorld().removeObject(this);
                //collide = false;
            }
        }
    }
    
    public void touchingHark() {
        if (collide == false) {
        Actor bird;
        bird = getOneObjectAtOffset(0,0, Hark.class);
        if (bird != null) {
            World world;
            world = getWorld();
            //world.removeObject(this);
            CityWorld CityWorld = (CityWorld) getWorld();
            HealthBar theHealthBar = CityWorld.getHealthBar();
            theHealthBar.barValue = theHealthBar.barValue - 100;// *FIXED* find fix to how the healthbar keeps deducting
            bird = null;
        }
        }
    }    
}
