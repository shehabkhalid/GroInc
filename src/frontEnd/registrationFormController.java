/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import Backend_skeleton.member;
import attributes.*;
import java.time.LocalDate;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author shehab
 */
public class registrationFormController
  {

    final private ToggleGroup gender = new ToggleGroup();
    @FXML
    private TextField emailField, firstNameField, lastNameField, phoneField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private RadioButton maleRadioBtn, femaleRadioBtn;
    @FXML
    private DatePicker dateField;

   
    @FXML
    private void register(ActionEvent event)
      {

        if (name.isNameValid(firstNameField.getText(), lastNameField.getText()))
          {
            if (phoneNumber.isValid(phoneField.getText()))
              {
                //mailCheckerWhen the Functios are done
                if (passwordField.getLength() > 8)
                  {

                    if (dateField.getValue() != null)
                      {
                       if(maleRadioBtn.isSelected() || femaleRadioBtn.isSelected())
                         {
                           
                         }
                       else
                           alerts.error("Invalid Gender", "Invalid Gender", "Select Male or Female");
                      } 
                    else
                      {
                        alerts.error("Invalid", "Invalid Date", "Enter correct Date");
                      }
                  } else
                  {
                    alerts.error("Invalid Password", "Invalid Password", "Make sure that your password length is more 8 digits");
                  }

              } else
              {
                alerts.error("Invalid Phone", "Invalid Phone", "Make sure that your phone number is correct");
              }
          } else
          {
            alerts.error("Invalid Name", "Invalid Name", "Make sure that the names are at least two characters");
          }

      }

  }
