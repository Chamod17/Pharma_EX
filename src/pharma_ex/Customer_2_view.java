/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma_ex;

/**
 *
 * @author CHAMOD
 */

    
public class Customer_2_view {
    
    

    private String drug_name;
    private int quantity;
    private String brand;
    private String phar_name;
    private String district;

    
    public Customer_2_view(String drug_name,String brand,String phar_name, String district,int quantity) {
        this.drug_name = drug_name;
        this.brand =brand;
        this.quantity=quantity;
        this.phar_name=phar_name;
        this.district=district;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBrand() {
        return brand;
    }

    /**
     *
     * @return
     */
    public String getPhar_name() {
        return phar_name;
    }
    public String getDistrict() {
        return district;
    }
  
    
}
