package Controller;

import com.mycompany.memorygame.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jumaikel
 */
public class MainScreenController implements Initializable {

    @FXML
    private AnchorPane mainScreenPane;
    @FXML
    private Button btnPlay;
    @FXML
    private MenuButton menuNumberPlayers;
    @FXML
    private MenuButton menuDifficulty;
    @FXML
    private Button btnHelp;
    @FXML
    private Button btnAbout;
    @FXML
    private CheckBox checkReviewMode;
    @FXML
    private CheckBox checkWildcards;
    @FXML
    private CheckBox checkConsecutiveCouples;
    @FXML
    private CheckBox checkPunishmentForFailure;
    @FXML
    private CheckBox checkTrios;
    @FXML
    private Label labelGameModes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showSecundaryScreen(MouseEvent event) throws IOException {
        App.setRoot("secondaryScreen");
    }

    @FXML
    private void showHelpScreen(MouseEvent event) throws IOException {
        App.setRoot("helpScreen");
    }

    @FXML
    private void showAboutScreen(MouseEvent event) throws IOException {
        App.setRoot("aboutScreen");
    }
    
}
