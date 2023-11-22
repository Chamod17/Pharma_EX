package pharma_ex;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminButController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addbut;

    @FXML
    private Button but11;

    @FXML
    private Button update;

    @FXML
    private Button viewbut;

    @FXML
    void BackBut(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminButController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void pharmacies(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Admin_pharmacies.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminButController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void pharmacists(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Admn_pharmacists.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminButController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void sales_reps(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Admin_Sales.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminButController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void update(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert addbut != null : "fx:id=\"addbut\" was not injected: check your FXML file 'AdminBut.fxml'.";
        assert but11 != null : "fx:id=\"but11\" was not injected: check your FXML file 'AdminBut.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'AdminBut.fxml'.";
        assert viewbut != null : "fx:id=\"viewbut\" was not injected: check your FXML file 'AdminBut.fxml'.";

    }

}
