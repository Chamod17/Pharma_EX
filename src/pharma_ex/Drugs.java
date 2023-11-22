package pharma_ex;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Drugs
{
    private int id;
    private String name;
    private String brand;
    private int quantity;
    

    public Drugs(int drug_id, String drug_name, String brand, int quantity )
    {
        this.id= drug_id;
        this.name =drug_name;
        this.brand=brand;
        this.quantity=quantity;
        
        
        
    }

    Drugs() {
         //To change body of generated methods, choose Tools | Templates.
    }

   
    public int getId(){
        return id;
        
    }
    public void setId(int drug_id){
        this.id = drug_id;
    }
    
    public String getName(){
        return name;
        
    }
    public void setName(String drug_name){
        this.name = drug_name;
    }
    
    public String getBrand(){
        return brand;
        
    }
    public void setBrand(String brand){
        this.brand = brand;
    }

    public int getQuantity(){
        return quantity;
        
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
//    public StringProperty didProperty() { return drug_id; }
//    public String getId() { return drug_id.get(); }
//    public void setId(String newId) { drug_id.set(newId); }
//
//    public StringProperty dnameProperty() { return drug_name; }
//    public String getName() { return drug_name.get(); }
//    public void setName(String newName) { drug_name.set(newName); }
//
//    public StringProperty brandProperty() { return brand; }
//    public String getBrand() { return brand.get(); }
//    public void setBrand(String newBrand) { brand.set(newBrand); }
//
//    public StringProperty pidProperty() { return phar_id; }
//    public String getPid() { return phar_id.get(); }
//    public void setPid(String newPid) { phar_id.set(newPid); }
//
//    public StringProperty quantityProperty() { return quantity; }
//    public String getQuantity() { return quantity.get(); }
//    public void setQuantity(String newQuantity) { quantity.set(newQuantity); }

   
}