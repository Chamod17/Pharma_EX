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

public class Admin_pharmacists_2Controller {

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
    private TableColumn<Admin_pharmacist_View, String> col_contact;

    @FXML
    private TableColumn<Admin_pharmacist_View, String> col_district;

    @FXML
    private TableColumn<Admin_pharmacist_View, String> col_email;

    @FXML
    private TableColumn<Admin_pharmacist_View, String> col_fname;

    @FXML
    private TableColumn<Admin_pharmacist_View, String> col_id;

    @FXML
    private TableColumn<Admin_pharmacist_View, String> col_lname;

    @FXML
    private TableColumn<Admin_pharmacist_View, String> col_pharmacy;

    @FXML
    private TableView<Admin_pharmacist_View> pharmacist_table;
    
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
    
    public ObservableList<Admin_pharmacist_View> getProductList(){
        ObservableList<Admin_pharmacist_View> productList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT pharmacist.pharmacist_id, pharmacist.F_name, pharmacist.L_name,pharmacist.email,pharmacist.contact, pharmacy.Phar_name,pharmacy.District FROM pharmacist INNER JOIN pharmacy ON pharmacist.pharmacy= pharmacy.Id;";
        Statement st;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            
            while(rs.next()){
                Admin_pharmacist_View view;
                view = new Admin_pharmacist_View(rs.getInt("pharmacist_id"), rs.getString("F_name"),rs.getString("L_name"),rs.getString("email"),rs.getString("contact"),rs.getString("Phar_name"),rs.getString("District"));
                productList.add(view);
                String d = view.district;
        
        System.out.println(d);
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return productList;

}
    
    
    
    
    public void showPrices(){
        ObservableList<Admin_pharmacist_View> list = getProductList();
       col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_fname.setCellValueFactory(new PropertyValueFactory<>("f_name"));
        col_lname.setCellValueFactory(new PropertyValueFactory<>("l_name"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        col_pharmacy.setCellValueFactory(new PropertyValueFactory<>("phar_name"));
        col_district.setCellValueFactory(new PropertyValueFactory<>("district"));
        pharmacist_table.setItems(list);  
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

    @FXML
    void initialize() {
        assert addbut != null : "fx:id=\"addbut\" was not injected: check your FXML file 'Admin_pharmacists_2.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'Admin_pharmacists_2.fxml'.";
        assert viewbut != null : "fx:id=\"viewbut\" was not injected: check your FXML file 'Admin_pharmacists_2.fxml'.";
        showPrices();
    }

}
