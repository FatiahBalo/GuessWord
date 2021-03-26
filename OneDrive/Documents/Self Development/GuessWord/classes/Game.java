import java.io.*;
import java.util.Scanner; 

public class Game
{
   String fileName; 
   Dict dictionary;
   int wordLen;
   char[] chars;
   //int charcnt = 0; //number of times a character appears in a word. NOTE THIS WOULD KEEP ON INCREASING
   int cnt = 0; 
   Game()
   {
       Scanner scnr = new Scanner(System.in);
       System.out.println("Enter the name of the dictonary file with .txt: ");
       fileName = scnr.nextLine();
       
       dictionary = new Dict(fileName);
   }
   
   public void play()
   {
       String wrd = dictionary.getGuessWord(0);
       wordLen = wrd.length();
       chars = wrd.trim().toCharArray(); //this is the chars array, this is the original word being guessed
       //char[] trackr = new char[wordLen]; // this char array holds the entries by the user
       //int cnt = 0;
       //String temp;
       Scanner scnr = new Scanner(System.in);
       System.out.println("Enter you guess character:");
       String temp = scnr.nextLine();
       char[] guess = new char[wordLen]; // this char array holds the entries by the user
       //this chunk of code allows the user to continue entering letters and checks if the letter has already been entered
       //
       while (temp != null && !checkWord(guess))
       {
           char chrs = temp.toLowerCase().charAt(0);
           if(checkChar(chrs) != 0) // this checks if the guessed char is part of the word to be guessed
           {
               /*if(charcnt <= wordLen) //this checks if the number of times guessed is less that the length of the word
               {
                   if(checkChar(chrs, trackr)) //this checks if the letter has already been entered before
                   {System.out.println("The letter has been entered previously");}
                   else //if character hasn't been entered before add the character to the tracking array
                   {
                       trackr[cnt] = chrs;
                       cnt++;
                   }
               }*/
               int charcnt = checkChar(chrs);
               int[] spot = charSpot(chrs, charcnt);
               for (int i = 0; i<spot.length; i++)
               {
                   if(guess[spot[i]] !='\u0000')
                   {System.out.println("The letter has been entered previously");}
                   else
                   {
                       guess[spot[i]] = chrs;
                   }
               }
               
           }
           else
           {
               System.out.println("Letter not present in word, enter another letter");
               //scnr = new Scanner(System.in);
               //temp = scnr.nextLine();
           }
           System.out.println("Enter you guess character:");
           scnr = new Scanner(System.in);
           temp = scnr.nextLine();
       }
       
       /*char[] guess = new char[wordLen];
       if(checkChar(chrs))
       {
           int[] spot = charSpot(chrs);
           for (int i = 0; i<spot.length; i++)
           {
               if(guess[spot[i]] !='\u0000')
               {System.out.println("The letter has been entered previously");}
               else
               {guess[spot[i]] = chrs;}
           }
       }*/
       System.out.println("Done entries");
   }
   
   private int[] charSpot(char toCheck, int charcnt)
   {
       int[] spot;
       int count = 0;
       int temp = 0;
       /*for(int cnt =0; cnt<chars.length; cnt++)
       {
           if(toCheck == chars[cnt])
           {
               count++;
           }
       }*/
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
       //boolean charPres = false;
       int charcnt = 0;
       for(int cnt =0; cnt<chars.length; cnt++)
       {
           if(toCheck == chars[cnt])
           {
               charcnt++;
               //charPres = true;
           }
       }
       return charcnt;
   }
   
   /*private boolean checkChar(char toCheck, char[] charAry)
   {
       boolean charPres = false;
       for(int num =0; num<cnt; num++)
       {
           if(charAry.length > 1 && toCheck == charAry[num])
           {
               charPres = true;
           }
       }
       return charPres;
   }*/
   
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
}
