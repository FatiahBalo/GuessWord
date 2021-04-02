import java.io.*;
import java.util.Scanner; 

public class Game
{
   String fileName; 
   Dict dictionary;
   Player player;
   int wordLen;
   char[] chars; //this array holds the characters of the word to be guessed
   int cnt = 0; 
   Game(Player newPlayer)
   {
       player = newPlayer;
       Scanner scnr = new Scanner(System.in);
       System.out.println("Enter the name of the dictonary file with .txt: ");
       fileName = scnr.nextLine();
       
       dictionary = new Dict(fileName); //creates a new Dict object using user input
   }
   
   public void play()
   {
       String wrd = dictionary.getGuessWord(0);
       wordLen = wrd.length();
       chars = wrd.trim().toCharArray(); //this is the chars array, this is the original word being guessed
       String temp;
       char[] guess = new char[wordLen]; // this char array holds the entries by the user
       System.out.println(print(guess));
       //this chunk of code allows the user to continue entering letters and checks if the letter has already been entered
       //
       do
       {
           System.out.println("Enter you guess character:");
           Scanner scnr = new Scanner(System.in);
           temp = scnr.nextLine();
           
           char chrs = temp.toLowerCase().charAt(0);
           if(checkChar(chrs) != 0) // this checks if the guessed char is part of the word to be guessed
           {
               int charcnt = checkChar(chrs);
               int[] spot = charSpot(chrs, charcnt);
               for (int i = 0; i<spot.length; i++)
               {
                   if(guess[spot[i]] !='\u0000')
                   {
                       System.out.println("The letter has been entered previously");
                       player.loseLife(); player.print();
                   }
                   else
                   {
                       guess[spot[i]] = chrs;
                   }
               }
           }
           else
           {
               System.out.println("Letter not present in word, enter another letter");
               player.loseLife(); player.print();
           }
           System.out.println(print(guess));
       }while (temp != null && !checkWord(guess) && player.getLivesLeft() !=0);
       
       
       if(!checkWord(guess) && player.getLivesLeft() ==0)
       {
           System.out.println("You did not guess the word correctly. The correct word is " + print(chars));
       }
       else
       {
           System.out.println("Congratulations, " + player.getName() + " ! You guessed the correct word.");
       }
   }
   
   private int[] charSpot(char toCheck, int charcnt)
   {
       int[] spot;
       int temp = 0;
       spot = new int[charcnt];
       for(int cnt =0; cnt<chars.length; cnt++)
       {
           if(toCheck == chars[cnt])
           {
               spot[temp] = cnt;
               temp++;
           }
       }
       return spot;
   }
   
   private int checkChar(char toCheck)
   {
       int charcnt = 0;
       for(int cnt =0; cnt<chars.length; cnt++)
       {
           if(toCheck == chars[cnt])
           {
               charcnt++;
           }
       }
       return charcnt;
   }
   
   //this private method checks if all the characters in the word have been guessed
   //this is a termination condition in the while loop in the play method
   private boolean checkWord(char[] charAry)
   {
       boolean wrdGesd = true;
       int real = 0;
       int entrd = 0;
       for(int num =0; num<charAry.length && wrdGesd; num++)
       {
           if(chars[num] != charAry[num]){wrdGesd = false;}
       }
       return wrdGesd;
   }
   
   private String print(char[] charAry)
   {
       String output = "";
       for (int i =0; i<charAry.length; i++)
       {
           if(charAry[i] == '\u0000')
           {
               output += "_ ";
           }
           else
           {
               output += charAry[i] + " ";
           }
       }
       return output;
   }
   
   
}
