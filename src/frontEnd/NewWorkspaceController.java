/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import Backend_skeleton.SceneMaker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author future
 */
public class NewWorkspaceController implements Initializable {

    @FXML
    private JFXTextField WorskpaceName;
    @FXML
    private ImageView closeSmallWindow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void checkWorkspace(ActionEvent event) throws Exception {
        Stage x = (Stage)closeSmallWindow.getScene().getWindow();
        x.close();
        SceneMaker.startScene(getClass().getResource("Workspace.fxml"));
    }

    @FXML
    private void closeIcon(MouseEvent event) {
        Stage x = (Stage)closeSmallWindow.getScene().getWindow();
        x.close();
    }
    
}
