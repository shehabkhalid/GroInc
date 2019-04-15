/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author shehab
 */
public class ApplicationController implements Initializable
  {
    @FXML
     Button n[]=new Button[3];
    @FXML
    private GridPane grid;
    @FXML
    private ImageView closeIcon;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
   
      
      }    

    @FXML
    private void closeApp(MouseEvent event)
      {
        System.exit(0);
      }
    
  }
