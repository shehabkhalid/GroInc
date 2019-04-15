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
import javafx.stage.StageStyle;
/**
 *
 * @author shehab
 */
public class GroInc extends Application
  {
    
    @Override
    public void start(Stage stage) throws Exception
      {
      
       // dataBaseConnector.openDataBase();
        Parent root = FXMLLoader.load(getClass().getResource("/frontEnd/application.fxml"));
        
        Scene scene = new Scene(root);
         scene.getStylesheets().add("/frontEnd/LoginForm.css");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
       
        stage.show();
      }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        
             
         
        launch(args);
        
      }
    
  }
