/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma_ex;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author CHAMOD
 * 
 */

@Entity
public class pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    
    @Column(name = "Phar_name")
    private String name;
    
    @Column(name = "District")
    private String district;
    
    @Column(name = "Contact")
    private String contact;
    
     @Column(name = "Address")
     private String address;

    public pharmacy() {
        
    }
    
    public pharmacy(int id, String name, String district, String contact, String address) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.contact = contact;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;//To change body of generated methods, choose Tools | Templates.
    }
    public String getContact() {
        return name;
    }
    void setContact(String contact) {
        this.contact = contact;//To change body of generated methods, choose Tools | Templates.
    }
    public String getAddress() {
        return name;
    }
    void setAddress(String address) {
         this.address = address; //To change body of generated methods, choose Tools | Templates.
    }
    public String getDistrict() {
        return name;
    }
    void setDistrict(String district) {
        this.district = district;//To change body of generated methods, choose Tools | Templates.
    }
    
}
