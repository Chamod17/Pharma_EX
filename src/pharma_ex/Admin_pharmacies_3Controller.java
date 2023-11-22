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

public class Admin_pharmacies_3Controller {

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
    private Button btnDrugDelete;
    
    @FXML
    private Button backbut;
    
     @FXML
    private TextField pharAddress;

    @FXML
    private TextField pharContact;

    @FXML
    private TextField pharDistrict;

    @FXML
    private TextField pharName;
    
    
    
   @FXML
    private TableView<viewPharmacies> viewPharTable;
   
   
   
   @FXML
    private TableColumn<viewPharmacies, String> colName;
   
   @FXML
    private TableColumn<viewPharmacies, String> colDistrict;
    
    @FXML
    private TableColumn<viewPharmacies, String> colAddress;

    @FXML
    private TableColumn<viewPharmacies, String> colContact;

     @FXML
    private TableColumn<viewPharmacies, Integer> colID;
    
    int index=-1;
    
    ObservableList<viewPharmacies> list;
    
    
   
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
   
   public ObservableList<viewPharmacies> getDataDrug(){
       
      ObservableList<viewPharmacies> list=FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM pharmacy";
        Statement st;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            
            while(rs.next()){
                viewPharmacies view;
                view = new viewPharmacies(rs.getInt("Id"),rs.getString("Phar_name"), rs.getString("District"),rs.getString("Address"),rs.getString("Contact"));
                list.add(view);
                
               
            }
        }catch(SQLException e){
            System.out.println(e);
        }
      return list; 
   }
   
   
    public void showPharmacies(){
        ObservableList<viewPharmacies> list = getDataDrug();
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
       colName.setCellValueFactory(new PropertyValueFactory<>("Phar_name"));
        colDistrict.setCellValueFactory(new PropertyValueFactory<>("district"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        viewPharTable.setItems(list);
        
       
        
    } 
   int drugidselection=0;
    
     /*code segment for getting selected row from the table to textfields*/
    @FXML
    void getSelected(MouseEvent event){
        index=viewPharTable.getSelectionModel().getSelectedIndex();
        drugidselection=colID.getCellData(index);
        if (index <= -1) {
            return;
        }
        pharName.setText(colName.getCellData(index));
        pharDistrict.setText(colDistrict.getCellData(index));
        pharAddress.setText(colAddress.getCellData(index));
        pharContact.setText(colContact.getCellData(index));
    }
    
     @FXML
    void updateDrug(ActionEvent event) {
         try {
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
           String value1= pharName.getText();
           String value2=pharDistrict.getText();
           String value3=pharAddress.getText();
           String value4=pharContact.getText();
           
           String query3="update pharmacy set Phar_name= '"+value1+"',District= '"+value2+"',Contact= '"+value4+"',Address= '"+value3+"' where Id='"+drugidselection+"' ";
           com.mysql.jdbc.PreparedStatement ps=(com.mysql.jdbc.PreparedStatement) con.prepareStatement(query3);
           ps.execute();
             JOptionPane.showMessageDialog(null, "Succefully Updated !");
             showPharmacies();
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
         }
    }
    
    
    
     @FXML
    void deleteDrug(ActionEvent event) {
         try {
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             String query4="delete from pharmacy where Id='"+drugidselection+"' ";
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
        assert addbut != null : "fx:id=\"addbut\" was not injected: check your FXML file 'Admin_pharmacies_3.fxml'.";
        assert but11 != null : "fx:id=\"but11\" was not injected: check your FXML file 'Admin_pharmacies_3.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'Admin_pharmacies_3.fxml'.";
        assert viewbut != null : "fx:id=\"viewbut\" was not injected: check your FXML file 'Admin_pharmacies_3.fxml'.";
        
        showPharmacies();
    }

}
