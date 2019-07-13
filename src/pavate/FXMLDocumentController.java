/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pavate;

import static java.awt.Color.yellow;
import java.awt.event.MouseEvent;
import static java.lang.Double.parseDouble;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

/**
 *
 * @author acer
 */
public class FXMLDocumentController implements Initializable {

    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private Label label;
    @FXML
    Label lblID, lblName, lblHand, lblPoint, lblPrice, lblResult;
    @FXML
    Button btnAdd, btnSave, btnOrders, btnExit, btnTrial;
    @FXML
    TextField txtID, txtName, txtHand, txtPoint, txtPrice;
    @FXML
    ListView<Inventory> listInv;
    String[] labelsfX = {"lblID", "lblName", "lblHand", "lblPoint", "lblPrice"};
    String[] buttonsfX = {"btnAdd", "btnSave", "btnOrders", "btnExit"};
    String[] textfieldfX = {"txtID", "txtName", "txtHand", "txtPoint", "txtPrice"};

    List<Inventory> invList = new ArrayList<>();
    @FXML
    public void displaySelected(javafx.scene.input.MouseEvent event) {
       
       
       lblResult.setText("hahaha");
     
            //lblResult.setText(String.format("%f", abc.getRop()));
       
    }

    @FXML
    public void clearlist(javafx.scene.input.MouseEvent event) {
       // listInv.getItems().removeAll(list);

    }

//    @FXML
//    private void showReor(MouseEvent event) {
//        String movie=listInv.getSelectionModel().getSelectedItem();
//        if(movie==null||movie.isEmpty()){
//            lblResult.setText("hahah");
//            
//            
//        }
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
                alert.setX(500);
                alert.setY(350);
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
            lblResult.setText("Complete Process to add");
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
                alert.setX(500);
                alert.setY(350);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Empty cell");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else if (!txtID.getText().matches("([A-Z][A-Z][A-Z])-([0-9][0-9][0-9][0-9])")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(500);
                alert.setY(350);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("ID must be of the form ABC-1234");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else if (!txtName.getText().matches("[a-zA-Z]{0,30}")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(500);
                alert.setY(350);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Name cannot contain numbers");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else if (!txtHand.getText().matches("[0-9],{0,20}")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(500);
                alert.setY(350);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Quantity on Hand can only be a number");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else if (!txtPrice.getText().matches("[0-9],{0,20}")) {
                Alert alert = new Alert(AlertType.ERROR);
               alert.setX(500);
                alert.setY(350);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Unit Price can only be a number");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else if (!txtPoint.getText().matches("[0-9],{0,20}")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setX(500);
                alert.setY(350);
                alert.setTitle("Data Entry Error");
                alert.setHeaderText("Re-order point can only be a number");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();

            } else {

                String id = txtID.getText();
                String name = txtName.getText();
                double qty = Double.parseDouble(txtHand.getText());
                double units = Double.parseDouble(txtPrice.getText());
                double points = Double.parseDouble(txtPoint.getText());

                Inventory inven = new Inventory(id, name, qty, units, points);
                invList.add(inven);

                lblResult.setText("Inventory Added to database");

                btnSave.setDisable(true);
                btnAdd.setDisable(false);
                btnOrders.setDisable(false);

                txtID.setDisable(true);
                txtPrice.setDisable(true);
                txtName.setDisable(true);
                txtPoint.setDisable(true);
                txtHand.setDisable(true);

                txtID.setText("");
                txtPrice.setText("");
                txtName.setText("");
                txtPoint.setText("");
                txtHand.setText("");

            }

        });
        btnOrders.setOnAction((ActionEvent event) -> {

            if (invList.size() == 0) {
                lblResult.setText("No Items needs re-ordering.");
            } else {
                listInv.getItems().removeAll(list);
                listInv.getItems().clear();
                listInv.refresh();

                for (int i = 0; i <= invList.size() - 1; i++) {
                    list.add(invList.get(i).toString());
                }
                listInv.getItems().addAll(list);

            }

        });
        
        

    }

}
