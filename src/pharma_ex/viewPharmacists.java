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
public class viewPharmacists {
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String pharmacy;
    private String contact;
    
    public int getId() {
        return id;
    }
    public void setId(int Id) {
        this.id = Id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname=fname;
    }
     public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname=lname;
    }
     public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }
     public String getPharmacy() {
        return pharmacy;
    }
    public void setPharmacy(String pharmacy) {
        this.pharmacy=pharmacy;
    }
     public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact=contact;
    }
    

  

    viewPharmacists(int Id, String fname, String lname, String email, String pharmacy, String contact) {
       this.id=Id;
       this.fname=fname;
       this.lname=lname;
       this.email=email;
       this.pharmacy=pharmacy;
       this.contact=contact;
       
    }
    
}
