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

public class Admin_Sales_3Controller {

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
    private TableColumn<viewReps, String> colCompany;

    @FXML
    private TableColumn<viewReps, String> colEmail;

    @FXML
    private TableColumn<viewReps, String> colFname;

    @FXML
    private TableColumn<viewReps, Integer> colID;

    @FXML
    private TableColumn<viewReps, String> colLname;

    @FXML
    private TextField company;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TableView<viewReps> viewRepTable;

    
    int index=-1;
    
    ObservableList<viewReps> list;
    
    
   
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
   
   public ObservableList<viewReps> getDataDrug(){
       
      ObservableList<viewReps> list=FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM sales_rep";
        Statement st;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            
            while(rs.next()){
                viewReps view;
                view = new viewReps(rs.getInt("ID"),rs.getString("Fname"), rs.getString("Lname"),rs.getString("email"),rs.getString("Company"));
                list.add(view);
                
               
            }
        }catch(SQLException e){
            System.out.println(e);
        }
      return list; 
   }
   
   
    public void showPharmacies(){
        ObservableList<viewReps> list = getDataDrug();
        
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
       colFname.setCellValueFactory(new PropertyValueFactory<>("Fname"));
        colLname.setCellValueFactory(new PropertyValueFactory<>("Lname"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCompany.setCellValueFactory(new PropertyValueFactory<>("Company"));
        viewRepTable.setItems(list);
        
       
        
    } 
   int drugidselection=0;
    
     /*code segment for getting selected row from the table to textfields*/
    @FXML
    void getSelected(MouseEvent event){
        index=viewRepTable.getSelectionModel().getSelectedIndex();
        drugidselection= colID.getCellData(index);
        if (index <= -1) {
            return;
        }
        firstName.setText(colFname.getCellData(index));
        lastName.setText(colLname.getCellData(index));
        email.setText(colEmail.getCellData(index));
        company.setText(colCompany.getCellData(index));
    }
    
     @FXML
    void updateRep(ActionEvent event) {
         try {
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
           String value1= firstName.getText();
           String value2=lastName.getText();
           String value3=email.getText();
           String value4=company.getText();
           
           String query3="update sales_rep set Fname= '"+value1+"',Lname= '"+value2+"',email= '"+value3+"',Company= '"+value4+"' where Id='"+drugidselection+"' ";
           com.mysql.jdbc.PreparedStatement ps=(com.mysql.jdbc.PreparedStatement) con.prepareStatement(query3);
           ps.execute();
             JOptionPane.showMessageDialog(null, "Successfully updated !");
             showPharmacies();
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
         }
    }
    
    
    
     @FXML
    void deleteReps(ActionEvent event) {
         try {
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             String query4="delete from sales_rep where Id='"+drugidselection+"' ";
             com.mysql.jdbc.PreparedStatement ps=(com.mysql.jdbc.PreparedStatement) con.prepareStatement(query4);
             ps.execute();
             JOptionPane.showMessageDialog(null, "Successfully deleted !");
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
    void add_rep(ActionEvent event) {
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
    void delete_rep(ActionEvent event) {
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
    void view_rep(ActionEvent event) {
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
        assert addbut != null : "fx:id=\"addbut\" was not injected: check your FXML file 'Admin_Sales_3.fxml'.";
        assert but11 != null : "fx:id=\"but11\" was not injected: check your FXML file 'Admin_Sales_3.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'Admin_Sales_3.fxml'.";
        assert viewbut != null : "fx:id=\"viewbut\" was not injected: check your FXML file 'Admin_Sales_3.fxml'.";
        showPharmacies();
    }

}
