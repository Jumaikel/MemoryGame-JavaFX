
package Controller;


import Model.Player;
import com.mycompany.memorygame.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void showGameScreen() throws IOException {
        App.setRoot("game");
    }

    @FXML
        void getNames(MouseEvent event) throws IOException {
        playerName1 = txtfPlayerName1.getText();
        playerName2 = txtfPlayerName2.getText();
        Player player1 = new Player(playerName1);
        Player player2 = new Player(playerName2);
        
        if(player1.getName().equals(player2.getName()) || player1.getName() == "" || player2.getName() == ""){
            showEqualNamesError();
        }
        else{  
            showGameScreen(); 
        }
    }
    
    private void showEqualNamesError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("ERROR");
        alert.setContentText("\"Los Nombres deben ser diferentes y contener minimo un caracter\"");
        alert.showAndWait();
    }
 
}
