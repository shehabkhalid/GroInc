/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import Backend_skeleton.SceneMaker;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author future
 */
public class Workspace2Controller implements Initializable {

    @FXML
    private Pane myPane;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private ListView<Pane>workspacetasks=new JFXListView<Pane>();
    @FXML
    private JFXButton Home;
    @FXML
    private AnchorPane mainPane;
    private boolean out = true;
    HamburgerNextArrowBasicTransition task;

    @FXML
    private void sidePane() {
        myPane.setVisible(true);
        Timeline timeline = new Timeline();
        KeyValue kv = null;
        KeyFrame kf = null;
        if (out) {
            kv = new KeyValue(myPane.translateXProperty(), 0, Interpolator.EASE_IN);
            kf = new KeyFrame(Duration.seconds(1), kv);

        } else {

            kv = new KeyValue(myPane.translateXProperty(), mainPane.getWidth(), Interpolator.EASE_OUT);
            kf = new KeyFrame(Duration.seconds(1), kv);
        }
        timeline.getKeyFrames().add(kf);
        timeline.play();
        out = !out;
        task.setRate(task.getRate() * -1);

        task.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        task = new HamburgerNextArrowBasicTransition(hamburger);
        task.setRate(-1);
        myPane.setTranslateX(1000);

        myPane.setVisible(true);
        
        inserttasks("TASK 1", "25-5-2019", "DONE", 3);
        inserttasks("TASK 2", "25-5-2019", "ON PROGRESS", 3);
        inserttasks("TASK 3", "25-5-2019", "PASSED", 3);

    }

    @FXML
    private void home(ActionEvent event) throws Exception {

        SceneMaker.startScene(getClass().getResource("/frontEnd/application.fxml"));
    }

    @FXML
    private void ShowMember(ActionEvent event) throws Exception {
        SceneMaker.startScene(getClass().getResource("/frontEnd/Members.fxml"));
    }


    @FXML
    private void CreateTask(ActionEvent event) throws Exception {
        SceneMaker.startScene(getClass().getResource("/frontEnd/Task_Creation.fxml"));
    }

    
    private void inserttasks(String taskname,String deadline,String status,Integer membersnum){
     Pane p=new Pane();
     p.setPrefWidth(424);
     p.setPrefHeight(291);
     
      TextArea nametxt=new JFXTextArea(taskname);
      nametxt.setPrefHeight(39);
      nametxt.setPrefWidth(350);
      nametxt.setLayoutX(45);
      nametxt.setLayoutY(37);
      
      TextArea deadlinetxt=new JFXTextArea(deadline);
      deadlinetxt.setPrefHeight(39);
      deadlinetxt.setPrefWidth(350);
      deadlinetxt.setLayoutX(45);
      deadlinetxt.setLayoutY(121);
      
        Circle c =new Circle();
        c.setRadius(18);
        c.setCenterX(0);
        c.setCenterY(0);
        c.setLayoutX(63);
        c.setLayoutY(236);
        java.awt.Color awtColor;
        
        TextArea statustxt=new JFXTextArea(status);
        statustxt.setPrefHeight(39);
        statustxt.setPrefWidth(118);
        statustxt.setLayoutX(123);
        statustxt.setLayoutY(215);
        
        TextArea membersnumtxt=new JFXTextArea(membersnum.toString());
        membersnumtxt.setPrefHeight(39);
        membersnumtxt.setPrefWidth(118);
        membersnumtxt.setLayoutX(266);
        membersnumtxt.setLayoutY(215);
        
        if(status.equals("DONE")){
             awtColor = new java.awt.Color(0, 255, 0);
        }
        else if(status.equals("ON PROGRESS")){
            awtColor=new java.awt.Color(248, 255, 11);
        }
        else{
        awtColor=new java.awt.Color(255, 0, 0);
        }
        Integer r=awtColor.getRed();
        Integer g=awtColor.getGreen();
        Integer b=awtColor.getBlue();
        Integer a=awtColor.getAlpha();
        double opacity=a/255.0;
        javafx.scene.paint.Color fxColor=javafx.scene.paint.Color.rgb(r, g, b,opacity);
        c.setFill(fxColor);
        
        p.getChildren().add(nametxt);
        p.getChildren().add(deadlinetxt);
        p.getChildren().add(c);
        p.getChildren().add(statustxt);
        p.getChildren().add(membersnumtxt);
        workspacetasks.getItems().add(p);
    
    }

    @FXML
    private void AddMember(ActionEvent event) throws Exception {
        try {
                 SceneMaker.startScene(getClass().getResource("/frontEnd/AddMember.fxml"));

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
