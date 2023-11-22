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

public class Admin_pharmacies_2Controller {

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
    private TableColumn<Pharmacist_2_View, String> address;

   

    @FXML
    private TableColumn<Pharmacist_2_View, String> contact;

    @FXML
    private TableColumn<Pharmacist_2_View, String> district;

    @FXML
    private TableColumn<Pharmacist_2_View, String> phar_name;

    @FXML
    private TableView<Pharmacist_2_View> phar_table;
    
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
    
    public ObservableList<Pharmacist_2_View> getPharmacies(){
        ObservableList<Pharmacist_2_View> productList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM pharmacy";
        Statement st;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            
            while(rs.next()){
                Pharmacist_2_View view;
                view = new Pharmacist_2_View(rs.getString("Phar_name"), rs.getString("District"),rs.getString("Address"),rs.getString("Contact"));
                productList.add(view);
                
               
            }
        }catch(SQLException e){
            System.out.println(e);
        }return productList;
    }
    public void showPharmacies(){
        ObservableList<Pharmacist_2_View> list = getPharmacies();
       phar_name.setCellValueFactory(new PropertyValueFactory<>("phar_name"));
        district.setCellValueFactory(new PropertyValueFactory<>("district"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        phar_table.setItems(list);
        
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
        assert addbut != null : "fx:id=\"addbut\" was not injected: check your FXML file 'Admin_pharmacies_2.fxml'.";
        assert but11 != null : "fx:id=\"but11\" was not injected: check your FXML file 'Admin_pharmacies_2.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'Admin_pharmacies_2.fxml'.";
        assert viewbut != null : "fx:id=\"viewbut\" was not injected: check your FXML file 'Admin_pharmacies_2.fxml'.";
        showPharmacies();
    }

}
