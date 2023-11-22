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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Admin_pharmaciesController {

     @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private Button addbut;

    @FXML
    private Button but11;

    @FXML
    private Button update;

    @FXML
    private Button viewbut;
     
    @FXML
    private TextField address;

    @FXML
    private TextField contact;

    @FXML
    private TextField district;

    @FXML
    private TextField name;

    Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();

    @FXML
    void add(ActionEvent event) {
        pharmacy e1= new pharmacy();
    e1.setName(name.getText());
    e1.setContact(contact.getText());
    e1.setAddress(address.getText());
    e1.setDistrict(district.getText());

    Session session=sf.openSession();
    session.beginTransaction();
    session.save(e1);
    session.getTransaction().commit();
    session.close();
    
    JOptionPane.showMessageDialog(null, "The Pharmacy was added to the system succesfully !");
    clearFields();
    
    }
    
    private void clearFields(){
        name.setText("");
                 contact.setText("");
                 address.setText("");
                district.setText("");   
    }
        

    
    

    @FXML
    void BackBut(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("AdminBut.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminButController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void add_pharmacies(ActionEvent event) {
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
    void delete_pharmacies(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Admin_pharmacies_3.fxml"));
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
    void view_pharmacies(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Admin_pharmacies_2.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminButController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void initialize() {
        assert addbut != null : "fx:id=\"addbut\" was not injected: check your FXML file 'Admin_pharmacies.fxml'.";
        assert but11 != null : "fx:id=\"but11\" was not injected: check your FXML file 'Admin_pharmacies.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'Admin_pharmacies.fxml'.";
        assert viewbut != null : "fx:id=\"viewbut\" was not injected: check your FXML file 'Admin_pharmacies.fxml'.";

    }

}
