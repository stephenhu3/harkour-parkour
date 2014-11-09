import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class FinalScore extends Actor
{
public static final float FONT_SIZE = 36.0f;
public static final int WIDTH = 400;
public static final int HEIGHT = 300;
/*public void act() {
    showTotalCred();
}*/

/**
* Create a score board for the final result.
*/
public FinalScore()
{
makeImage("|Final Ranking|", "Respect: ", "Street Cred Multiplier:", "FINAL SCORE: ");
        //GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        /*setImage(new GreenfootImage("0", 16, Color.WHITE, new Color(255, 255, 255, 100 )));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.setTransparency(170);*/
}

/**
* Make the score board image.
*/
private void makeImage(String title, String prefix, String multiplier, String finalScore)
{
GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

image.setColor(new Color(0, 174, 204, 160));//BLACK/WHITE MAKE IT BLUE
image.fillRect(0, 0, WIDTH, HEIGHT);
image.setColor(new Color(255, 225, 255, 100));
image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
Font font = image.getFont();
font = font.deriveFont(FONT_SIZE);
image.setFont(font);
image.setColor(Color.WHITE);
image.drawString(title, 8, 35);
image.drawString(prefix, 8, 83);
image.drawString(multiplier, 8, 131);
image.drawString(finalScore, 8, 179);
image.setTransparency(190);
setImage(image);

}

}