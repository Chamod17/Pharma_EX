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

    
public class Unavailable {
    
    

    private String drug_name;
    private int quantity;
    private String brand;
    String phar_name;
    String district;

    /**
     *
     * @param drug_name
     * @param brand
     * @param phar_id
     * @param quantity
     */
    public Unavailable(String drug_name,String brand,String phar_name, String district,int quantity) {
        this.drug_name = drug_name;
        this.brand =brand;
        this.quantity=quantity;
        this.phar_name=phar_name;
        this.district=district;
    }

    Unavailable(String string, String string0, String string1, String string2, int aInt, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
