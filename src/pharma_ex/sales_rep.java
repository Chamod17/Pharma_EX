/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma_ex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author CHAMOD
 */
@Entity
public class sales_rep {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "Fname")
    private String fname;
    
    @Column(name = "Lname")
    private String lname;
    
    @Column(name = "email")
    private String email;
    
     @Column(name = "Company")
     private String company;

    public sales_rep() {
        
    }
    
    public sales_rep(int ID, String fname, String lname, String email, String company) {
        this.id = ID;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = id;
    }
    
    public String getFname() {
        return fname;
    }
    void setFname(String fname) {
        this.fname = fname;//To change body of generated methods, choose Tools | Templates.
    }
    
    public String getLname() {
        return lname;
    }
    void setLname(String lname) {
        this.lname = lname;//To change body of generated methods, choose Tools | Templates.
    }
    public String getEmail() {
        return email;
    }
    void setEmail(String email) {
        this.email = email;//To change body of generated methods, choose Tools | Templates.
    }
    public String getCompany() {
        return company;
    }
    void setCompany(String company) {
         this.company = company; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
