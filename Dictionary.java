import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
//Represents a dictionary of words. 
public class Dictionary 
{
   
   private ArrayList<String> wordList; //list of words
   /**
 The constructor excepts a filename and reads the words
 in the file into an array list.
 @param filename The name of the dictionary file.
  */
   public Dictionary(String filename)
   {
            
      
      //creates arraylist
      wordList = new ArrayList<String>();
      //opens dictionary file
      Scanner infile = null;
      try{
         infile = new Scanner(new File(filename));
         }
      catch(FileNotFoundException e)
         {
         System.out.println("error opening file");
         } 
      finally
         {
         } 
      //reads words from file into arraylist
      while(infile.hasNext())
         {
         String dict = infile.next();
         wordList.add(dict);
         }
      //closes file
      infile.close();
   }
     
   /**
 The isValidWord excepts a word, converts it to lowercase,
 and returns true if it is a valid word found in the dictionary
 file.
 @param word The word entered by the user.
 @return True if word is valid.
 @return False if word is invalid.
  */    
   public boolean isValidWord(ArrayList<Tile> word)
   { 
      String wordLower = ""; //empty string
      //if letter is q, convert it to qu. Otherwise, 
      //convert it to lowercase
      for (int i=0; i<word.size(); i++)
      {
         if ((word.get(i).toString()).toLowerCase().equals("q"))
            wordLower += "qu";
         else
            wordLower += (word.get(i).toString()).toLowerCase();
      }
      if (wordList.contains(wordLower))
      {
         return true;
      }
      
      else
      {
         return false;
      }
   }
}