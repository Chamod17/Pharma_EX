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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Admin_SalesController {

    @FXML
    private TextField company;

    @FXML
    private TextField email;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;
    
    @FXML
    private PasswordField password;

    @FXML
    private TextField u_name;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addbut;

    @FXML
    private Button update;

    @FXML
    private Button viewbut;
    
    String usertype = "Sales Rep";

    Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();

    @FXML
    void add(ActionEvent event) {
        sales_rep e1= new sales_rep();
        Login e2 = new Login();
    e1.setFname(fname.getText());
    e1.setLname(lname.getText());
    e1.setEmail(email.getText());
    e1.setCompany(company.getText());
    e2.setEmail(email.getText());
    e2.setUsername(u_name.getText());
    e2.setPassword(password.getText());
    e2.setusertype(usertype);

    Session session=sf.openSession();
    session.beginTransaction();
    session.save(e1);
    session.save(e2);
    session.getTransaction().commit();
    session.close();
    
    JOptionPane.showMessageDialog(null, "Successfully registered !");
    clearFields();
    
    }
    
    private void clearFields(){
                fname.setText("");
                lname.setText("");
                email.setText("");
                company.setText("");  
                u_name.setText(""); 
                password.setText(""); 
    }
    
    
    @FXML
    void add_data(ActionEvent event) {

    }

    @FXML
    void add_reps(ActionEvent event) {
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
    void back(ActionEvent event) {
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
    void delete_reps(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Admin_Sales_3.fxml"));
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
    void view_reps(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Admin_Sales_2.fxml"));
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
        assert addbut != null : "fx:id=\"addbut\" was not injected: check your FXML file 'Admin_Sales.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'Admin_Sales.fxml'.";
        assert viewbut != null : "fx:id=\"viewbut\" was not injected: check your FXML file 'Admin_Sales.fxml'.";

    }

}
