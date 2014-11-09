import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CityWorld extends World
{

    

    /**
     * Constructor for objects of class CityWorld.
     * 
     */
    //changed from private to public to allow classes to access
    public Counter theCounter;
    public FinalScoreCounter theFinalScoreCounter;
    public FinalScoreRespect theFinalScoreRespect;
    public FinalScoreMultiplier theFinalScoreMultiplier;
    public Multiplier theMultiplier;
    public HealthBar theHealthBar;
    public SpawnFinalScore theSpawnFinalScore;
    //public boolean showFinal = false;
    
    public CityWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        initialSpawner();
        setPaintOrder(FinalScoreCounter.class,FinalScoreMultiplier.class, FinalScoreRespect.class, FinalScore.class, Counter.class, Multiplier.class, ScoreBoard.class, LargeBuilding.class, Ground.class);
        theCounter = new Counter();
        theFinalScoreCounter = new FinalScoreCounter();
        theFinalScoreRespect = new FinalScoreRespect();
        theFinalScoreMultiplier = new FinalScoreMultiplier();
        theMultiplier = new Multiplier();
        theHealthBar = new HealthBar();
        theSpawnFinalScore = new SpawnFinalScore();//check this out
        addObject(new ScoreBoard(), 75, 25);
        addObject(theCounter, 75, 25);
        addObject(theMultiplier, 135, 37);
        addObject(theHealthBar, 304, 10);
        addObject(theSpawnFinalScore, 900, 900);//vital
        
    }
    
    public void showFinalScores() {
        //CityWorld CityWorld = (CityWorld) getWorld();
        //SpawnFinalScore spawnFinalScore = CityWorld.getSpawnFinalScore();
            if (theSpawnFinalScore.showFinalScore == true) {
                addObject(theFinalScoreCounter, 389, 204);
                addObject(theFinalScoreMultiplier, 578, 252);
                addObject(theFinalScoreRespect, 506, 300);
                addObject(new FinalScore(), 405, 281);
            }
    }
    
    public SpawnFinalScore getSpawnFinalScore() {
        return theSpawnFinalScore;
    }
    
    public HealthBar getHealthBar() {
        return theHealthBar;
    }
    
    public Counter getCounter() { 
        return theCounter;
    }
    
     public FinalScoreCounter getFinalScoreCounter() { 
        return theFinalScoreCounter;
    }
    
     public FinalScoreRespect getFinalScoreRespect() { 
        return theFinalScoreRespect;
    }
    
     public FinalScoreMultiplier getFinalScoreMultiplier() { 
        return theFinalScoreMultiplier;
    }
    
    public Multiplier getMultiplier() { 
        return theMultiplier;
    }
    
     public void act() {
        spawner();
        showFinalScores();
    }
    
    public void spawner() {
        if (Greenfoot.getRandomNumber(300) < 1) {//centre only
            addObject(new Ground(), 800, Greenfoot.getRandomNumber(600)+200);
        }
        
        if (Greenfoot.getRandomNumber(50) < 1) {//centre only
            addObject(new LargeBuilding(), 800, Greenfoot.getRandomNumber(600)+500);
        }
        
        if (Greenfoot.getRandomNumber(400) < 1) {//centre only
            addObject(new StreetCred(), 800, Greenfoot.getRandomNumber(400));
        }
        
        if (Greenfoot.getRandomNumber(400) < 1) {//centre only
            addObject(new EnemyBird(), 800, Greenfoot.getRandomNumber(500));
        }
    }
    
   public void initialSpawner() {
        addObject(new LargeBuilding(), 150, 600);
        addObject(new LargeBuilding(), 500, 550);
        addObject(new LargeBuilding(), 700, 700);
        addObject(new LargeBuilding(), 1000, 650);
        addObject(new LargeBuilding(), 1500, 500);
        addObject(new Hark(), 125, 400);
        
    }
}
