/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma_ex;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author CHAMOD
 */
public class FXMLDocumentController implements Initializable {
    
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    
     @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button but;

    @FXML
    private Hyperlink link;
    
    @FXML
    private Label UserTypeLabel;
    
    @FXML
    private ChoiceBox UserTypeBox;
    
    @FXML
     TextField txtuser;
    @FXML
    private TextField txtpassword;
    
    private final String[] users={"Admin","Customer","Pharmacist","Sales Rep"};
    String username;
    
    
    
    
    
    
    
    
    
    
    
    

   @FXML
    public void changescreen(ActionEvent event) throws IOException{
       
    }
    
  
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
         Parent table = FXMLLoader.load(getClass().getResource("Registartion.fxml"));
        Scene tableview = new Scene(table);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableview);
        window.show();
    
    }
    
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        
        if (txtuser.getText().equals("") && txtpassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Usename and Password Blank");
        }
        else{
        try {
            String query="SELECT * FROM login WHERE username=? and password=? and usertype=?";
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
            pst=con.prepareStatement(query);
            pst.setString(1, txtuser.getText());
            pst.setString(2, txtpassword.getText());
            pst.setString(3, (String) UserTypeBox.getValue());
            rs=pst.executeQuery();
            if (rs.next()) {
                if (UserTypeBox.getValue()=="Admin") {
                    Parent table = FXMLLoader.load(getClass().getResource("AdminBut.fxml"));
                    Scene tableview = new Scene(table);
        
        
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(tableview);
                    window.show();
                }
                
                else if (UserTypeBox.getValue()=="Customer") {
                    Parent table = FXMLLoader.load(getClass().getResource("Customer2.fxml"));
                    Scene tableview = new Scene(table);
        
        
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(tableview);
                    window.show();
                }
                else if (UserTypeBox.getValue()=="Pharmacist") {
                    Parent table = FXMLLoader.load(getClass().getResource("Pharmacist_2.fxml"));
                    Scene tableview = new Scene(table);
        
        
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(tableview);
                    window.show();
                }
                else if (UserTypeBox.getValue()=="Sales Rep") {
                    Parent table = FXMLLoader.load(getClass().getResource("Rep_1.fxml"));
                    Scene tableview = new Scene(table);
        
        
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(tableview);
                    window.show();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Login failed please Try Again");
            }
            
            
        } catch (HeadlessException | IOException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
        username = txtuser.getText();
        System.out.println(username);
        txtuser.setText("");
        txtpassword.setText("");
        
        
       
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserTypeBox.getItems().addAll(users);
        
        UserTypeBox.setValue("Customer");
        
        String username = txtuser.getText();
        System.out.println(username);
    }    
    
}
