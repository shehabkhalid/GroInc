/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.WritableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
public class ChattingFormController implements Initializable {

    @FXML
    private ScrollPane scrollPanel;
    @FXML
    private JFXListView<Label> listView;
    @FXML
    private JFXTextField chat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void enter(ActionEvent event) {
    Label temp = new Label(chat.getText());
    temp.getStylesheets().add("/frontEnd/chatbox.css");
    temp.wrapTextProperty().setValue(Boolean.TRUE);
    listView.getItems().add(temp);
    chat.clear();
    }
    
}
