import java.util.ArrayList;
import java.util.Random;
//Represents the playing board with letters on it.

public class Board
{
   private ArrayList<ArrayList<Character>>dieList; //List of all die
   private ArrayList<Character> dice0; //a dice on board
   private ArrayList<Character> dice1; //a dice on board
   private ArrayList<Character> dice2; //a dice on board
   private ArrayList<Character> dice3; //a dice on board
   private ArrayList<Character> dice4; //a dice on board
   private ArrayList<Character> dice5; //a dice on board
   private ArrayList<Character> dice6; //a dice on board
   private ArrayList<Character> dice7; //a dice on board
   private ArrayList<Character> dice8; //a dice on board
   private ArrayList<Character> dice9; //a dice on board
   private ArrayList<Character> dice10; //a dice on board
   private ArrayList<Character> dice11; //a dice on board
   private ArrayList<Character> dice12; //a dice on board
   private ArrayList<Character> dice13; //a dice on board
   private ArrayList<Character> dice14; //a dice on board
   private ArrayList<Character> dice15; //a dice on board
   private ArrayList<ArrayList<Tile>>board; //List of all tiles on the board
   private final int NUM_COL = 4;
   private final int NUM_ROW = 4;
   private final int DICE_SIDES = 6;
   private final int NUM_TILES = 16;
   
   /**
 The Default constructor creates array lists for 
 of all the die on the board containing the letters on 
 each side of each dice and also creates an array list 
 of all the die array lists.
   */
   public Board()
   {
      //creates array list of array lists of die
      dieList = new ArrayList<>(NUM_TILES);
      
      //creates array list for one dice
      dice0 = new ArrayList<>(DICE_SIDES);
      dice0.add('R');
      dice0.add('I');
      dice0.add('F');
      dice0.add('O');
      dice0.add('B');
      dice0.add('X');
      
      //adds dice to array list of all die
      dieList.add(dice0);
      
      //creates array list for one dice
      dice1 = new ArrayList<>(DICE_SIDES);
      dice1.add('I');
      dice1.add('F');
      dice1.add('E');
      dice1.add('H');
      dice1.add('E');
      dice1.add('Y');
      
      //adds dice to array list of all die
      dieList.add(dice1);
      
      //creates array list for one dice
      dice2 = new ArrayList<>(DICE_SIDES);
      dice2.add('D');
      dice2.add('E');
      dice2.add('N');
      dice2.add('O');
      dice2.add('W');
      dice2.add('S');
      
      //adds dice to array list of all die
      dieList.add(dice2);
      
      //creates array list for one dice
      dice3 = new ArrayList<>(DICE_SIDES);
      dice3.add('U');
      dice3.add('T');
      dice3.add('O');
      dice3.add('K');
      dice3.add('N');
      dice3.add('D');
      
      //adds dice to array list of all die
      dieList.add(dice3);
      
      //creates array list for one dice
      dice4 = new ArrayList<>(DICE_SIDES);
      dice4.add('H');
      dice4.add('M');
      dice4.add('S');
      dice4.add('R');
      dice4.add('A');
      dice4.add('O');
      
      //adds dice to array list of all die
      dieList.add(dice4);
      
      //creates array list for one dice
      dice5 = new ArrayList<>(DICE_SIDES);
      dice5.add('L');
      dice5.add('U');
      dice5.add('P');
      dice5.add('E');
      dice5.add('T');
      dice5.add('S');
      
      //adds dice to array list of all die
      dieList.add(dice5);
      
      //creates array list for one dice
      dice6 = new ArrayList<>(DICE_SIDES);
      dice6.add('A');
      dice6.add('C');
      dice6.add('I');
      dice6.add('T');
      dice6.add('O');
      dice6.add('A');
      
      //adds dice to array list of all die
      dieList.add(dice6);
      
      //creates array list for one dice
      dice7 = new ArrayList<>(DICE_SIDES);
      dice7.add('Y');
      dice7.add('L');
      dice7.add('G');
      dice7.add('K');
      dice7.add('U');
      dice7.add('E');
      
      //adds dice to array list of all die
      dieList.add(dice1);
      
      //creates array list for one dice
      dice8 = new ArrayList<>(DICE_SIDES);
      dice8.add('Q');
      dice8.add('B');
      dice8.add('M');
      dice8.add('J');
      dice8.add('O');
      dice8.add('A');
      
      //adds dice to array list of all die
      dieList.add(dice8);
      
      //creates array list for one dice
      dice9 = new ArrayList<>(DICE_SIDES);
      dice9.add('E');
      dice9.add('H');
      dice9.add('I');
      dice9.add('S');
      dice9.add('P');
      dice9.add('N');
      
      //adds dice to array list of all die
      dieList.add(dice9);
      
      //creates array list for one dice
      dice10 = new ArrayList<>(DICE_SIDES);
      dice10.add('V');
      dice10.add('E');
      dice10.add('T');
      dice10.add('I');
      dice10.add('G');
      dice10.add('N');
      
      //adds dice to array list of all die
      dieList.add(dice10);
      
      //creates array list for one dice
      dice11 = new ArrayList<>(DICE_SIDES);
      dice11.add('B');
      dice11.add('A');
      dice11.add('L');
      dice11.add('I');
      dice11.add('Y');
      dice11.add('T');
      
      //adds dice to array list of all die
      dieList.add(dice11);
      
      //creates array list for one dice
      dice12 = new ArrayList<>(DICE_SIDES);
      dice12.add('E');
      dice12.add('Z');
      dice12.add('A');
      dice12.add('V');
      dice12.add('N');
      dice12.add('D');
      
      //adds dice to array list of all die
      dieList.add(dice12);
      
      //creates array list for one dice
      dice13 = new ArrayList<>(DICE_SIDES);
      dice13.add('R');
      dice13.add('A');
      dice13.add('L');
      dice13.add('E');
      dice13.add('S');
      dice13.add('C');
      
      //adds dice to array list of all die
      dieList.add(dice13);
      
      //creates array list for one dice
      dice14 = new ArrayList<>(DICE_SIDES);
      dice14.add('U');
      dice14.add('W');
      dice14.add('I');
      dice14.add('L');
      dice14.add('R');
      dice14.add('G');
      
      //adds dice to array list of all die
      dieList.add(dice14);
      
      //creates array list for one dice
      dice15 = new ArrayList<>(DICE_SIDES);
      dice15.add('P');
      dice15.add('A');
      dice15.add('C');
      dice15.add('E');
      dice15.add('M');
      dice15.add('D');
      
      //adds dice to array list of all die
      dieList.add(dice15);
     
      //creates random object
      Random rand = new Random();
      
      //create board
      board = new ArrayList<>(NUM_ROW);

      for (int row=0; row<NUM_ROW; row++)
      {
         //creates array lists of rows
         ArrayList<Tile>rowList = new ArrayList<>(NUM_COL);

         for (int col = 0; col<NUM_COL; col++)
         {  
            //creates array lists of columns
            ArrayList<Character>die = dieList.remove(rand.nextInt(dieList.size()));
            //removes letter from array list so it cannot be reselected.
            char letter = die.remove(rand.nextInt(die.size())); 
            rowList.add(new Tile(letter,row,col));
            
         }
      //adds each row to board array list
      board.add(rowList);
      }
  
   }
   /**
   The getBoard method returns the playing board.
   @return The playing board.
   */
   public ArrayList<ArrayList<Tile>> getBoard()
      {
      return board;
      }
   
   /**
   The toString method returns the playing board
   as a string.
   @return str The playing board as a string.
   */    
   public String toString()
      {
      String str = ""; //creates empty string
      //adds letters on board to string
      for (int row=0; row<NUM_ROW; row++)
         {
         for (int i=0; i<board.size(); i++)
            {
            str += (board.get(row).get(i).toString()) + " ";
            }
            str += "\n";
            
         }
      return str;
      }
       /**
   The getTile method returns the row and column
   of a tile.
   @return tile A tile on the playing board.
   */ 
      public Tile getTile(int row, int col)
      {
         Tile tile = board.get(row).get(col);
         
         return tile;
      }

   
   
}

