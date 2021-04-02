import java.util.Scanner;

public class GuessWord
{
   public static void main(String[] args)
   {
       Scanner scnr = new Scanner(System.in);
       System.out.println("Enter your Player name: ");
       String playerName = scnr.nextLine();
       Player player = new Player(playerName); 
       
       System.out.println("Welcome " + playerName + " !");
       Game game = new Game(player);
       
       game.play();
       
   }
}
