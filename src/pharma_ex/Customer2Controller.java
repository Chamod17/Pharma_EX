 package pharma_ex;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Customer2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableColumn<Unavailable, String> col_brand;

    @FXML
    private TableColumn<Unavailable, String> col_district;

    @FXML
    private TableColumn<Unavailable, String> col_name;

    @FXML
    private TableColumn<Unavailable, String> col_pharmacy;
    
   

    @FXML
    private TableColumn<Unavailable, Integer> col_quantity;

    @FXML
    private TableView<Unavailable> table;
    
    @FXML
    private TextField drug_n;
    
     @FXML
    private Button search;
    
    String drug_nm ;
  
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
   
     public ObservableList<Unavailable> getProductList(){
        ObservableList<Unavailable> productList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT drugs.drug_name, drugs.brand, drugs.quantity, pharmacy.Phar_name,pharmacy.District FROM drugs INNER JOIN pharmacy ON drugs.phar_id= pharmacy.Id WHERE drugs.drug_name='"+drug_nm+"';";
        Statement st;
        ResultSet rs;
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
        try{
       ObservableList<Unavailable> view = getProductList();
       col_name.setCellValueFactory(new PropertyValueFactory<>("drug_name"));
        col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        col_pharmacy.setCellValueFactory(new PropertyValueFactory<>("phar_name"));
        col_district.setCellValueFactory(new PropertyValueFactory<>("district"));
        table.setItems(view);
        
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("asa");

        }
    }
    
    public void search(){
        drug_nm = drug_n.getText();
        
        
        showPrices();
        
       }

    @FXML
    void back_main(ActionEvent event) throws IOException {
        Parent table = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableview = new Scene(table);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableview);
        window.show();
    }

    @FXML
    void findalter(ActionEvent event) throws IOException {
        
        Parent table = FXMLLoader.load(getClass().getResource("Cus_3.fxml"));
        Scene tableview = new Scene(table);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableview);
      
        window.show();
    }

    @FXML
    void print(ActionEvent event) throws IOException {
        Parent table = FXMLLoader.load(getClass().getResource("Cus_4.fxml"));
        Scene tableview = new Scene(table);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableview);
        window.show();
    }

    @FXML
    void initialize() {
        
       
        
        

    }

}
