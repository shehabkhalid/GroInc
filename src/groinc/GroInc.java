/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groinc;

import attributes.email;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import frontEnd.*;

import Backend_skeleton.SceneMaker;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;
import Backend_skeleton.clientManager;
import Backend_skeleton.clientManager;
import attributes.name;

/**
 *
 * @author shehab
 */
public class GroInc extends Application
  {

    //  @Override
    public void start(Stage stage) throws Exception
      {


        SceneMaker.setMainStage(stage);
          try {
                      SceneMaker.startScene(getClass().getResource("/frontEnd/Workspace2.fxml"));

          } catch (Exception e) {
              System.out.println(e);
          }

      }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
      {
       
        
         
          
     clientManager.openConnection();
     
    
        

        launch(args);

      }

  }



