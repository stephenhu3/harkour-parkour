    import greenfoot.*;  
    import java.awt.Color;  
    import java.awt.color.*;  
      
    public class HealthBar extends Actor  
    {  
        public final int maxValue = 200; // whatever max value you desire  
        public int changeValue;//allows int changeValue to be accessed by other classes
        public int barValue = 200;  
        private int lastValue = 0;  
        public int numberOfLives = 3;
        //int defeatTimer = 0;
        //int endTimer = 1;
        boolean LivesOne = false;
        boolean LivesTwo = false;
        boolean LivesThree = false;
        public HealthBar()  
        {
  
        }  
      
        public void act()  
        {  
            changeHealth(changeValue);
            getHealth();
            //initLives();
            livesCounter();
            noLives();
                    //if (Greenfoot.isKeyDown("up")) {
           // changeValue = -1;
        //}
            if (barValue != lastValue)  
            {  
                lastValue = barValue;  
                int pctHealth = (int) (300 * barValue / maxValue); // 300 is maxPixelHealth  
                // Create thermometer -- so to speak  
                GreenfootImage imgOne = new GreenfootImage(306,16);  
                imgOne.setColor(Color.CYAN);  
                imgOne.fill();  
                imgOne.setColor(Color.BLUE);  
                imgOne.drawRect(1,1,303,13);  
                // Add mercury, if there is any temperature -- sorta speak  
                if (pctHealth != 0)//has more than 0 health  
                {  
                    GreenfootImage imgTwo = new GreenfootImage(pctHealth,10);//draws "blood" rectangle   
                    imgTwo.setColor(Color.RED);  
                    imgTwo.fill(); // Completes the second image  
                    imgOne.drawImage(imgTwo,3,3); // Puts mercury into the thermometer  
                }  
                // imgOne.scale(myX, myY); // Dimensions myX and myY are whatever size you wish to make it  
                imgOne.setTransparency(128); // Adjust value as wanted or delete statement for no transparency  
                setImage(imgOne);  
            }  
        }  
      
        public void changeHealth(int changeValue) {  
            barValue += changeValue;  
            if (barValue > maxValue) barValue = maxValue;  
            if (barValue < 0) { 
                barValue = 0;
                numberOfLives = numberOfLives - 1;
                barValue = 200;
                destroyShip();
               // ShipWorld();
            }
            
        }
        //just minus from barValue instead. ie. theHealthbar.barValue = theHealthbar.barValue - 10;
        
        public void destroyShip() {
            //Actor destroyShip;
            //Greenfoot.playSound("explosion4.wav");
            getWorld().removeObjects(getWorld().getObjects(Hark.class));
            getWorld().addObject(new Hark(), 125, 400); 
            //destroyShip = Actor(Ship.class);
            //World world;
            //world = getWorld();
            //world.removeObject(destroyShip);
        }  
        
        //public void ShipWorld() {
        //addObject(new Ship(),400,570);
        //}
        
        public int getHealth()  
        {  
            return barValue;  
        }  
    
        public void livesCounter() {//need to remove the lives objects created by the lives variable
            if (numberOfLives != 1) {
                LivesOne = false;
                getWorld().removeObjects(getWorld().getObjects(LivesOne.class));
            }
            
            if (numberOfLives != 2) {
                LivesTwo = false;
                getWorld().removeObjects(getWorld().getObjects(LivesTwo.class));
            }
            
            if (numberOfLives != 3) {
                LivesThree = false;
                getWorld().removeObjects(getWorld().getObjects(LivesThree.class));
            }
            
            if (numberOfLives == 1) {
                LivesOne = true;
                if (LivesOne == true) {
                    getWorld().addObject(new LivesOne(),159,34);
                    LivesOne = false;
                }
            }
                
            if (numberOfLives == 2) {
                LivesTwo = true;
                if (LivesTwo == true) {
                    getWorld().addObject(new LivesTwo(),159,34);
                    getWorld().addObject(new LivesTwo(),173,34);
                    LivesTwo = false;
                }
            }
            
            if (numberOfLives == 3) {
                LivesThree = true;
                if (LivesThree == true) {
                    getWorld().addObject(new LivesThree(),159,34);
                    getWorld().addObject(new LivesThree(),173,34);
                    getWorld().addObject(new LivesThree(),187,34);
                    LivesThree = false;
                }
            }
        }
        
        public void noLives() {//maybe try setting a boolean to true to make the cityworld create the final score counters
            if (numberOfLives <= 0) {
                getWorld().removeObjects(getWorld().getObjects(Hark.class));
                CityWorld CityWorld = (CityWorld) getWorld();
                SpawnFinalScore spawnFinalScore = CityWorld.getSpawnFinalScore();
                spawnFinalScore.changeBoolean();
            }
        }
        
    }  