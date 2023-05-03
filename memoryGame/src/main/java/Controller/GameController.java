
package Controller;

import Model.Card;
import Model.AppContext;
import Model.Player;
import com.mycompany.memorygame.App;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * FXML Controller class
 *
 * @author jumac
 */
public class GameController implements Initializable {

    private int [][] tableGame;
    Card[][] cardsList = new Card[0][0];
    private Random randomNumber;
    Player player = (Player) AppContext.getInstance().get("player1");
    Player player2 = (Player) AppContext.getInstance().get("player2");
   
    @FXML
    private Label txtPlayer;
    @FXML
    private Label txtPlayerScore;  
    @FXML
    private GridPane table;
    @FXML
    private Label txtPlayer1;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadDifficulty();
        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setPlayersName();
        
    } 
    
    void setPlayersName(){
        txtPlayer.setText(player.getName());
    }
    
    void setPlayersScore(){
        txtPlayerScore.setText(String.valueOf(player.getScore()));
    }
    
    void loadDifficulty() throws IOException{
        if (AppContext.getInstance().get("diffuculty") == "Facil"){
            loadTableGame(4, 4,8);
        }
        if (AppContext.getInstance().get("diffuculty") == "Normal"){
            loadTableGame(6, 6,18);
        }
        if (AppContext.getInstance().get("diffuculty") == "Dificil"){
            loadTableGame(8, 8,32);
        }
    }

    public void loadTableGame(int aRows, int aColumns, int anAmmountCards) throws IOException {
        tableGame = new int [aRows][aColumns];
        randomNumber = new Random();
        int cont;
        for(int i=0;i<aRows;i++){
            for(int j=0;j<aColumns;j++){
                tableGame[i][j] = randomNumber.nextInt(anAmmountCards)+1;
             
                do{
                    cont = 0;
                    for(int n=0;n<aRows;n++){
                        for(int m=0;m<aColumns;m++){
                            if(tableGame[i][j] == tableGame[n][m]){
                                cont++;
                            }
                        }
                    }
                    if(cont > 2){
                        tableGame[i][j] = randomNumber.nextInt(anAmmountCards)+1;
                    }
                }
                while(cont > 2); 
            } 
        }
        loadCards(aRows, aColumns);
    }
    
    void loadCards(int aRows, int aColumns) throws IOException {
        int cardSize = 170;
        if (aRows == 6){
            cardSize = 110;
        }
        if (aRows == 8){
            cardSize = 85;
        }
        
        String[][] tableGameStr = new String[aRows][aColumns];
        Image backImage = new Image("images/cards/back.png"); 
        Image[][] imageList = new Image[aRows][aColumns];
        cardsList = new Card[aRows][aColumns];

        for (int i = 0; i < aRows; i++) {
            RowConstraints row = new RowConstraints();
            row.setPrefHeight(cardSize+5);
            row.setValignment(VPos.CENTER);
            table.getRowConstraints().add(row);
        }
        
        for (int i = 0; i < aColumns; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(cardSize+5);
            col.setHalignment(HPos.CENTER);
            table.getColumnConstraints().add(col);
        }
        
        table.getColumnConstraints().remove(0);
        table.getRowConstraints().remove(0);

        for(int i=0;i<aRows;i++){
            for(int j=0;j<aColumns;j++){
                if((boolean)AppContext.getInstance().get("wildcards") == true){
                    if(tableGame[i][j] == 1){
                        imageList[i][j] = new Image("images/cards/wildcard.png");
                    }
                    else{
                        imageList[i][j] = new Image("images/cards/"+tableGame[i][j]+".png");
                    }
                }else{
                    imageList[i][j] = new Image("images/cards/"+tableGame[i][j]+".png");
                }
                cardsList[i][j] = new Card(tableGame[i][j],backImage,imageList[i][j]);
                
                cardsList[i][j].setFitHeight(cardSize);
                cardsList[i][j].setFitWidth(cardSize);
                cardsList[i][j].setFitHeight(cardSize);
                cardsList[i][j].setFitWidth(cardSize);
                
      
                if((boolean)AppContext.getInstance().get("reviewMode") == true){
                    cardsList[i][j].flip(); 
                }
                
                
                table.add(cardsList[i][j], i, j); 
                
            }
        }
        flipCards(aRows, aColumns);
    }

    @FXML
    private void goBack(MouseEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("PRECAUCIÓN");
        alert.setContentText("\"Se perdera el progreso del juego\" \nDesea continuar:");
        ButtonType btnYes = new ButtonType("Si");
        ButtonType btnNo = new ButtonType("No");
        alert.getButtonTypes().setAll(btnYes,btnNo);
        Optional<ButtonType> option = alert.showAndWait();
        if(option.get() == btnYes){
            App.setRoot("mainScreen");
        }
        else{
            alert.close();
            
        }
        
    }
    private Card[] flippedCards = new Card[2];
    int couplesCounter = 0;
    void flipCards(int aRows, int aColumns) throws IOException{
        
        for(int i=0;i<aRows;i++){
            for(int j=0;j<aColumns;j++){
                Card card = cardsList[i][j];
                card.setOnMouseClicked(event ->{
                    if (flippedCards[0] == null) {
                        flippedCards[0] = card;
                        if(!flippedCards[0].isFlipped()){
                            card.flip();
                        }
                    } else if (flippedCards[1] == null) {
                        flippedCards[1] = card;
                        if(!flippedCards[1].isFlipped()){
                            card.flip();
                        }
                        if (flippedCards[0].getValue() != flippedCards[1].getValue() ) {
                            
                            if(!flippedCards[0].isFoundCouple() && !flippedCards[1].isFoundCouple()){
                            new java.util.Timer().schedule( 
                                new java.util.TimerTask() {
                                    @Override
                                public void run() {
                                    flippedCards[0].flip();
                                    flippedCards[1].flip();
                                    flippedCards[0] = null;
                                    flippedCards[1] = null;
                                    }
                                }, 
                            1000
                            );
                            
                            player.decreasePoints();
                            }
                            
                        } else {
                            if(!flippedCards[0].isFoundCouple() && !flippedCards[1].isFoundCouple()){
                                player.incrementarPuntos();
                                couplesCounter ++;
                                flippedCards[0].setFoundCouple(true);
                                flippedCards[1].setFoundCouple(true);      
                            }
                            flippedCards[0] = null;
                            flippedCards[1] = null; 
                        }
                       setPlayersScore(); 
                    }
                    if(couplesCounter == (aRows*aColumns)/2){
                        try {
                            MessageWinner();
                        } catch (IOException ex) {
                            
                        }
                }
                });  
                
            }
        }
        
    }

  void MessageWinner() throws IOException{
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Felicidades");
        alert.setContentText("\"Has terminado el juego\nTu Puntuacion es: "+player.getScore());
        ButtonType btnGoBackMainMenu = new ButtonType("Volver al Menu");
        alert.getButtonTypes().setAll(btnGoBackMainMenu);
        Optional<ButtonType> option = alert.showAndWait();
        if(option.get() == btnGoBackMainMenu){
            App.setRoot("mainScreen");
        }    
  }



}
