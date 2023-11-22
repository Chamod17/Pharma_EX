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
public class viewPharmacies {

    private int id;
    private String name;
    private String district;
    private String address;
    private String contact;

    

    public String getPhar_name() {
        return name;
    }

    public void setPhar_name(String Phar_name) {
        this.name = Phar_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDrug_name(String District) {
        this.district = District;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String Contact) {
        this.contact = Contact;

    
}viewPharmacies(int Id, String Phar_name, String District, String Address, String Contact) {
         this.id = Id;
         this.name=Phar_name;
         this.district=District;
         this.address=Address;
         this.contact=Contact;
    }
}


    

    

    
    
    

