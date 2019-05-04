/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import Backend_skeleton.*;
import javafx.scene.control.PasswordField;
import groinc.GroInc;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author Dell
 */
public class LoginFormController implements Initializable
  {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private AnchorPane loginPane;
    @FXML
    private BorderPane parentb;
    @FXML
    private ImageView closeIcon;
    @FXML
    private Text LoginFormError;

    @FXML
    private void to_register(ActionEvent event) throws Exception
      {
       
     
       SceneMaker.startScene(getClass().getResource("registrationForm.fxml"));    
      
      }

    @FXML
    private void LoginButton(ActionEvent event) throws IOException,ClassNotFoundException, Exception
      {
        
       if( clientManager.logInCheck(userName.getText(), password.getText())){
           
          try {
          SceneMaker.startScene(getClass().getResource("application.fxml"));
           System.out.println("Welcome");
                 
          } catch (Exception e) {
              System.out.println(e);
          }
          
       }
       
       else
           LoginFormError.setVisible(true);
      }
    
    private void fadeIn()
      {
        /* loginPane.setOpacity(0);
         FadeTransition animate = new FadeTransition();
          animate.setDuration(Duration.millis(1500f));
          animate.setNode(loginPane);
          animate.setToValue(1);
          animate.play();*/
        
     loginPane.setScaleX(0);
     loginPane.setScaleY(0);
     ScaleTransition animate = new ScaleTransition(Duration.millis(700),loginPane);
       animate.setToX(1);
       animate.setToY(1);
        animate.play();
        
          
      }
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
      {
         
          fadeIn();
         
      }

   

  }
