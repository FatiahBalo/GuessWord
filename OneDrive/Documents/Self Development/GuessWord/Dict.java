import java.io.*;
import java.util.Scanner;
public class Dict
{
    String[] wordArray; 
    int count;
    Dict(String fileName)
    {
        wordArray = new String[10];
        readFile(fileName);
        randomize();
        //System.out.println("All Done"); //comment out later
    }
    
    private void readFile(String filename)
    {
        String tempLine;
        Scanner line;
        try
        {
            FileReader fileLine = new FileReader(filename);
            BufferedReader buff = new BufferedReader(fileLine);
            while((tempLine = buff.readLine())!= null)
            {
                String wrd = tempLine;
                if(count < wordArray.length)
                {
                    wordArray[count] = wrd.toLowerCase();
                    count++;
                }
                else 
                {
                    copy();
                    //System.out.println("Array resize successful"); //comment out later
                }
            }
        }
        catch(IOException exception)
        {
            System.out.println("Error reading in file");
        }
    } 
    
    private void copy()
    {
        String[] temp = new String[(count+1)*2];
        for(int num = 0; num<count; num++)
        {
            temp[num] = wordArray[num];
        }
        wordArray = temp;
    }
    
    private void randomize()
    {
       int index;
       String[] temp = new String[count];
       for(int num = 0; num < count; num++)
       {
           index = (int)Math.floor(Math.random() * count);
           while(!indexCheck(wordArray[index], num, temp))
           {
               index = (int)Math.floor(Math.random() * count);
           }
           temp[num] = wordArray[index];
        }
       wordArray = temp;
    }
   
    private boolean indexCheck(String word, int spot, String[] array)
    {
       boolean notRcrded = true;
       for (int num = 0; num <= spot&& notRcrded; num++)
       { 
           if(array[num] == word)
           {
               notRcrded = false;
           }
       }
       return notRcrded;
    }
    
    public String getGuessWord(int indx)
    {
       return wordArray[indx]; 
    }
}