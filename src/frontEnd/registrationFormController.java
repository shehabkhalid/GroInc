/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import attributes.phoneNumber;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.webkit.dom.KeyboardEventImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import attributes.*;
import Backend_skeleton.*;
import com.jfoenix.controls.JFXDatePicker;
import java.time.LocalDate;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.DatePicker;
import groinc.GroInc;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;
import Backend_skeleton.SceneMaker;
import java.io.IOException;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class registrationFormController implements Initializable
  {

    @FXML
    private Text registrationFailed;
    @FXML
    private AnchorPane registrationPane;
    @FXML
    private JFXComboBox<String> gender_combobox;
    @FXML
    private BorderPane parentb;
    @FXML
    private ImageView closeIcon;
    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField phoneNumberp;
    @FXML
    private JFXTextField lastName;
    @FXML
    private JFXTextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private JFXTextField email;

    private name tempName = new name();
    private phoneNumber tempPhone = new phoneNumber();
    private date tempDate = new date();
    private email tempMail = new email();
    private member tempPerson;

    @FXML
    private JFXDatePicker datePick;

    @FXML
    private void closeApp(MouseEvent event)
      {
        System.exit(0);
      }

    @FXML
    private void registerBtn(ActionEvent event) throws IOException, ClassNotFoundException
      {

        if (name.isNameValid(firstName.getText(), lastName.getText()))
          {

            tempName.setNaString(firstName.getText());
            tempName.setLaString(lastName.getText());

            if (clientManager.checkUserName(userName.getText()))
              {
                System.out.println("hell yeah");

                if (phoneNumber.isValid(phoneNumberp.getText()))
                  {

                    tempPhone.setpString(phoneNumberp.getText());

                    if (clientManager.checkMail(email.getText()))
                      {

                        tempMail.setMailString(email.getText());
                        if (gender_combobox.getValue() != null)
                          {

                            if (datePick.getValue() != null)
                              {

                                if (Password.isValid(password.getText()))
                                  {

                                    tempPerson = new member.Builder(tempName)
                                            .setBuilderphone(tempPhone)
                                            .setBuilderbirthdate(datePick.getValue().toString())
                                            .setBuildermail(tempMail)
                                            .setBuildergender(gender_combobox.getValue())
                                            .setBuilderpassword(password.getText())
                                            .setBuilderusername(userName.getText())
                                            .build();

                                    // tempPerson = new member(tempName, tempPhone,
                                    //       tempMail, gender_combobox.getValue(), datePick.getValue().toString(), Password.Encrypt(new StringBuilder(password.getText())), userName.getText());
                                    tempPerson.setCommand("ADD");
                                    //System.out.println(tempPerson.getPhoneNumber1().getpString());
                                    if (clientManager.addUser(tempPerson))
                                      {
                                        System.out.println("YES");
                                      } else
                                      {
                                        registrationFailed.setVisible(true);
                                      }

                                  } else
                                  {
                                    password.setText("");
                                    password.setStyle("-fx-prompt-text-fill: red; -jfx-unfocus-color: red;");
                                    password.setPromptText("At least 8 characters!");
                                  }
                              } else
                              {
                                //  datePick.setValue(LocalDate.MIN);

                                datePick.setStyle("-fx-border-color: red;");
                                datePick.setPromptText("You must pick a date!");
                              }
                          } else
                          {
                            gender_combobox.setStyle("-jfx-unfocus-color:red; -fx-prompt-text-fill: red;");
                          }

                      } else
                      {
                        email.setText("");
                        email.setStyle("-fx-prompt-text-fill: red; -jfx-unfocus-color: red;");
                        email.setPromptText("This is an invalid email!");
                      }
                  } else
                  {
                    phoneNumberp.setText("");
                    phoneNumberp.setStyle("-fx-prompt-text-fill: red; -jfx-unfocus-color: red;");
                    phoneNumberp.setPromptText("This is an invalid phone number!");
                  }
              }
          } else
          {
            firstName.setText("");
            firstName.setStyle("-fx-prompt-text-fill: red; -jfx-unfocus-color: red;");
            firstName.setPromptText("You must fill all your data!");
            lastName.setText("");
            lastName.setStyle("-fx-prompt-text-fill: red; -jfx-unfocus-color: red;");
            lastName.setPromptText("You must fill all your data!");
          }

      }

    @FXML
    private void genderError(MouseEvent event)
      {
        gender_combobox.setStyle("-fx-prompt-text-fill: #636161; -jfx-unfocus-color: #636161;");
      }

    @FXML
    private void firstNameError(MouseEvent event)
      {
        firstName.setStyle("-fx-prompt-text-fill: #636161; -jfx-unfocus-color: #636161;");
        firstName.setPromptText("First Name");
      }

    @FXML
    private void lastNameError(MouseEvent event)
      {
        lastName.setStyle("-fx-prompt-text-fill: #636161; -jfx-unfocus-color: #636161;");
        lastName.setPromptText("Last Name");
      }

    @FXML
    private void userNameError(MouseEvent event)
      {
        userName.setStyle("-fx-prompt-text-fill: #636161; -jfx-unfocus-color: #636161;");
        userName.setPromptText("Username");
      }

    @FXML
    private void passwordError(MouseEvent event)
      {
        password.setStyle("-fx-prompt-text-fill: #636161; -jfx-unfocus-color: #636161;");
        password.setPromptText("Password");
      }

    @FXML
    private void emailError(MouseEvent event)
      {
        email.setStyle("-fx-prompt-text-fill: #636161; -jfx-unfocus-color: #636161;");
        email.setPromptText("E-mail");
      }

    @FXML
    private void phoneNumberError(MouseEvent event)
      {

        phoneNumberp.setStyle("-fx-prompt-text-fill: #636161; -jfx-unfocus-color: #636161;");
        phoneNumberp.setPromptText("Phone Number");

      }

    private void fadeIn()
      {
        /*  registrationPane.setOpacity(0);
         FadeTransition animate = new FadeTransition();
          animate.setDuration(Duration.millis(1000f));
          animate.setNode(registrationPane);
          animate.setToValue(1);
          animate.play();*/
        registrationPane.setScaleX(0);
        registrationPane.setScaleY(0);
        ScaleTransition animate = new ScaleTransition(Duration.millis(700), registrationPane);
        animate.setToX(1);
        animate.setToY(1);
        animate.play();

      }

    @Override
    public void initialize(URL location, ResourceBundle resources)
      {

        fadeIn();

        gender_combobox.getItems().addAll("Male", "Female");

      }

  }
