/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma_ex;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author CHAMOD
 */
public class Pharmacist_4Controller implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
    
     @FXML
    private Button backbut;

    @FXML
    private Button btnAddDrugs;

    @FXML
    private ChoiceBox choicePharmacy;

    @FXML
    private TextField drugBrand;

    @FXML
    private TextField drugName;

    @FXML
    private TextField drugQuantity;
    
    Connection Con=null;
    PreparedStatement pst=null;
    PreparedStatement pst1=null;
    Statement st=null;
    ResultSet Rs=null;
    
    /*code segment for getting pharmacy name from pharmacy table for choice box*/
    public void Getpharmacy(){
        try {
             Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             st=Con.createStatement();
             String query2="select * from pharmacy_db.pharmacy";
             Rs=st.executeQuery(query2);
             while(Rs.next()){
                 String pharmacys=Rs.getString("phar_name");
                 choicePharmacy.getItems().addAll(pharmacys);
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
         pst1.setString(1, (String) choicePharmacy.getValue());
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
             String query="insert into drugs values(default,?,?,?,?)";
             Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             pst=Con.prepareStatement(query);
            
             pst.setString(1, drugName.getText());
             pst.setString(2, drugBrand.getText());
             pst.setInt(3, pharmacyid());
             pst.setInt(4, Integer.valueOf(drugQuantity.getText()));
             int row=pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Drug successfully added");
             Con.close();
             clearFields();
             
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
    
    @FXML
    void unavailable(ActionEvent event) {
        
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Pharmacist_2.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(Pharmacist_4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    @FXML
    void add(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Pharmacist_4.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(Pharmacist_4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void available(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Pharmacist_5.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(Pharmacist_4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void update(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("Pharamacist_3.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(Pharmacist_4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @FXML
    void back(ActionEvent event) throws SQLException {
        pharmacyid();
        try {
            
            Parent table = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(Pharmacist_4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void clearFields(){
        drugBrand.setText("");
                 drugName.setText("");
                 drugQuantity.setText("");
                 choicePharmacy.setValue(null);
               
        
    }
    
//    @FXML
//    void adddrugs(ActionEvent event){
//        
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Getpharmacy();
    }    
    
}
