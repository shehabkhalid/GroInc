/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groinc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author shehab
 */
public class FXMLDocumentController implements Initializable
  {
    
    
    @FXML
    private Label label2;
    
  
    @FXML
    private  void testit(ActionEvent event)
      {
        label2.setText("Welcome To GroInc !");
      }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        // TODO
      }    
    
  }
