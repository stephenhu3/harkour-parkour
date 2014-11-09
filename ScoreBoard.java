import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
* The ScoreBoard is used to display results on the screen. It can display some
* text and several numbers.
*
* @author M Kolling
* @version 1.0
*/
public class ScoreBoard extends Actor
{
public static final float FONT_SIZE = 12.0f;
public static final int WIDTH = 145;
public static final int HEIGHT = 46;

/**
* Create a score board for the final result.
*/
public ScoreBoard()
{
makeImage("|Street Cred Ranking|", "Respect: ", "Street Cred Multiplier:");
}

/**
* Make the score board image.
*/
private void makeImage(String title, String prefix, String multiplier)
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
image.drawString(title, 8, 15);
image.drawString(prefix, 8, 27);
image.drawString(multiplier, 8, 39);
image.setTransparency(190);
setImage(image);
}
}