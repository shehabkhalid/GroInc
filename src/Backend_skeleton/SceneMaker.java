/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;

import javafx.scene.Scene;
import com.jfoenix.controls.JFXDecorator;

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
public class SceneMaker {

    private static Stage mainStage;

    private static boolean firstTime = true;
    private static JFXDecorator border;

    public static void setMainStage(Stage mainStage) {
        SceneMaker.mainStage = mainStage;
    }
    public static void startPopupScene(URL Path) throws IOException {
       FXMLLoader loader = new FXMLLoader(Path);
       Parent root1 = (Parent)loader.load();
       Stage stage = new Stage();
       border = new JFXDecorator(stage, root1);
       Scene tScene = new Scene(border);
       tScene.getStylesheets().add("/frontEnd/decoratorEdit.css");
       stage.setScene(tScene);
       stage.show();
    }
    public static void startScene(URL formPath) throws Exception {
        AnchorPane root = FXMLLoader.load(formPath);
        Scene theNewScene;
        if (firstTime) {
            border = new JFXDecorator(mainStage, root);
            firstTime = false;
        } else {
            border.setContent(root);
        }

        mainStage.setWidth(root.getPrefWidth());
         mainStage.setHeight(root.getHeight());
        mainStage.setMinWidth(root.getPrefWidth());
        mainStage.setMinHeight(root.getPrefHeight());
      
        try {
            theNewScene = new Scene(border);

            theNewScene.getStylesheets().add("/frontEnd/decoratorEdit.css");
            mainStage.setScene(theNewScene);
            //mainStage.centerOnScreen();

            mainStage.show();
            double g = (1920 - mainStage.getWidth()) / 2;
         
            mainStage.setX(g);

        } catch (Exception e) {
            double g = (1920 - mainStage.getWidth()) / 2;
            mainStage.setX(g);

        }
    }

}
