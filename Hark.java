import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hark extends Actor
{
    /**
     * Act - do whatever the Hark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    private int speed = 7;
    private int vSpeed = 0;
    private int vAcceleration = 1;
    private int jumpStrength = -18;
    boolean collide = false;
    int timer = 10;
    int flipTimer = 37;
    int rollTimer = 24;
    int flipOn = 1;
    //boolean gainRespect = false;
    //boolean movementKeyPressed = false;
    
    public void act() 
    {
        //movementKeyPressed = false;
        movement();
        checkFall();
        underGround();
        leftOfGround();
        rightOfGround();
        shiftLeft();
        underLargeBuilding();
        leftOfLargeBuilding();
        rightOfLargeBuilding();
        streetCred();
        touchBird();
        flip();
        roll();
        fallen();
        inAir();
    }    
    
    public void inAir() {
        if (vSpeed != 0) {
            gainInAir();
        }
    }
    
    public void fallen() {
       if (getY() >= getWorld().getHeight() - 1) {
                getReallyHurt();
        }
    }
    
    public void getHurt() {
        collide = true;
        if (collide == true) {
            collide = true;
            CityWorld CityWorld = (CityWorld) getWorld();
            HealthBar theHealthBar = CityWorld.getHealthBar();
            theHealthBar.barValue = theHealthBar.barValue - 101;// 
            

            collide = false;
        }
    }    
    
        public void getReallyHurt() {
        collide = true;
        if (collide == true) {
            collide = true;
            CityWorld CityWorld = (CityWorld) getWorld();
            HealthBar theHealthBar = CityWorld.getHealthBar();
            theHealthBar.barValue = theHealthBar.barValue - 201;// 
            

            collide = false;
        }
    } 
    
    public void touchBird() {
        Actor birdy;
        //if (collide == false) {
            birdy = getOneObjectAtOffset(0,0, EnemyBird.class);
            if (birdy != null) {
                getHurt();
                World world;
                world = getWorld();
                world.removeObject(birdy);
                birdy = null;
            }
    }
    
    public void flip() {//set a timer for after pressing flip (see how long it takes), if touches ground before finishing flip, lose hp
        if (Greenfoot.isKeyDown("shift")) {
            if (vSpeed != 0) {
                flipTimer();
            }
        }
    }
    
    public void roll(){ //spin and move right quickly
        if (Greenfoot.isKeyDown("control")) {
            setLocation(getX()+9,getY());
            rollTimer();
        }
    }
    
    
    public void rollTimer() {
        rollTimer = rollTimer - 1;
            if (rollTimer <= 24) {
                setImage("spin30.png");
            }
            if (rollTimer <= 22) {
                setImage("spin60.png");
            }
            if (rollTimer <= 20) {
                setImage("spin90.png");
            }
            if (rollTimer <= 18) {
                setImage("spin120.png");
            }
            if (rollTimer <= 16) {
                setImage("spin150.png");
            }
            if (rollTimer <= 14) {
                setImage("spin180.png");
            }
            if (rollTimer <= 12) {
                setImage("spin210.png");
            }
            if (rollTimer <= 10) {
                setImage("spin240.png");
            }
            if (rollTimer <= 8) {
                setImage("spin270.png");
            }
            if (rollTimer <= 6) {
                setImage("spin300.png");
            }
            if (rollTimer <= 4) {
                setImage("spin330.png");
            }
            if (rollTimer <= 2) {
                setImage("spin360.png");
                rollTimer = 24;
            }
    }
    
    public void flipTimer() {
        flipTimer = flipTimer - 1;
            if (flipTimer <= 36) {
                setImage("spin360.png");
            }
            if (flipTimer <= 33) {
                setImage("spin330.png");
            }
            if (flipTimer <= 30) {
                setImage("spin300.png");
            }
            if (flipTimer <= 27) {
                setImage("spin270.png");
            }
            if (flipTimer <= 24) {
                setImage("spin240.png");
            }
            if (flipTimer <= 21) {
                setImage("spin210.png");
            }
            if (flipTimer <= 18) {
                setImage("spin180.png");
            }
            if (flipTimer <= 15) {
                setImage("spin150.png");
            }
            if (flipTimer <= 12) {
                setImage("spin120.png");
            }
            if (flipTimer <= 9) {
                setImage("spin90.png");
            }
            if (flipTimer <= 6) {
                setImage("spin60.png");
            }
            if (flipTimer <= 3) {
                gainRespect();
                setImage("spin30.png");
                flipTimer = 36;
            }
    }
    
    public void running() {
        if (aboveGround() || aboveLargeBuilding()) {
            if (collide == false) {
                timer = timer -1;
                if (timer >= 5) {
                    setImage("harkOne.png");
                }
        
                if (timer <= 4) {
                    setImage("harkTwo.png");
                }
        
                if (timer <= 0) {
                    timer = 10;
                }
            }
        }
    }
    
    public void movement() {
        
        if (Greenfoot.isKeyDown("right")) {
            //movementKeyPressed = true;//have it be true when pressed down
            moveRight();
            running();
        }
    
        if (Greenfoot.isKeyDown("left")) {
            moveLeft();
            running();
        }
    
        if (Greenfoot.isKeyDown("space")) {
            jump();
        }
        
    }
    
    public void moveRight() {
        setLocation(getX()+6,getY());
    }

    public void moveLeft() {
        setLocation(getX()-2,getY());
    }
    
    public void shiftLeft() {
        setLocation(getX()-3,getY());
    }

    public void jump() {
        if (aboveGround()) {
            vSpeed = jumpStrength;
            fall();
        }
                    
        if (belowGround()) {
            setLocation(getX(),getY()+2);
            fall();
            vSpeed = 0;
        }
        
        if (aboveLargeBuilding()) {
            vSpeed = jumpStrength;
            fall();
        }
                    
        if (belowLargeBuilding()) {
            setLocation(getX(),getY()+2);
            fall();
            vSpeed = 0;
        }
    }
//do better collision checking for sides and reduce size of sprite
    public void moveDown() {
        setLocation(getX(),getY()+2);
    }
    
    public void checkFall () {
        if (aboveGround() || aboveLargeBuilding()) {
            vSpeed = 0;
        }
            else {
                fall();
            }
    }
    
    public void fall() {
        setLocation(getX(),getY() + vSpeed);
        vSpeed = vSpeed + vAcceleration;
    }
    //origin of image at 0,0 at centre of image
    //disallow jumping when under ground, make it null?
    public boolean aboveGround() {
        Actor above = getOneObjectAtOffset(0, 32, Ground.class);
        return above != null;
    }
    
    public boolean belowGround() {
        Actor below = getOneObjectAtOffset(0, -32, Ground.class);
        return below != null;
    }
    
    public void underGround() {
        Actor under;
        if (collide == false) {
        under = getOneObjectAtOffset(0, -32, Ground.class);
        if (under != null) {
            setLocation(getX(),getY()+2);
            fall();
            vSpeed = 0;
        }
        }
    }
    
            public void leftOfGround() {
        Actor leftOfGround;
        if (collide == false) {
        leftOfGround = getOneObjectAtOffset(-1, 0, Ground.class);//origin at centre of image
        if (leftOfGround != null) {
            setLocation(getX()-6,getY());
            //fall();
            //vSpeed = 0;
        }
        }
    }
    
        public void rightOfGround() {
        Actor rightOfGround;
        //rightOfLarge = getOneObjectAtOffset((getImage().getWidth()/2)+33, 0, LargeBuilding.class);//origin at centre of image
        if (collide == false) {
        rightOfGround = getOneObjectAtOffset(+2, 0, Ground.class);//origin at centre of image
        if (rightOfGround != null) {
            setLocation(getX()+2,getY());
            //fall();
            //vSpeed = 0;
        }
        }
    }
    
    public boolean aboveLargeBuilding() {
        Actor above = getOneObjectAtOffset(0, 42, LargeBuilding.class);
        return above != null;
    }
    
    public boolean belowLargeBuilding() {
        Actor below = getOneObjectAtOffset(0, -42, LargeBuilding.class);
        return below != null;
    }
    
    public void underLargeBuilding() {
        Actor underLarge;
        if (collide == false) {
        underLarge = getOneObjectAtOffset(0, -42, LargeBuilding.class);
        if (underLarge != null) {
            setLocation(getX(),getY()+2);
            fall();
            vSpeed = 0;
        }
        }
    }
    
        public void leftOfLargeBuilding() {
        Actor leftOfLarge;
        if (collide == false) {
        leftOfLarge = getOneObjectAtOffset(-1, 0, LargeBuilding.class);//origin at centre of image
        if (leftOfLarge != null) {
            setLocation(getX()-6,getY());
            //fall();
            //vSpeed = 0;
        }
        }
    }
    
        public void rightOfLargeBuilding() {
        Actor rightOfLarge;
        //rightOfLarge = getOneObjectAtOffset((getImage().getWidth()/2)+33, 0, LargeBuilding.class);//origin at centre of image
        if (collide == false) {
        rightOfLarge = getOneObjectAtOffset(2, 0, LargeBuilding.class);//origin at centre of image
        if (rightOfLarge != null) {
            setLocation(getX()+2,getY());
            //fall();
            //vSpeed = 0;
        }
        }
    }
    
    public void streetCred() {
        Actor streetCred;
        if (collide == false) {
            streetCred = getOneObjectAtOffset(0,0, StreetCred.class);
            if (streetCred != null) {
                gainMultiplier();
                World world;
                world = getWorld();
                world.removeObject(streetCred);
                streetCred = null;
            }
        }
    }
    
    public void gainInAir() {
        CityWorld CityWorld = (CityWorld) getWorld();
        Counter counter = CityWorld.getCounter();
        counter.bumpCount(1);
    }
    
    public void gainRespect() {
            CityWorld CityWorld = (CityWorld) getWorld();
            Counter counter = CityWorld.getCounter();
            counter.bumpCount(100);
    }

    public void gainMultiplier() {
            CityWorld CityWorld = (CityWorld) getWorld();
            Multiplier multiplier = CityWorld.getMultiplier();
            multiplier.bumpMultiplier(1);
    }
    
}

