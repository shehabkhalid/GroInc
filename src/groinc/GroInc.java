/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groinc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import frontEnd.*;
import Backend_skeleton.dataBaseConnector;
import Backend_skeleton.SceneMaker;
import com.jfoenix.controls.JFXDecorator;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

/**
 *
 * @author shehab
 */
public class GroInc extends Application 
  {
   

  //  @Override
    public void start(Stage stage) throws Exception
      {

//Scene scene = new Scene(decorator, 800, 850);
         dataBaseConnector.openDataBase();
        SceneMaker.setMainStage(stage);
        SceneMaker.startScene(getClass().getResource("/frontEnd/LoginForm.fxml"));
        
        
      }

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) throws Exception
      {

        launch(args);

      }

  }
