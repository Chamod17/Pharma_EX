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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Admin_Sales_2Controller {

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
    
    @FXML
    private TableColumn<viewReps, Integer> colID;
    @FXML
    private TableColumn<viewReps, String> col_company;

    @FXML
    private TableColumn<viewReps, String> col_email;

    @FXML
    private TableColumn<viewReps, String> col_fname;

    @FXML
    private TableColumn<viewReps, String> col_lname;

    @FXML
    private TableView<viewReps> repTableview;
    
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
    
    public ObservableList<viewReps> getPharmacies(){
        ObservableList<viewReps> productList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT ID,Fname,Lname,email,Company FROM sales_rep";
        Statement st;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            
            while(rs.next()){
                viewReps view;
                view = new viewReps(rs.getInt("ID"), rs.getString("Fname"),rs.getString("Lname"),rs.getString("email"),rs.getString("Company"));
                productList.add(view);
                System.out.println(rs.getInt("ID"));
                
               
            }
        }catch(SQLException e){
            System.out.println(e);
        }return productList;
    }
    public void showPharmacies(){
        ObservableList<viewReps> list = getPharmacies();
       
       colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_fname.setCellValueFactory(new PropertyValueFactory<>("Fname"));
        col_lname.setCellValueFactory(new PropertyValueFactory<>("Lname"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_company.setCellValueFactory(new PropertyValueFactory<>("Company"));
        repTableview.setItems(list);
        
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
        assert addbut != null : "fx:id=\"addbut\" was not injected: check your FXML file 'Admin_Sales_2.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'Admin_Sales_2.fxml'.";
        assert viewbut != null : "fx:id=\"viewbut\" was not injected: check your FXML file 'Admin_Sales_2.fxml'.";
showPharmacies();
    }

}
