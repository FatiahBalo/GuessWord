import java.io.*;
import java.util.Scanner; 

public class Game
{
   String fileName; 
   Dict dictionary;
   int wordLen;
   char[] chars;
   int charcnt = 0;
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
       chars = wrd.toCharArray(); //this is the chars array, this is the original word being guessed
       char[] trackr = new char[wordLen]; // this char array holds the entries by the user
       //int cnt = 0;
       String temp;
       Scanner scnr = new Scanner(System.in);
       System.out.println("Enter you guess letter:");
       temp = scnr.nextLine();
       
       //this chunk of code allows the user to continue entering letters and checks if the letter has already been entered
       //
       while (temp != null)
       {
           char chrs = temp.toLowerCase().charAt(0);
           if(checkChar(chrs)) // this checks if the guessed char is part of the word to be guessed
           {
               if(charcnt <= wordLen) //this checks if the number of times guessed is less that the length of the word
               {
                   if(checkChar(chrs, trackr)) //this checks if the letter has already been entered before
                   {System.out.println("The letter has been entered previously");}
                   else //if character hasn't been entered before add the character to the tracking array
                   {
                       trackr[cnt] = chrs;
                       cnt++;
                   }
               }
           }
           else
           {
               System.out.println("Letter not present in word, enter another letter");
               scnr = new Scanner(System.in);
               temp = scnr.nextLine();
           }
       }
       
   }
   
   private boolean checkChar(char toCheck)
   {
       boolean charPres = false;
       for(int cnt =0; cnt<chars.length; cnt++)
       {
           if(toCheck == chars[cnt])
           {
               charcnt++;
               charPres = true;
           }
       }
       return charPres;
   }
   
   private boolean checkChar(char toCheck, char[] charAry)
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
   }
   
   //this private method checks if all the characters in the word have been guessed
   //this is a termination condition in the while loop in the play method
   private boolean checkWord(char[] charAry)
   {
       boolean wrdGesd = false;
       int real = 0;
       int entrd = 0;
       for(int num =0; num<cnt; num++)
       {entrd += (int) charAry[num];}
       
       for(int num =0; num<wordLen; num++)
       {real += (int) chars[num];}
       
       if(real == entrd)
       { wrdGesd = true;}
       return wrdGesd;
   }
}
