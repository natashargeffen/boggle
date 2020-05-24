//Represents one tile on the board.
public class Tile
{
   private char letter; //Letter on the tile
   private int row; //Row that the tile is in
   private int column; //Column that the tile is in
   private boolean selected;//Whether the tile was selected by selected
   
    /**
 The constructor sets the letter to a character, the row and
 column to integers, and selected to false.
 @param letter The letter on the tile.
 @param row The row that the tile is in.
 @param column The column that the tile is in.
  */
   public Tile(char letter, int row, int column)
   {
      //sets letter on tile
      this.letter = letter;
      //sets row of tile
      this.row = row;
      //sets column of tile
      this.column = column;
      //sets selected to false
      selected = false;
   }
   
   public Tile()
   {
      //sets letter on tile
      letter = ' ';
      //sets row of tile
      int row = 0;
      //sets column of tile
      int column = 0;
      //sets selected to false
      selected = false;
   }
   
    /**
 The alternate constructor sets the letter to a string, 
 the row and column to integers, and selected to false.
 @param letter The letter on the tile.
 @param row The row that the tile is in.
 @param column The column that the tile is in.
  */
   public Tile(String letter, int row, int column)
   {
      //sets letter as a string
      this.letter = letter.charAt(0);
      //sets row of tile
      this.row = row;
      //sets column of tile
      this.column = column;
      //sets selected to false
      selected = false;
   }
   /**
   The toString method returns the letter as a string or
   Qu if the letter Q is entered.
   @return the letter as a string.
   @Return Qu if the letter is uppercase Q.
   @Return qu if the letter is lowercase q. 
   */
   @Override
   public String toString()
   {
      if (letter == 'q')
         return "qu";
      else if (letter == 'Q')
         return "Qu";
      else
         return Character.toString(letter);
   } 
   
    /**
   The setLetter method sets the letter on the tile.
   @param letter The letter on the tile. 
   */
   public void setLetter(char letter)
   {
      this.letter = letter;
   }
   
   /**
   The alternativesetLetter method sets the 
   letter on the tile as a string.
   @param letter The letter on the tile. 
   */
   public void setLetter(String letter)
   {
      this.letter = letter.charAt(0);
   }

   /**
   The setRow method sets the row that the tile
   is in.
   @param row The row that the tile is in. 
   */
   public void setRow(int row)
   {
      this.row = row;
   }
   
   /**
   The setColumn method sets the column that the tile
   is in.
   @param column The column that the tile is in. 
   */
   public void setColumn(int column)
   {
      this.column = column;
   }
   
   /**
   The setSelected method sets the tile selection as true.
   @param selected Whether the tile is selected by the user. 
   */
   public void setSelected(boolean selected)
   {
      this.selected = selected;
   }
   
   /**
   The getLetter method returns the letter on the tile.
   @return The letter on the tile. 
   */
   public char getLetter()
   {
      return letter;
   }
   
   /**
   The getRow method returns the row that the tile is in.
   @return The row that the tile is in. 
   */
   public int getRow()
   {
      return row;
   }
   
   /**
   The getColumn method returns the column that 
   the tile is in.
   @return The column that the tile is in. 
   */
   public int getColumn()
   {
      return column;
   }
   
   /**
   The getSelected method returns true if the tile
   is selected by the user and false otherwise.
   @return True if tile is selected. 
   @return False if tile is not selected.
   */
   public boolean getSelected()
   {
      return selected;
   }
   
}