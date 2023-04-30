package Controller;

import com.mycompany.memorygame.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Button btnHelp;
    @FXML
    private Button btnAbout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    


    @FXML
    private void showHelpScreen(MouseEvent event) throws IOException {
        App.setRoot("helpScreen");
    }

    @FXML
    private void showAboutScreen(MouseEvent event) throws IOException {
        App.setRoot("aboutScreen");
    }

    @FXML
    private void showSecondaryScreen(MouseEvent event) throws IOException {
        App.setRoot("secondaryScreen");
    }

}
