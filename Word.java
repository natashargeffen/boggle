import java.util.List;
//Represents a word entered by the user.
public class Word
{
   private char [] characters; //array of characters
   private int points; //points letter is worth

   /**
 The constructor excepts a list of tiles 
 and determines the amount of points each letter
 is worth.
 @param tiles The tiles on the board selected by user.
  */
   public Word(List<Tile> tiles, int points)
   {
      characters = new char [tiles.size()]; 
      //adds tiles to character array
      for(int i=0;i<tiles.size();i++)
      {
         characters[i] = tiles.get(i).getLetter();
      }
      
      this.points = points;
      
   }
      //determines user points based on word length
  public int getPoints(String str)
      {
       switch (str.length())
         {
            case 0:
               points = 0;
               break;
               
            case 1: //if word is 1 tile long
               points = 0;
               break;
               
            case 2: //if word is 2 tiles long
               points = 0;
               break;
               
            case 3: //if word is 3 tiles long
               points = 1;
               break;
               
            case 4: //if word is 4 tiles long
               points = 1;
               break;
               
            case 5: //if word is 5 tiles long
               points = 2;
               break;
           
            case 6: //if word is 6 tiles long
               points = 3;
               break;
               
            case 7: //if word is 7 tiles long
               points = 5;
               break;
               
            default: //if word is 8 tiles long or longer
               points = 11;
               break;
            }
         return points;
         }
         
      
      

   /**
   The getCharacters method returns the characters
   in the word.
   @return Characters in the word. 
   */
   public char[] getCharacters()
   {
      return characters;
   }
   
   /**
   The getPoints method returns the amount of points
   the letters in the word are worth.
   @return Amount of points letters are worth. 
   */
  //  public int getPoints()
//    {
//       return points;
//    }
//    
   /**
   The toString method returns the characters
   in the word as a string.
   @return Characters in the word as a string. 
   */
   @Override
   public String toString()
   {
      String str = ""; //empty string
      for (char i:characters)
      {
         if(i == 'q') //add qu to string if letter is q
            str += "qu";
         else
            str += i; //add letter to string
      }
      return str;
   }
   
//   public boolean equals(String word1, String word2)
//       {
//       if(word1.equals(word2))
//          return true;
//        else
//          return false;
//       }

}