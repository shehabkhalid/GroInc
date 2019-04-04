/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groinc;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.*;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.util.Duration;

/**
 *
 * @author shehab
 */
public class FXMLDocumentController 
  {
    
    
    @FXML
    private Label label2;
    
  
    @FXML
    private  void testit(ActionEvent event)
      {
          ScaleTransition aScaleTransition = new ScaleTransition();
          aScaleTransition.setDuration(Duration.millis(500));
          aScaleTransition.setNode(label2);
          label2.setText("Welcome To GroInc !");
          label2.setScaleX(0);
          label2.setScaleY(0);
          aScaleTransition.setByX(1);
          aScaleTransition.setByY(1);
          aScaleTransition.play();
       
      }
    
  
    
  }



