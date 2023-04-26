
package Controller;

import Model.Card;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author jumac
 */
public class GameController implements Initializable {
    
    
    
    @FXML
    private Label txtPlayer2;
    @FXML
    private Label txtPlayer2Score;
    @FXML
    private GridPane cardTable;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTableGame(4,4);
    } 

    private int [][] tableGame;
    private Random randomNumber;
    
    public void loadTableGame(int aRows, int aColumns){
        tableGame = new int [aRows][aColumns];
        randomNumber = new Random();
        int cont;
        for(int i=0;i<aRows;i++){
            for(int j=0;j<aColumns;j++){
                tableGame[i][j] = randomNumber.nextInt(8);
             
                do{
                    cont = 0;
                    for(int n=0;n<aRows;n++){
                        for(int m=0;m<aColumns;m++){
                            if(tableGame[i][j] == tableGame[n][m]){
                                cont++;
                            }
                        }
                    }
                    if(cont == 3){
                        tableGame[i][j] = randomNumber.nextInt(8);
                    }
                }
                while(cont == 3);
                System.out.print(tableGame[i][j] + "|"); 
            }
             System.out.println(""); 
        }
        System.out.println(""); 
        loadCards(aRows, aColumns);
    }
    
    void loadCards(int aRows, int aColumns){
        Image backImage = new Image("images/cards/back.png");
        ImageView[][] cardBackView = new ImageView[aRows][aColumns];
        Image[][] imageList = new Image[aRows][aColumns];
        Card[][] cardsList = new Card[aRows][aColumns];
        ImageView[][] cardFrontView = new ImageView[aRows][aColumns];
        for(int i=0;i<aRows;i++){
            for(int j=0;j<aColumns;j++){
                cardFrontView[i][j] = new ImageView();
                cardBackView[i][j] = new ImageView();
                imageList[i][j] = new Image("images/cards/"+tableGame[i][j]+".png");
                cardsList[i][j] = new Card(tableGame[i][j],imageList[i][j],backImage);
                cardFrontView[i][j].setImage(cardsList[i][j].getFront());
                cardBackView[i][j].setImage(cardsList[i][j].getBack());
                cardBackView[i][j].setFitHeight(160);
                cardBackView[i][j].setFitWidth(160);
                cardFrontView[i][j].setFitHeight(160);
                cardFrontView[i][j].setFitWidth(160);
                cardFrontView[i][j].setVisible(false);
                
                cardTable.add(cardFrontView[i][j],j,i);
                cardTable.add(cardBackView[i][j],j,i);
                
            }
        }
    }
}
