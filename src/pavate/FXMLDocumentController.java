/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pavate;

import static java.lang.Double.parseDouble;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author acer
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    Label lblID, lblName, lblHand, lblPoint, lblPrice, lblResult;
    @FXML
    Button btnAdd, btnSave, btnOrders, btnExit, btnTrial;
    @FXML
    TextField txtID, txtName, txtHand, txtPoint, txtPrice;
    String[] labelsfX = {"lblID", "lblName", "lblHand", "lblPoint", "lblPrice"};
    String[] buttonsfX = {"btnAdd", "btnSave", "btnOrders", "btnExit"};
    String[] textfieldfX = {"txtID", "txtName", "txtHand", "txtPoint", "txtPrice"};

    @FXML
    public void check(ActionEvent event) {
        String id = lblID.getText();
        lblResult.setText(id);

    }

//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblID.setText(Fields.ITEM_ID.getCaption());
        lblName.setText(Fields.ITEM_NAME.getCaption());
        lblHand.setText(Fields.QOH.getCaption());
        lblPoint.setText(Fields.ROP.getCaption());
        lblPrice.setText(Fields.PRICE.getCaption());
        btnSave.setDisable(true);
        txtID.setDisable(true);
        txtPrice.setDisable(true);
        txtName.setDisable(true);
        txtPoint.setDisable(true);
        txtHand.setDisable(true);

        btnExit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setX(780);
                alert.setY(440);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Would you like to Quit?");
                alert.setContentText("Are you ok with this?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.exit(0);
                }

            }
        });
        btnAdd.setOnAction((ActionEvent event) -> {
            btnSave.setDisable(false);
            btnAdd.setDisable(true);
            btnOrders.setDisable(true);
            //for (int i = 0; i < textfieldfX.length; i++) 
            //  ((textfieldfX[0])).setDisable(false);  
            txtID.setDisable(false);
            txtPrice.setDisable(false);
            txtName.setDisable(false);
            txtPoint.setDisable(false);
            txtHand.setDisable(false);
        });

        btnSave.setOnAction((ActionEvent event) -> {

            if (txtID.getText().isEmpty() || txtPrice.getText().isEmpty() || txtName.getText().isEmpty()
                    || txtPoint.getText().isEmpty() || txtHand.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(780);
                alert.setY(440);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Empty cell");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else if (!txtID.getText().matches("([A-Z][A-Z][A-Z])-([0-9][0-9][0-9][0-9])")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(780);
                alert.setY(440);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("ID must be of the form ABC-1234");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else if (!txtName.getText().matches("[a-zA-Z]{0,30}")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(780);
                alert.setY(440);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Name cannot contain numbers");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else if (!txtHand.getText().matches("[0-9],{0,20}")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(780);
                alert.setY(440);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Quantity on Hand can only be a number");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else if (!txtPrice.getText().matches("[0-9],{0,20}")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(780);
                alert.setY(440);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Unit Price can only be a number");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else if (!txtPoint.getText().matches("[0-9],{0,20}")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(780);
                alert.setY(440);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Re-order point can only be a number");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            }else{

            String id = txtID.getText();
            String name = txtName.getText();
            double qty = Double.parseDouble(txtHand.getText());
            double units = Double.parseDouble(txtPrice.getText());
            double points = Double.parseDouble(txtPoint.getText());

            btnSave.setDisable(true);
            btnAdd.setDisable(false);
            btnOrders.setDisable(false);
            }

//            else{
//       
//            }
//            
//            if (id.matches("([A-Z][A-Z][A-Z])-([0-9][0-9][0-9][0-9])")) {
//                btnExit.setDisable(true);
//
//            }
        });
        btnTrial.setOnAction((ActionEvent event) -> {
            String id = txtID.getText();
            if (id.matches("([A-Z][A-Z][A-Z])-([0-9][0-9][0-9][0-9])")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(780);
                alert.setY(440);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Empty cell");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            }

        });

    }

}
