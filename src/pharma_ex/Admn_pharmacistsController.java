package pharma_ex;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Admn_pharmacistsController {
     @FXML
    private Button addbut;

    @FXML
    private ChoiceBox choice_pharmacy;
    
    @FXML
    private ChoiceBox choice_district;

    @FXML
    private TextField contact;

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
    private Button update;

    @FXML
    private Button viewbut;

   
    
    
    Connection Con=null;
    PreparedStatement pst=null;
    PreparedStatement pst1=null;
    PreparedStatement pst2=null;
    Statement st=null;
    ResultSet Rs=null;
    
     //get district
    public String GetDistrict(){
        String dist = null;
        try {
             Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             st=Con.createStatement();
             String query2="select DISTINCT(District) from pharmacy_db.pharmacy";
             Rs=st.executeQuery(query2);
             while(Rs.next()){
                 String pharmacys=Rs.getString("District");
                 choice_district.getItems().addAll(pharmacys);
             }
             
             
        } catch (SQLException e) {
        }
         dist = (String) choice_district.getValue();
        return dist;
    }
    
    
    /*code segment for getting pharmacy name from pharmacy table for choice box*/
    public void Getpharmacy(){
        try {
             Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             st=Con.createStatement();
             String query2="select * from pharmacy_db.pharmacy WHERE District='"+GetDistrict()+"';";
             Rs=st.executeQuery(query2);
             while(Rs.next()){
                 String pharmacys=Rs.getString("phar_name");
                 choice_pharmacy.getItems().addAll(pharmacys);
             }
             
        } catch (SQLException e) {
        }
    }
    
    /*code segment for getting relevant pharmacy id for selected pharmacy name*/
    int pharmacyid() throws SQLException{
        int pharmcyid=0;
        String query1="SELECT Id FROM pharmacy WHERE phar_name=?";
        Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
        pst1=Con.prepareStatement(query1);
         pst1.setString(1, (String) choice_pharmacy.getValue());
         Rs=pst1.executeQuery();
         if (Rs.next()) {
             pharmcyid=Rs.getInt(1);
             
        }
       return  pharmcyid;
    }
    
     /*code segment for adding drugs*/
    @FXML
    void adddrugs(ActionEvent event) {
         try {
             String query="insert into pharmacist values(default,?,?,?,?,?)";
             Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             pst=Con.prepareStatement(query);
            
             pst.setString(1, fname.getText());
             pst.setString(2, lname.getText());
             pst.setString(3, email.getText());
             pst.setInt(4, pharmacyid());
             pst.setString(5, contact.getText());
             
             int row=pst.executeUpdate();
             String query2="insert into login values(default,?,?,?,?)";
             Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             pst2=Con.prepareStatement(query2);
             pst2.setString(1, email.getText());
             pst2.setString(2, "Pharmacist");
             pst2.setString(3, u_name.getText());
             pst2.setString(4, password.getText());
             
             int row1=pst2.executeUpdate();
             JOptionPane.showMessageDialog(null, "Pharmacist was added to the system succefully !");
             Con.close();
             clearFields();
             
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
    
    
    @FXML
    void add_pharmacists(ActionEvent event) {
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
    void delete_pharmacists(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Admin_pharmacists_3.fxml"));
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
    void view_pharmacists(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Admin_pharmacists_2.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminButController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void clearFields(){
        fname.setText("");
        lname.setText("");
        email.setText("");
        contact.setText("");
        password.setText("");
        u_name.setText("");
        choice_pharmacy.setValue(null);
        choice_district.setValue(null);
    }
    @FXML
    void initialize() {
       
        GetDistrict();
    }

}
