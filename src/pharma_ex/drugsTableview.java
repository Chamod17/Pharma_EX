/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma_ex;

/**
 *
 * @author kt356
 */
public class drugsTableview {
    int drug_id;
    String drug_name,brand;
    String phar_name;
    int quantity;

    public String getPhar_name() {
        return phar_name;
    }

    public void setPhar_name(String phar_name) {
        this.phar_name = phar_name;
    }


    public int getDrugID() {
        return drug_id;
    }

    public void setDrugID(int drug_id) {
        this.drug_id = drug_id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public drugsTableview(int id, String drug_name, String brand,String phar_name, int quantity) {
        this.drug_id = id;
        this.drug_name = drug_name;
        this.brand = brand;
        this.phar_name=phar_name;
        this.quantity = quantity;
    }
}
