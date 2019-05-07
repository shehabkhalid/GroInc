/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import Backend_skeleton.SceneMaker;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author shehab
 */
public class ApplicationController implements Initializable {

    @FXML
    private JFXListView<String> workspaces;

    public ApplicationController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<String> s = new ArrayList<String>();
        s.add("Workspace 1");
        s.add("Workspace 2");
        s.add("Workspace 3");
        /* for (int i = 0; i < s.size(); ++i) {
            workspaces.getItems().add(s.get(i));
            
        }*/
        for (Integer i = 0; i < 4; ++i) {
            workspaces.getItems().add(i.toString());
        }
        workspaces.getStylesheets().add("/frontEnd/listButtons.css");

    }

    @FXML
    private void create(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/frontEnd/newWorkspace.fxml"));
        Parent root2 = (Parent) load.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    private void selectworkspace(MouseEvent event) {
        String b = workspaces.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void logout(ActionEvent event) throws Exception {
        SceneMaker.startScene(getClass().getResource("LoginForm.fxml"));

    }

    @FXML
    private void expand(ActionEvent event) {
        if (!workspaces.isExpanded()) {
            workspaces.setExpanded(true);
            workspaces.depthProperty().set(1);
        } else {
            workspaces.setExpanded(false);
            workspaces.depthProperty().set(0);
        }
    }

}
