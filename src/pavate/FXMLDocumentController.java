/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pavate;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author acer
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    Label lblID,lblName,lblHand,lblPoint,lblPrice;
    @FXML
    Button btnAdd,btnSave,btnOrders,btnExit;
   
    
    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         lblID.setText(Fields.ITEM_ID.getCaption());
         lblName.setText(Fields.ITEM_NAME.getCaption());
         lblHand.setText(Fields. QOH.getCaption());
         lblPoint.setText(Fields.ROP.getCaption());
         lblPrice.setText(Fields.PRICE.getCaption());
         
         
    }    
    
}
