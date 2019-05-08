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

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import sun.plugin2.message.MouseEventMessage;

/**
 * FXML Controller class
 *
 * @author future
 */
public class Workspace2Controller implements Initializable {

    MediaPlayer mp;
    @FXML
    private Pane myPane;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private ListView<Pane> workspacetasks = new JFXListView<Pane>();
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
            kf = new KeyFrame(Duration.seconds(0.5), kv);

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
        workspacetasks.setStyle("-fx-background-insets: 0;");
        workspacetasks.getStylesheets().add("/frontEnd/workspace2.css");
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

        SceneMaker.startPopupScene(getClass().getResource("/frontEnd/Members.fxml"));
    }

    @FXML
    private void CreateTask(ActionEvent event) throws Exception, UnsupportedOperationException {
        try {

        } catch (Exception e) {
            System.err.println(e);
        }
        SceneMaker.startPopupScene(getClass().getResource("/frontEnd/Task_Creation.fxml"));
    }

    private void inserttasks(String taskname, String deadline, String status, Integer membersnum) {
        Pane p = new Pane();
        p.setPrefWidth(424);
        p.setPrefHeight(291);

        TextArea nametxt = new JFXTextArea(taskname);
        nametxt.setPrefHeight(39);
        nametxt.setPrefWidth(350);
        nametxt.setLayoutX(45);
        nametxt.setLayoutY(37);

        TextArea deadlinetxt = new JFXTextArea(deadline);
        deadlinetxt.setPrefHeight(39);
        deadlinetxt.setPrefWidth(350);
        deadlinetxt.setLayoutX(45);
        deadlinetxt.setLayoutY(121);

        Circle c = new Circle();
        c.setRadius(18);
        c.setCenterX(0);
        c.setCenterY(0);
        c.setLayoutX(63);
        c.setLayoutY(236);
        java.awt.Color awtColor;

        TextArea statustxt = new JFXTextArea(status);
        statustxt.setPrefHeight(39);
        statustxt.setPrefWidth(118);
        statustxt.setLayoutX(123);
        statustxt.setLayoutY(215);

        TextArea membersnumtxt = new JFXTextArea(membersnum.toString());
        membersnumtxt.setPrefHeight(39);
        membersnumtxt.setPrefWidth(118);
        membersnumtxt.setLayoutX(266);
        membersnumtxt.setLayoutY(215);

        if (status.equals("DONE")) {
            awtColor = new java.awt.Color(0, 255, 0);
        } else if (status.equals("ON PROGRESS")) {
            awtColor = new java.awt.Color(248, 255, 11);
        } else {
            awtColor = new java.awt.Color(255, 0, 0);
        }
        Integer r = awtColor.getRed();
        Integer g = awtColor.getGreen();
        Integer b = awtColor.getBlue();
        Integer a = awtColor.getAlpha();
        double opacity = a / 255.0;
        javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(r, g, b, opacity);
        c.setFill(fxColor);
        awtColor = new java.awt.Color(96, 3, 127);
        r = awtColor.getRed();
        g = awtColor.getGreen();
        b = awtColor.getBlue();
        a = awtColor.getAlpha();
        opacity = a / 255.0;
        fxColor = javafx.scene.paint.Color.rgb(r, g, b, opacity);
        p.getChildren().add(nametxt);
        p.getChildren().add(deadlinetxt);
        p.getChildren().add(c);
        p.getChildren().add(statustxt);
        p.getChildren().add(membersnumtxt);

        p.setBorder(new Border(new BorderStroke(fxColor, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        workspacetasks.getItems().add(p);

    }

    @FXML
    private void AddMember(ActionEvent event) throws Exception {
        try {
            SceneMaker.startPopupScene(getClass().getResource("/frontEnd/AddMember.fxml"));

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    private void showMyTasks(ActionEvent event) {
    }

    @FXML
    private void showAllTasks(ActionEvent event) {
    }

    @FXML
    private void showDetails(MouseEvent event) {
        Pane p = workspacetasks.getSelectionModel().getSelectedItem();
        Object[] obj = p.getChildren().toArray();
        System.out.println(obj[0].getClass().getSimpleName());
        TextArea t = (TextArea) obj[0];
        System.out.println(t.getText());
    }

    @FXML
    private void playSound1(MouseEvent event) {
    
       
       
       // System.out.println(a);
        //Media onHoverSound = new Media("file:///C:/Users/shehab/Documents/NetBeansProjects/GroInc/Media_Sounds/multimedia_rollover_044.mp3");
        //mp = new MediaPlayer(onHoverSound);
        //mp.setAutoPlay(true);
    }


}
