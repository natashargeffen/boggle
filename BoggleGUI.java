//Natasha Geffen
//CS 21
//Boggle Phase III

//import
import javafx.application.Application; 
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.*;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class BoggleGUI extends Application
{  //initialize variables
   private Game game;  
   private GridPane grid;  
   private BorderPane mainPane;  
   private BorderPane wordList;
   private BorderPane exitPane;
   private VBox statusPane;  
   private Text status;
   private Text title;
   private Text yourWords;
   private Text words;
   private Text points;
   private Text exitText;
   private HBox buttonPane; 
   private Button exit, newGame, testWord;
   private Tile tile;
   private TilePane tp;
   

   
   @Override
   public void start(Stage primaryStage) {
      primaryStage.setTitle("Boggle");
      // set up panes
      mainPane = new BorderPane();
      mainPane.setPadding(new Insets(15, 12, 15, 12));
      grid = new GridPane();
      grid.setStyle("-fx-padding: 15;");
      //add word list
      wordList = new BorderPane();
      wordList.setPrefSize(200,200);
      // intialize game and draw board
      game = new Game();
      drawBoard(); 
      
      statusPane = new VBox();
      title = new Text("BOGGLE");
      yourWords = new Text("Your Words:");
      //add points tracker
      points = new Text("Points:" + game.getPoints()); 
      words = new Text(game.getValidWords());
      points.setFont(Font.font("Arial",24));
      yourWords.setFont(Font.font("Arial",24));
      title.setFont(Font.font("Arial",24));
      words.setFont(Font.font("Arial",16));
      statusPane.setAlignment(Pos.CENTER);
      status = new Text("");
      statusPane.getChildren().add(title);
      statusPane.getChildren().add(status);
      //lay everything out
      mainPane.setTop(statusPane);
      mainPane.setLeft(wordList);
      mainPane.setRight(grid);
      wordList.setTop(yourWords);
      wordList.setCenter(words);
      wordList.setBottom(points);
      //create button to end game
      buttonPane = new HBox(10);
      buttonPane.setAlignment(Pos.CENTER);
      exit = new Button("End Game");
      exit.setPadding(new Insets(15, 12, 15, 12));
      exit.setOnAction( new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            //exits game and displays user's points
            mainPane.getChildren().clear();
            exitPane = new BorderPane();
            exitText = new Text("Total Points: " + game.getPoints());
            exitText.setFont(Font.font("Arial",36));
            exitPane.setCenter(exitText);
            mainPane.setCenter(exitPane);
         }
       });
      buttonPane.getChildren().add(exit);
      //add new game button
      newGame = new Button("New Game");
      newGame.setPadding(new Insets(15, 12, 15, 12));
      newGame.setOnAction( new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            //starts new game when button is pressed
            game = new Game();
            drawBoard();
            status.setText("");
            words.setText("");
            points.setText("Points: 0");
            
         }
       });
      buttonPane.getChildren().add(newGame);
      
      //add button to test word
      testWord = new Button("Test Word");
      testWord.setPadding(new Insets(15, 12, 15, 12));
      testWord.setOnAction( new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            //if word is not valid, display message
            if (!game.testSelected())
               status.setText("Not a valid word.");
            else
               //if valid, add word to list and add points
               status.setText("");
               words.setText(game.getValidWords());
               game.clearSelected();
               drawBoard();
               points.setText("Points:" + game.getPoints());
         }
       });
      buttonPane.getChildren().add(testWord);
      
      mainPane.setBottom(buttonPane);
      // complete setup
      Scene scene = new Scene(mainPane);
      primaryStage.setScene(scene);
      primaryStage.show();
      
      
   }
   // event handler for user clicking on a square

   public void handleClick(MouseEvent e)
   {  
      TilePane tp = (TilePane)(e.getSource());
      Tile t = tp.getTile();
   //if tile is selected, display that it is selected
   if (t.getSelected() == true)
            {
            t.setSelected(false);
            tp.setUnselected();
            game.removeFromSelected(t.getRow(), t.getColumn());
            return;
            }
       
      if(game.isValidSelection(t.getRow(), t.getColumn()) == true)
      {
         status.setText("");
         //if unselected, display that tile not currently clicked
         if (t.getSelected() == false)
            {
            t.setSelected(true);
            tp.setSelected();
            game.addToSelected(t.getRow(), t.getColumn());
            }
         else
            {
            t.setSelected(false);
            tp.setUnselected();
            game.removeFromSelected(t.getRow(), t.getColumn());
            }
       
      }
      //only show invalid message when user clicks on wrong tile
      else
      {
         status.setText("Not a valid selection.");
         


         }
      }
         
      
   // using information from game, create cell panes
   public void drawBoard()
   {
      grid.getChildren().clear(); // clear the board
      for (int row = 0; row < 4;row++)
         {
         for (int col = 0; col < 4;col++)
         {  
            tp = new TilePane(game.getTile(row, col));
            tp.setOnMouseClicked(this::handleClick);
            tp.setUnselected();
            game.getTile(row, col).setSelected(false);
            
            // if (!game.isSquareUsed(r,c))
//                cp.setOnMouseClicked(this::handleClick);
            grid.add(tp,col,row);
         }
       }
            
   }
   public static void main(String [] args) {
      launch(args);
   }
}

