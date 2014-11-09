import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class FinalScoreRespect  extends Actor
{
    public static final float FONT_SIZE = 36.0f;
    public static final int WIDTH = 36;
    public static final int HEIGHT = 36;
    
    public void act() {
        showFinalRespect();
    }
    
   
        /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    
    
    
    public void showFinalRespect() {
        CityWorld CityWorld = (CityWorld) getWorld();
        Counter counter = CityWorld.getCounter();
        setImage(new GreenfootImage("" + (counter.totalCountCred), 36, Color.WHITE, new Color(255, 255, 255, 100)));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.setTransparency(170);
    }
    
   }

