//Natasha Geffen
//CS 110
//Boggle phase II

import java.util.ArrayList;
import java.io.*;
//This class represents a full game of boggle

public class Game
{
   private String input; //letter that user enters
   private int row; //row of letter
   private int col; //column of letter
   private boolean selected; //if letter was selected
   private boolean valid; //if letter selection is valid
   private ArrayList<Tile> selectedLetters; //list of selected words
   private ArrayList<String> validWords;//list of valid words user has guessed
   private Board board;//board object
   private Tile tile;//tile object
   private Dictionary dictionary;//dictionary object
   private Word word;//word object
   private int points;//number of points user has
   private final int NUM_ROW = 4; //number of columns
   private final int NUM_COL = 4; //mumber of rows
   
    /**
 The default constructor initializes integers to 0, booleans to
 false, creates new arraylists, and creates new objects.
  */
   public Game() 
   {
      row = 0;
      col = 0;
      points = 0;
      selected = false;
      valid = false;
      selectedLetters = new ArrayList<>();
      validWords = new ArrayList<>();
      board = new Board();
      tile = new Tile();
      dictionary = new Dictionary("dict.txt");
      word = new Word(selectedLetters, points);
   
   }
   
    /**
 The constructor accepts a value for selected, row, col, and valid, and creates
 arraylist objects. It sets booleans equal to false, and sets values for other 
 variables.
 
   @param row; Row of letter.
   @param col Column of letter.
   @param selected If letter was selected.
   @param valid If letter selection is valid.
   @param selectedLetters List of selected words.
   @param validWords List of valid words user has guessed.
   @param board Board object.
   @param tile Tile object.
   @param dictionary Dictionary object.
   @param word Word object.
   @param points Number of points user has.
 
  */
   public Game(boolean selected, int row, int col, boolean valid, ArrayList<Tile> selectedLetters, ArrayList<Tile> validWords, Board board, Tile tile, Dictionary dictionary, Word word, int points) throws IOException  
   {
      
      this.row = row;
      this.col = col;
      this.selected = false;
      this.valid = false;
      selectedLetters = new ArrayList<>();
      validWords = new ArrayList<>();
      this.board = board;
      this.tile = tile;
      this.dictionary = dictionary;
      this.word = word;
      this.points = points;
   }
   
   /**
 The equalsIgnoreCase method makes the letter that the user
 enters case-insensitive.
 @param input User's input.
 @return inputLowercase Letter as lowercase.
  */
   public String equalsIgnoreCase(String input)
   {
      String inputLowercase = input.toLowerCase();
      return inputLowercase;
   }
   
   
   /**
 The isValidSelection method determines whether a selection
 is valid.
 @param row Row of tile.
 @param col Column of tile.
 @return valid True if selection is valid, false otherwise.
  */
   public boolean isValidSelection(int row, int col)
      {
         valid = true;
         if((row<NUM_ROW)&&(col<NUM_COL)&&(row>=0)&&(col>=0))
         {
            if (!selectedLetters.isEmpty())
               {
                  Tile lastTile = selectedLetters.get(selectedLetters.size() - 1);
         
                  if ((row == lastTile.getRow()-1) && (col == lastTile.getColumn()))
                     valid = true;
                  else if ((row == lastTile.getRow() + 1) && (col == lastTile.getColumn()))
                     valid = true;
                  else if ((row == lastTile.getRow() - 1) && (col == lastTile.getColumn()-1)) 
                     valid = true; 
                  else if ((row == lastTile.getRow() + 1) && (col == lastTile.getColumn()-1)) 
                     valid = true;
                  else if ((row == lastTile.getRow() - 1) && (col == lastTile.getColumn()+1)) 
                     valid = true; 
                  else if ((row == lastTile.getRow() + 1) && (col == lastTile.getColumn()+1)) 
                     valid = true; 
                  else if ((col == lastTile.getColumn() - 1) && (row == lastTile.getRow()))
                     valid = true;
                  else if ((col == lastTile.getColumn() + 1) && (row == lastTile.getRow())) 
                     valid = true;
                  else
                     valid = false;        
               }
           } 
          else
            {
            valid = false; 
            }
           
            
         return valid;       
   }
   
   /**
 The getSelectedTiles method returns a list of the selected tiles.
 @return selectedTiles List of selectedTiles.
  */
   public ArrayList<Tile> getSelectedTiles()
   {
      return selectedLetters;
   }
   
   
   /**
 The removeFromSelected method removes a specified letter from the list
 of selected letters.
 @param row The row of the tile.
 @param col The column of the tile.
  */
   public void removeFromSelected(int row, int col)
   {
      Tile t = board.getTile(row, col);
      selectedLetters.remove(t);
   }
    /**
 The addToSelected method adds a specified letter to the list
 of selected letters.
 @param row The row of the tile.
 @param col The column of the tile.
  */
   public void addToSelected(int row, int col)
   {
      Tile t = board.getTile(row, col);
      selectedLetters.add(t);   
   }
   
  
    /**
 The getBoard method returns the board.
 @return board The playing board.
  */
   public Board getBoard()
   {
      return board;
   }
    /**
 The getBoard method accepts a row and 
 column and returns the corresponding tile.
 @param row The row of the tile.
 @param col The column of the tile.
 @return tile A tile playing board.
  */
    public Tile getTile(int row, int col)
      {
         Tile tile = board.getTile(row, col);
         
         return tile;
      }
    /**
 The clearSelected method clears the list
 of selected letters.
  */
   public void clearSelected()
   { 
      selectedLetters.clear();
   }
    /**
 The testSelected method tests whether the letters
 in the list of selected letters make up a valid word.
 @return True if it is a valid word, false otherwise.
  */
   public boolean testSelected()
   {
      
      String strValidWord = "";
      if(dictionary.isValidWord(selectedLetters) && selectedLetters.size()>2)
      {
         
         for (int i=0;i<selectedLetters.size();i++)
            {
            strValidWord += selectedLetters.get(i);
            
            }
        
         
         if(!validWords.contains(strValidWord))
            {

            points += word.getPoints(strValidWord);
            validWords.add(strValidWord.toUpperCase());
            selectedLetters.clear();
            }
         return true;
         
         }
      else
         {
         return false;
         }
   }
   
    /**
 The tostring method returns the board, the selected letters,
 the valid words that the user has guessed, and the number of points
 the user has a string.
 @return str String displaying the board, valid guessed words, the
 selected letters, and the number of points.
  */
   
   @Override
   public String toString()
   {
       String boardStr = ""; 
       
       for (int row=0; row<NUM_ROW; row++)
         {
         for (int col=0; col<board.getBoard().size(); col++)
            {
            boardStr += (board.getBoard().get(row).get(col).toString()) + " ";
            }
         boardStr += "\n";
         }
   
      String selectedStr = "\nSelected: "+selectedLetters;
      
      String scoreStr = "\nScore: "+points;
      String wordsStr = "\nWords: "+validWords;

      String str = boardStr + selectedStr + wordsStr + scoreStr;
      return str;
   }
   
   
   public String getValidWords()
   {
       String listOfWords = "";
       for (int i=0;i<validWords.size();i++)
            {
            
            listOfWords += "\n"+ validWords.get(i);
            
            
            }
            return listOfWords;

   }
   
   public int getPoints()
   {
      return points;
   }
   
}
