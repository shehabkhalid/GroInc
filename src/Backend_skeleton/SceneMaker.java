/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;

import javafx.scene.Scene;
import com.jfoenix.controls.JFXDecorator;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author shehab
 */
public class SceneMaker 
  {

    private  static Stage mainStage;
    
    private  static boolean firstTime = true;
    private static  JFXDecorator border;   
    public static void setMainStage(Stage mainStage)
      {
        SceneMaker.mainStage = mainStage;
      }

    public static void startScene(URL formPath) throws Exception
      {
           AnchorPane root = FXMLLoader.load(formPath);
        Scene theNewScene;
        if(firstTime)
          {
            border = new JFXDecorator(mainStage, root);
            firstTime=false;
          }
       else
          {
               border.setContent(root);
          }
  
      
        mainStage.setMinWidth(root.getPrefWidth());
        mainStage.setMinHeight(root.getPrefHeight());
          try
            {
                theNewScene = new Scene(border);
                System.out.println("das");
                theNewScene.getStylesheets().add("/frontEnd/decoratorEdit.css");
                mainStage.setScene(theNewScene);
                mainStage.show();
        
            } catch (Exception e)
              {}
      }

  }
