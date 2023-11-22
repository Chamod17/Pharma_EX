package pharma_ex;

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class Pharamacist_3Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnDrugDelete;

    

    @FXML
    private Button backbut;
    
     @FXML
    private TextField drugBrand;

    @FXML
    private TextField drugName;

    @FXML
    private TextField drugQuantity;
    
     @FXML
    private ChoiceBox choicePharmacy;
    
   @FXML
    private TableView<drugsTableview> drugTableView;
   
   @FXML
    private TableColumn<drugsTableview, Integer> colID;
   
   @FXML
    private TableColumn<drugsTableview, String> colName;
   
   @FXML
    private TableColumn<drugsTableview, String> colBrand;
    
    @FXML
    private TableColumn<drugsTableview, String> colpharm_id;

    @FXML
    private TableColumn<drugsTableview, Integer> colQuantity;

   
    
    int index=-1;
    
    ObservableList<drugsTableview> listm;
    
    
   
   Connection Con=null;
   Statement St=null;
   ResultSet Rs=null;
   
   public ObservableList<drugsTableview> getDataDrug(){
       ObservableList<drugsTableview> list=FXCollections.observableArrayList();
       try {
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
           PreparedStatement ps=(PreparedStatement) con.prepareStatement("SELECT drugs.drug_id, drugs.drug_name, drugs.brand, pharmacy.phar_name,drugs.quantity FROM drugs INNER JOIN pharmacy ON drugs.phar_id= pharmacy.Id");
           Rs=ps.executeQuery();
           while (Rs.next()) {
              list.add(new drugsTableview(Integer.parseInt(Rs.getString("drug_id")),Rs.getString("drug_name"),Rs.getString("brand"),Rs.getString("phar_name"),Integer.parseInt(Rs.getString("quantity"))));
               
           }
           
           
           
       } catch (Exception e) {
       }
      return list; 
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
            Logger.getLogger(Pharamacist_3Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Pharamacist_3Controller.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (IOException ex) {
            Logger.getLogger(Pharamacist_3Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Pharamacist_3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int drugidselection=0;
    
     /*code segment for getting selected row from the table to textfields*/
    @FXML
    void getSelected(MouseEvent event){
        index=drugTableView.getSelectionModel().getSelectedIndex();
        drugidselection=colID.getCellData(index);
        if (index <= -1) {
            return;
        }
        drugName.setText(colName.getCellData(index).toString());
        drugBrand.setText(colBrand.getCellData(index).toString());
        drugQuantity.setText(colQuantity.getCellData(index).toString());
    }
    
     @FXML
    void updateDrug(ActionEvent event) {
         try {
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
           String value1=drugName.getText();
           String value2=drugBrand.getText();
           String value3=drugQuantity.getText();
           
           String query3="update drugs set drug_name= '"+value1+"',brand= '"+value2+"',quantity= '"+value3+"' where drug_id='"+drugidselection+"' ";
           PreparedStatement ps=(PreparedStatement) con.prepareStatement(query3);
           ps.execute();
             JOptionPane.showMessageDialog(null, "update successful");
             updateTable();
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
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
            Logger.getLogger(Pharamacist_3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @FXML
    void deleteDrug(ActionEvent event) {
         try {
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             String query4="delete from drugs where drug_id='"+drugidselection+"' ";
             PreparedStatement ps=(PreparedStatement) con.prepareStatement(query4);
             ps.execute();
             JOptionPane.showMessageDialog(null, "delete successful");
             updateTable();
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }

    }
    
    public void updateTable(){
colID.setCellValueFactory(new PropertyValueFactory<drugsTableview,Integer>("DrugID"));
colName.setCellValueFactory(new PropertyValueFactory<drugsTableview,String>("drug_name"));
colBrand.setCellValueFactory(new PropertyValueFactory<drugsTableview,String>("brand"));
colpharm_id.setCellValueFactory(new PropertyValueFactory<drugsTableview,String>("phar_name"));
colQuantity.setCellValueFactory(new PropertyValueFactory<drugsTableview,Integer>("quantity"));
listm=getDataDrug();
drugTableView.setItems(listm);
    }

    
    
    
    

    @FXML
    void initialize() {
        assert backbut != null : "fx:id=\"backbut\" was not injected: check your FXML file 'Pharamacist_3.fxml'.";

updateTable();
    }

}
