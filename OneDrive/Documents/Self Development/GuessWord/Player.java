
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    String name; 
    int livesLeft;
    public Player(String newName)
    {
        name = newName;
        livesLeft = 3;
    }
    
    public void loseLife()
    {
        livesLeft--;
    }
    
    public int getLivesLeft()
    {
        return livesLeft;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void print()
    {
        System.out.println("You have " + livesLeft + " lives left!");
    }
}
