//Natasha Geffen
//CS 21
//Boggle Phase III


import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint; 
import javafx.scene.text.Text;
import javafx.scene.text.Font;

//A board that displays a specified amount of letter tiles
public class TilePane extends HBox
{
   //initialize variables
   private Tile tile; //tile on board
   
   /**
 The constructor initializes tile and sets the board's alignment,
 size, style, and text on tiles.
  */
   public TilePane(Tile tile)
   {
      super();
      
      this.tile = tile;
      
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(100,100);
      this.setStyle("-fx-border-width: 5;"
                        +"-fx-border-color: black;");
      Text letter = new Text(tile.toString());
      letter.setFont(Font.font("Arial",40));
      this.getChildren().add(letter);

   }
  /**
 The getTile method returns a tile
 @return tile Tile on board.
   */
   public Tile getTile()
   {
      return tile;
   }
   /**
 The setTile method sets the letter of the tile.
 @param tile Tile on board.
  */
   public void setTile(Tile tile)
   {
       this.getChildren().clear();  // erase old circles
       Text letter = new Text(tile.toString());
       letter.setFont(Font.font("Arial",40));
       this.getChildren().add(letter);
      
   }
   /**
 The setSelected method changes the color of selected tiles.
  */
   public void setSelected()
   {
       String style = "-fx-background-color: rgba(0,255,0,0.3);";
       this.setStyle(style);

   }
   
   /**
 The setSelected method changes the color of unselected tiles back to 
 the default colors.
  */
   public void setUnselected()
   {
      String style = "-fx-background-color: rgba(255,255,255,0.5);" +
                     "-fx-border-width: 5;"+"-fx-border-color: black;";
       this.setStyle(style);
   }

}