
package Controller;

import Model.Card;
import Model.Player;
import Model.AppContext;
import com.mycompany.memorygame.App;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Random randomNumber;
   
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
        updateDifficulty();
        setPlayersName();
    } 
    
    void setPlayersName(){
        txtPlayer.setText((String) AppContext.getInstance().get("playerName1"));
    }
    
    void updateDifficulty(){
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

    public void loadTableGame(int aRows, int aColumns, int anAmmountCards) {
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
                System.out.print(tableGame[i][j] + "|"); 
            }
             System.out.println(""); 
        }
        System.out.println(""); 
        loadCards(aRows, aColumns);
    }
    
    void loadCards(int aRows, int aColumns) {
        int cardSize = 170;
        if (aRows == 6){
            cardSize = 110;
        }
        if (aRows == 8){
            cardSize = 85;
        }
        
        Image backImage = new Image("images/cards/back.png");
        ImageView[][] cardBackView = new ImageView[aRows][aColumns];
        Image[][] imageList = new Image[aRows][aColumns];
        Card[][] cardsList = new Card[aRows][aColumns];
        ImageView[][] cardFrontView = new ImageView[aRows][aColumns];
        
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
                cardFrontView[i][j] = new ImageView();
                cardBackView[i][j] = new ImageView();
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
                
                cardsList[i][j] = new Card(tableGame[i][j],imageList[i][j],backImage);
                cardFrontView[i][j].setImage(cardsList[i][j].getFront());
                cardBackView[i][j].setImage(cardsList[i][j].getBack());
                cardBackView[i][j].setFitHeight(cardSize);
                cardBackView[i][j].setFitWidth(cardSize);
                cardFrontView[i][j].setFitHeight(cardSize);
                cardFrontView[i][j].setFitWidth(cardSize);
                
                cardFrontView[i][j].setVisible(false);
                
                if((boolean)AppContext.getInstance().get("reviewMode") == true){
                    cardBackView[i][j].setVisible(false);
                    cardFrontView[i][j].setVisible(true);}

                table.add(cardFrontView[i][j], i, j);
                table.add(cardBackView[i][j], i, j);
            }
        }
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
   
}
