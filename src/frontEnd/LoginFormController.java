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

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class LoginFormController
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
    private void to_register(ActionEvent event) throws IOException
      {
        AnchorPane registrationPane = FXMLLoader.load(getClass().getResource("registrationForm.fxml"));
        loginPane.getChildren().setAll(registrationPane);
      }

    @FXML
    private void LoginButton(ActionEvent event)
      {
        

       if( dataBaseConnector.loginCheck(userName.getText(), password.getText()))
              System.out.println("Welcome");
       else
           LoginFormError.setVisible(true);
      }

    @FXML
    private void closeApp(MouseEvent event)
      {
        System.exit(0);
      }

  }
