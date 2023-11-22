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

    
public class Pharmacist_2_View {
    
    

    private String phar_name;
    private String district;
    private String address;
    private String contact;
    

   


    Pharmacist_2_View(String phar_name, String district, String address, String contact) {
        this.phar_name = phar_name;
        this.district=district;
        this.address=address;
        this.contact=contact;
    }

    public String getPhar_name() {
        return phar_name;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }
    public String getContact() {
        return contact;
    }

   
  
    
}
