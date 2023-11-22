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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class Rep_1Controller {
//-----------------------------------------
//    ObservableList<drugs> listM;
//    int index = -1;
//-----------------------------------------
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button searchbut;

    @FXML
    private Button searchbut1;

    @FXML
    private TableColumn<Drugs, String> colid;

    @FXML
    private TableColumn<Drugs, String> col_brand;

    @FXML
    private TableColumn<Drugs, String> colname;

    @FXML
    private TableColumn<Drugs, String> col_pharmacyID;

    @FXML
    private TableColumn<Drugs, String> col_quantity;

    @FXML
    private TableColumn<Drugs, String> col_availability;

    @FXML
    private TableView<Drugs> table_drugs;
    
    @FXML
    private ChoiceBox district;

    @FXML
    private ChoiceBox pharmacy;
    
    @FXML
    private Button select_dis;

    
    Connection Con=null;
    PreparedStatement pst1=null;
    Statement st=null;
    ResultSet Rs=null;

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
    public void Getpharmacy(){
        try {
             Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");
             st=Con.createStatement();
             String query2="select * from pharmacy_db.pharmacy WHERE District='"+(String)district.getValue()+"';";
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






//________________________________________________


    @FXML
    void back(ActionEvent event) {
        try {
            Parent table = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene tableview = new Scene(table);
            
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(Rep_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void nextdateod(ActionEvent event) throws IOException {
       Parent table = FXMLLoader.load(getClass().getResource("Rep_3.fxml"));
        Scene tableview = new Scene(table);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableview);
        window.show();

    }

    @FXML
    void view_details() {

            try {
                String query="select drugs.drug_id,drugs.drug_name,drugs.brand,drugs.quantity,drugs.phar_id, pharmacy.Phar_name,pharmacy.District  from drugs INNER JOIN pharmacy ON drugs.phar_id = pharmacy.Id where drugs.phar_id='"+pharmacyid()+"'";
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_db", "root", "");

                pst=con.prepareStatement(query);
               

                rs=pst.executeQuery();

                ObservableList<Drugs> drugs = FXCollections.observableArrayList();

//                if(rs.next()) {

                    while (rs.next()) {

                        Drugs dg;
                        dg = new Drugs(rs.getInt("drug_id"),rs.getString("drug_name"),rs.getString("brand"),rs.getInt("quantity"));
                        drugs.add(dg);

                        table_drugs.setItems(drugs);

                        colid.setCellValueFactory(new PropertyValueFactory<>("id"));                        
                        colname.setCellValueFactory(new PropertyValueFactory<>("name"));                        
                        col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));                       
                        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                        clearFields();
                    }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data not found !");
                clearFields();
                Logger.getLogger(Rep_1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
private void clearFields(){
        pharmacy.getItems().clear();
        
        pharmacy.setValue(null);
        district.setValue(null);
    }
   // new table view

    @FXML
    void initialize() {
        assert searchbut != null : "fx:id=\"searchbut\" was not injected: check your FXML file 'Rep_1.fxml'.";
        assert searchbut1 != null : "fx:id=\"searchbut1\" was not injected: check your FXML file 'Rep_1.fxml'.";
        GetDistrict();

    }

}
