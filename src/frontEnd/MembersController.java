/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import com.jfoenix.controls.JFXListView;
import java.awt.Checkbox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author future
 */
public class MembersController implements Initializable {

    @FXML
    private JFXListView<String> membersList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Integer j=0;j<10;j++){
            String s="Member ";
            s+=j.toString();
            membersList.getItems().add(s);
        }
        membersList.getStylesheets().add("/frontEnd/listButtons.css");
        
    }    
    
}
