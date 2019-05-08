/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import Backend_skeleton.SceneMaker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author future
 */
public class Task_CreationController implements Initializable {

    @FXML
    private JFXTextField task_title;
    @FXML
    private AnchorPane myPane;
    @FXML
    private JFXTextArea description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fadeIn();
    }

    @FXML
    private void Choose(ActionEvent event) throws Exception {
        try {
            SceneMaker.startPopupScene(getClass().getResource("/frontEnd/chooseMembers.fxml"));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    private void Create(ActionEvent event) {
    }

     private void fadeIn()
      {
        /* loginPane.setOpacity(0);
         FadeTransition animate = new FadeTransition();
          animate.setDuration(Duration.millis(1500f));
          animate.setNode(loginPane);
          animate.setToValue(1);
          animate.play();*/
        
     myPane.setScaleX(0);
     myPane.setScaleY(0);
     ScaleTransition animate = new ScaleTransition(Duration.millis(700),myPane);
       animate.setToX(1);
       animate.setToY(1);
        animate.play();
        
          
      }
}
