import java.lang.Math;
/**
 * Write a description of class WordStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordStack
{
   private int top;
   private String[] stack;
   private int[] intArray;
   WordStack(int stackSize)
   {
       stack = new String[stackSize];
       intArray = new int[stackSize];
   }
   
   private void push(String inWord)
   {
       stack[top] = inWord;
       top++;
   }
    
   private String pop()
   {
       String wrdRndm = stack[top];
       top--;
       return wrdRndm;
   }
   
   private void randomize(int maxSize, String[] dict)
   {
       int index = (int)Math.floor(Math.random()) * maxSize;
       while(!indexCheck(dict[index]))
       {
           index = (int)Math.floor(Math.random()) * maxSize;
       }
       push(dict[index]);
   }
   
   private boolean indexCheck(String word)
   {
       boolean notRcrded = true;
       for (int num = 0; num<top && notRcrded; num++)
       { 
           if(stack[num] == word)
           {
               notRcrded = false;
           }
       }
       return notRcrded;
   }
}
