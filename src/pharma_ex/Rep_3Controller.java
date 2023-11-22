package pharma_ex;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import static pharma_ex.Db.getCon;

public class Rep_3Controller implements Initializable {

     @FXML
    private Button but;

    @FXML
    private Button but1;

    @FXML
    private DatePicker date_dis;

    @FXML
    private ChoiceBox district;

    @FXML
    private ChoiceBox pharmacy;

    @FXML
    private TextField username;
    
    

    
    Connection Con=null;
    PreparedStatement pst=null;
    PreparedStatement pst1=null;
    Statement st=null;
    ResultSet Rs=null;
    @FXML
    private ListView<?> listview;
    @FXML
    private ListView<?> listview2;
    
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
                 district.getItems().addAll(pharmacys);
             }
             
             
        } catch (SQLException e) {
        }
         dist = (String) district.getValue();
        return dist;
    }
    
     /*code segment for getting pharmacy name from pharmacy table for choice box*/
    @FXML
    public void Getpharmacy(){
        try {
             Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             st=Con.createStatement();
             String query2="select * from pharmacy_db.pharmacy WHERE District='"+GetDistrict()+"';";
             Rs=st.executeQuery(query2);
             while(Rs.next()){
                 String pharmacys=Rs.getString("phar_name");
                 pharmacy.getItems().addAll(pharmacys);
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
         pst1.setString(1, (String) pharmacy.getValue());
         Rs=pst1.executeQuery();
         if (Rs.next()) {
             pharmcyid=Rs.getInt(1);
             
        }
       return  pharmcyid;
    }
    
    /*rep id get*/
    int repid() throws SQLException{
        int repid=0;
        String query1="SELECT sales_rep.ID FROM sales_rep INNER JOIN login ON sales_rep.email=login.email WHERE login.username='"+username.getText()+"';";
        Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
        pst1=Con.prepareStatement(query1);
//         pst1.setString(1, (String) pharmacy.getValue());
         Rs=pst1.executeQuery();
         if (Rs.next()) {
             repid=Rs.getInt(1);
             
        }
       return  repid;
    }
    
    /*code segment for adding drugs*/
    @FXML
    void adddrugs(ActionEvent event) {
         try {
             repid();
         } catch (SQLException ex) {
             Logger.getLogger(Rep_3Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             String query="insert into dispatch_date values(default,?,?,?)";
             Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             pst=Con.prepareStatement(query);
            
             
             pst.setInt(1, repid());
             pst.setInt(2, pharmacyid());
             pst.setString(3, date_dis.getEditor().getText());
             int row=pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Next Dispatch Date added succesfully !");
             Con.close();
             clearFields();
             
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
    
    private void clearFields(){
                 username.setText("");
                 pharmacy.setValue(null);
                 district.setValue(null);
                 date_dis.setValue(null);
               
        
    }
    
    @FXML
    void back(ActionEvent event) {
        FxmlLoader.changeScene(event,"Rep_1.fxml");
    }



    void initialize() throws SQLException {
       
GetDistrict();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       GetDistrict();

    }

    

}
