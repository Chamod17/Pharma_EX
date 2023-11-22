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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CHAMOD
 */
public class Pharmacist_5Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    FXMLDocumentController con = new FXMLDocumentController();
    String uname = con.username;
    
    @FXML
    private TableColumn<Unavailable, String> col_brand;

    @FXML
    private TableColumn<Unavailable, Integer> col_district;

    @FXML
    private TableColumn<Unavailable, String> col_name;

    @FXML
    private TableColumn<Unavailable, String> col_pharmacy;

    @FXML
    private TableColumn<Unavailable, Integer> col_quantity;

    @FXML
    private TableView<Unavailable> table;
    
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
    
    
     @FXML
    private void handleAddAction(ActionEvent event) {
      
        
        showPrices();
        
    }
     public ObservableList<Unavailable> getProductList(){
        ObservableList<Unavailable> productList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT drugs.drug_name, drugs.brand, drugs.quantity, pharmacy.Phar_name,pharmacy.District FROM drugs INNER JOIN pharmacy ON drugs.phar_id= pharmacy.Id WHERE drugs.quantity>0;";
        Statement st;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            
            while(rs.next()){
                Unavailable unavailable;
                unavailable = new Unavailable(rs.getString("drug_name"), rs.getString("brand"),rs.getString("phar_name"),rs.getString("district"),rs.getInt("quantity"));
                productList.add(unavailable);
                
                System.out.println(unavailable.phar_name);
                System.out.println(unavailable.district);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return productList;
}
    public void showPrices(){
        ObservableList<Unavailable> list = getProductList();
       col_name.setCellValueFactory(new PropertyValueFactory<>("drug_name"));
        col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_pharmacy.setCellValueFactory(new PropertyValueFactory<>("phar_name"));
        col_district.setCellValueFactory(new PropertyValueFactory<>("district"));
        table.setItems(list);
        
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
            Logger.getLogger(Pharmacist_5Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Pharmacist_5Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            showPrices();
            System.out.println(uname);
            
        } catch (IOException ex) {
            Logger.getLogger(Pharmacist_5Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Pharmacist_5Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @FXML
    void back(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(Pharmacist_5Controller.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        showPrices();
    }    
    
}
