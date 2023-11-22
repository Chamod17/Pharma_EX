package pharma_ex;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Admin_pharmacists_3Controller {

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
    private TableColumn<viewPharmacists, String> colContact;

    @FXML
    private TableColumn<viewPharmacists, String> colEmail;

    @FXML
    private TableColumn<viewPharmacists, String> colFname;

    @FXML
    private TableColumn<viewPharmacists, Integer> colID;

    @FXML
    private TableColumn<viewPharmacists, String> colLname;

    @FXML
    private TableColumn<viewPharmacists, String> colPharmacy;

    @FXML
    private TextField contact;

    @FXML
    private TextField name;

    @FXML
    private TextField lname;

    @FXML
    private TableView<viewPharmacists> viewPharmacists;
    
    int index=-1;
    
    ObservableList<viewPharmacists> list;
    
    
   
   public Connection getConnection(){
        
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db","root","");
            return conn;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
        
    }
   
   public ObservableList<viewPharmacists> getDataDrug(){
       
      ObservableList<viewPharmacists> list=FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT pharmacist.pharmacist_id,pharmacist.F_name,pharmacist.L_name,pharmacist.email,pharmacist.contact,pharmacy.phar_name FROM pharmacist INNER JOIN pharmacy ON pharmacist.pharmacy=pharmacy.Id";
        Statement st;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            
            while(rs.next()){
                viewPharmacists view;
                view = new viewPharmacists(rs.getInt("pharmacist_id"),rs.getString("F_name"), rs.getString("L_name"),rs.getString("email"),rs.getString("phar_name"),rs.getString("contact"));
                list.add(view);
                
               
            }
        }catch(SQLException e){
            System.out.println(e);
        }
      return list; 
   }
   
   
    public void showPharmacies(){
        ObservableList<viewPharmacists> list = getDataDrug();
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
       colFname.setCellValueFactory(new PropertyValueFactory<>("fname"));
       colLname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        colPharmacy.setCellValueFactory(new PropertyValueFactory<>("pharmacy"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        viewPharmacists.setItems(list);
        
       
        
    } 
   int drugidselection=0;
    
     /*code segment for getting selected row from the table to textfields*/
    @FXML
    void getSelected(MouseEvent event){
        index=viewPharmacists.getSelectionModel().getSelectedIndex();
        drugidselection=colID.getCellData(index);
        if (index <= -1) {
            return;
        }
        name.setText(colFname.getCellData(index));
        lname.setText(colLname.getCellData(index));
        contact.setText(colContact.getCellData(index));
        
    }
    
     @FXML
    void updateDrug(ActionEvent event) {
         try {
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
           String value1= name.getText();
           String value2=lname.getText();
           String value3=contact.getText();
           
           
           String query3="update pharmacist set F_name= '"+value1+"',L_name= '"+value2+"',contact= '"+value3+"' where pharmacist_id='"+drugidselection+"' ";
           com.mysql.jdbc.PreparedStatement ps=(com.mysql.jdbc.PreparedStatement) con.prepareStatement(query3);
           ps.execute();
             JOptionPane.showMessageDialog(null, "update successful");
             showPharmacies();
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
         }
    }
    
    
    
     @FXML
    void deleteDrug(ActionEvent event) {
         try {
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             String query4="delete from pharmacist where pharmacist_id='"+drugidselection+"' ";
             com.mysql.jdbc.PreparedStatement ps=(com.mysql.jdbc.PreparedStatement) con.prepareStatement(query4);
             ps.execute();
             JOptionPane.showMessageDialog(null, "delete successful");
             showPharmacies();
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }

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

    @FXML
    void initialize() {
        assert addbut != null : "fx:id=\"addbut\" was not injected: check your FXML file 'Admin_pharmacists_3.fxml'.";
        assert but11 != null : "fx:id=\"but11\" was not injected: check your FXML file 'Admin_pharmacists_3.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'Admin_pharmacists_3.fxml'.";
        assert viewbut != null : "fx:id=\"viewbut\" was not injected: check your FXML file 'Admin_pharmacists_3.fxml'.";
        showPharmacies();
    }

}
