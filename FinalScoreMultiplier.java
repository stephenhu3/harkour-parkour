import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class FinalScoreMultiplier  extends Actor
{
    public static final float FONT_SIZE = 36.0f;
    public static final int WIDTH = 36;
    public static final int HEIGHT = 36;
    
    public void act() {
        showFinalMultiplier();
    }
    
   
        /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    
    
    
    public void showFinalMultiplier() {
        CityWorld CityWorld = (CityWorld) getWorld();
        Multiplier multiplier = CityWorld.getMultiplier();
        setImage(new GreenfootImage("" + (multiplier.totalMultiplier), 36, Color.WHITE, new Color(255, 255, 255, 100)));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.setTransparency(170);
    }
    
    
    
   }

