import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class FinalScoreCounter  extends Actor
{
    public static final float FONT_SIZE = 36.0f;
    public static final int WIDTH = 36;
    public static final int HEIGHT = 36;
    public int finalScore = 0;
    
    public void act() {
        finalRanking();
        showFinalScore();
    }
    
    public FinalScoreCounter()
    {
        //GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        setImage(new GreenfootImage("0", 36, Color.WHITE, new Color(255, 255, 255, 100 )));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.setTransparency(170);
    }
    
    public void finalRanking() {
        CityWorld CityWorld = (CityWorld) getWorld();
        Counter counter = CityWorld.getCounter();
        Multiplier multiplier = CityWorld.getMultiplier();
        finalScore = (counter.totalCountCred/10)*(multiplier.totalMultiplier);
    }
    
    
        /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    
    
    
    public void showFinalScore() {
        setImage(new GreenfootImage("" + (finalScore), 36, Color.WHITE, new Color(255, 255, 255, 100)));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.setTransparency(170);
    }
    
    

   }

