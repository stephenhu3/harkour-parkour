import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class Multiplier  extends Actor
{
    public int totalMultiplier = 1;
    public static final float FONT_SIZE = 12.0f;
    public static final int WIDTH = 12;
    public static final int HEIGHT = 12;
    
    int victoryTimer = 0;
    int endWinTimer = 1;
    public void act() {
        //victory();
        //bumpMultiplier(1);
    }
    
    public Multiplier()
    {
        //GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        setImage(new GreenfootImage("1", 16, Color.WHITE, new Color(255, 255, 255, 100 )));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.setTransparency(170);
    }

    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpMultiplier(int amountMultiplier) {
        totalMultiplier += amountMultiplier;
        
        //GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        
        setImage(new GreenfootImage("" + (totalMultiplier), 16, Color.WHITE, new Color(255, 255, 255, 100)));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.setTransparency(170);
    }
    
   }

