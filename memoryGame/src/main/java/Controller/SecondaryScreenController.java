
package Controller;


import Model.AppContext;
import Model.Game;
import Model.Player;
import com.mycompany.memorygame.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author jumac
 */
public class SecondaryScreenController implements Initializable {
    private String playerName1, playerName2;

    @FXML
    private Button btnContinue;
    @FXML
    private TextField txtfPlayerName1;
    @FXML
    private TextField txtfPlayerName2;
    @FXML
    private Button btnBack;
    @FXML
    private MenuItem miEasy;
    @FXML
    private MenuItem miNormal;
    @FXML
    private MenuItem miHard;
    @FXML
    private MenuItem miOnePlayer;
    @FXML
    private MenuItem miTwoPlayers;
    @FXML
    private MenuItem miPlayerVsPC;
    @FXML
    private Label txtPlayer1;
    @FXML
    private Label txtPlayer2;
    @FXML
    private CheckBox cbReviewMode;
    @FXML
    private CheckBox cbWildcards;
    
    Game newGame = new Game();
    
    Player player1 = new Player();
    
    Player player2 = new Player();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    private void showGameScreen() throws IOException {
        setGameProperties();
        App.setRoot("game");

    }

    @FXML
    void getNames(MouseEvent event) throws IOException {
        playerName1 = txtfPlayerName1.getText();
        playerName2 = txtfPlayerName2.getText();
       
        player1.setName(playerName1);
        player2.setName(playerName2);
        
        checkDataEntry();
    }
    
    void checkDataEntry() throws IOException{
        if(newGame.getPlayersAmount() == 2){
            checkTwoPlayersName();
        }else{
            checkOnePlayerName();
        }
    }
    
    void checkOnePlayerName() throws IOException{
        if(playerName1 == ""){
            showNameMissingError();
        }
        else{
            showGameScreen();
        }
    }
    
    void checkTwoPlayersName() throws IOException{
        if(playerName1 == "" || playerName2 == ""){
            showNameMissingError();
        }
        else if(playerName1.equals(playerName2)){
            showEqualNamesError();
        }
        else{
            showGameScreen();
        }
    }
    
    void showNameMissingError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("ERROR");
        alert.setContentText("\"El nombre debe de contener como minimo un caracter\"");
        alert.showAndWait(); 
    }
    
    private void showEqualNamesError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("ERROR");
        alert.setContentText("\"Los Nombres deben ser diferentes\"");
        alert.showAndWait();
    }

    @FXML
    private void goBack(MouseEvent event) throws IOException {
        App.setRoot("mainScreen");
        
    }

    @FXML
    private void setDifficultyEasy(ActionEvent event) {
        newGame.setDifficulty("Facil");
    }

    @FXML
    private void setDifficultyNormal(ActionEvent event) {
        newGame.setDifficulty("Normal");
    }

    @FXML
    private void setDifficultyHard(ActionEvent event) {
        newGame.setDifficulty("Dificil");
    }

    @FXML
    private void setOnePlayer(ActionEvent event) {
        newGame.setPlayersAmount(1);
        initializeTextFields();
    }

    @FXML
    private void setTwoPlayers(ActionEvent event) {
        newGame.setPlayersAmount(2);
        initializeTextFields();
    }

    @FXML
    private void setPlayerVsPC(ActionEvent event) {
        newGame.setPlayersAmount(1);
        initializeTextFields();
    }
    
    void initializeTextFields(){
        if(newGame.getPlayersAmount() == 2){
            txtfPlayerName2.setVisible(true);
            txtPlayer2.setVisible(true);
            txtPlayer1.setTranslateX(-350);
            txtfPlayerName1.setTranslateX(-336);
        }
        else{
            txtfPlayerName2.setVisible(false);
            txtPlayer2.setVisible(false);
            txtPlayer1.setTranslateX(0);
            txtfPlayerName1.setTranslateX(0);
        }
    }
    
    void setGameProperties(){
       AppContext.getInstance().set("diffuculty",newGame.getDifficulty());
       AppContext.getInstance().set("playerName1",player1.getName());
       AppContext.getInstance().set("playerName2",player2.getName());
    }

    @FXML
    private void activateReviewMode(ActionEvent event) {
        
    }

    @FXML
    private void activateWildcards(ActionEvent event) {
        
    }
}
