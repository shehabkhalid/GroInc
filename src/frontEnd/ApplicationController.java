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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author shehab
 */
public class ApplicationController implements Initializable
  {

    @FXML
    private JFXListView<JFXButton> workspaces;

    public ApplicationController() {
    
    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
          
      
      }    

    @FXML
    private void create(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/frontEnd/newWorkspace.fxml"));
        Parent root2=(Parent)load.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

  }
