/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ChooseMembersController implements Initializable {

    @FXML
    private JFXListView<JFXCheckBox> checkingList;
    @FXML
    private AnchorPane myPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fadeIn();
        for (Integer j = 0; j < 5; j++) {
            String tmp = "Member ";
            tmp += j.toString();
            JFXCheckBox check = new JFXCheckBox(tmp);
            checkingList.getItems().add(check);
        }
    }

    @FXML
    private void Save(ActionEvent event) {
    }

    private void fadeIn() {
        /* loginPane.setOpacity(0);
         FadeTransition animate = new FadeTransition();
          animate.setDuration(Duration.millis(1500f));
          animate.setNode(loginPane);
          animate.setToValue(1);
          animate.play();*/
        myPane.setScaleX(0);
        myPane.setScaleY(0);
        ScaleTransition animate = new ScaleTransition(Duration.millis(700), myPane);
        animate.setToX(1);
        animate.setToY(1);
        animate.play();

    }

}
