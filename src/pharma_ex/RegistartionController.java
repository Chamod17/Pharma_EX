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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RegistartionController {
     @FXML
    private Button btnreg;

    @FXML
    private Button but;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtdistrict;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtfname;

    @FXML
    private TextField txtlname;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtuser;
    
    String usertype ="Customer";
    
//    Connection con;
//    PreparedStatement pst;
    Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sf=cfg.buildSessionFactory();


    @FXML
    void signup(ActionEvent event) {
        
    User user=new User();
    Login a=new Login();

    user.setFirstname(txtfname.getText());
    user.setLastname(txtlname.getText());
    user.setEmail(txtemail.getText());
    user.setAddress(txtaddress.getText());
    user.setDistrict(txtdistrict.getText());
    a.setEmail(txtemail.getText());
    a.setUsername(txtuser.getText());
    a.setPassword(txtpassword.getText());
    a.setusertype(usertype);
    
    Session session=sf.openSession();
    session.beginTransaction();
    
    session.save(user);
    session.save(a);
    
    session.getTransaction().commit();
    session.close();
    
    JOptionPane.showMessageDialog(null, "Registration Succesful");
    clearFields();
    
    
    
    
    



//        
//        String fname=txtfname.getText();
//        String lname=txtlname.getText();
//        String uname=txtuser.getText();
//        String pwrd=txtpassword.getText();
//        String email=txtemail.getText();
//        String address=txtaddress.getText();
//        String district=txtdistrict.getText();
//        
//         try {
//             Class.forName("com.mysql.jdbc.Driver");
//             String query="INSERT INTO consumer(Firstname,Lastname,username,password,Email,Address,District) values(?,?,?,?,?,?,?)";
//             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
//             pst=con.prepareStatement(query);
//             pst.setString(1, fname);
//             pst.setString(2, lname);
//             pst.setString(3, uname);
//             pst.setString(4, pwrd);
//             pst.setString(5, email);
//             pst.setString(6, address);
//             pst.setString(7, district);
//             int status=pst.executeUpdate();
//             
//             if (status==1) {
//                 JOptionPane.showMessageDialog(null, "Successfully signed up");
//                 
//                 String query1="INSERT INTO user(Firstname,Lastname,username,password) SELECT Firstname,Lastname,username,password FROM consumer";
//                 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
//                  pst=con.prepareStatement(query1);
//                  int status2=pst.executeUpdate();
//                 txtaddress.setText("");
//                 txtfname.setText("");
//                 txtlname.setText("");
//                 txtemail.setText("");
//                 txtuser.setText("");
//                 txtpassword.setText("");
//                 txtdistrict.setText("");
//             }
//             else{
//                 JOptionPane.showMessageDialog(null, "Sign up failed");
//             }
//         } catch (ClassNotFoundException ex) {
//             Logger.getLogger(RegistartionController.class.getName()).log(Level.SEVERE, null, ex);
//         } catch (SQLException ex) {
//             Logger.getLogger(RegistartionController.class.getName()).log(Level.SEVERE, null, ex);
//         }
    }
    
    private void clearFields(){
        txtaddress.setText("");
                 txtfname.setText("");
                 txtlname.setText("");
                txtemail.setText("");
               txtuser.setText("");
               txtpassword.setText("");
               txtdistrict.setText("");
        
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button but2;
    
    @FXML
    private void handlehyperAction(ActionEvent event) throws IOException {
         Parent table = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableview = new Scene(table);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableview);
        window.show();
        
    }

    @FXML
    void initialize() {
        

    }
    
    

}
