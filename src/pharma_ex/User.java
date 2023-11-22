/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma_ex;

import java.io.Serializable;
import static javassist.CtMethod.ConstParameter.string;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

/**
 *
 * @author CHAMOD
 */

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    
    @Column(name = "Firstname")
    private String firstname;
    
    @Column(name = "Lastname")
    private String lastname;
   
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Address")
    private String address;
    
    @Column(name = "District")
    private String district;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    
    

    public User() {
    }
    
    

    public User(int id, String firstname, String lastname,String email,String address,String district) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address=address;
        this.district=district;
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    

    
    
    

}
    //sandika
/*
@Entity
@Table(name="User")
@SecondaryTables({
@SecondaryTable(name="login", pkJoinColumns=@PrimaryKeyJoinColumn(name="login_id"))})
public class User implements Serializable{

    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "email", table="User")
    private String email;
     
    @Column(name = "Firstname", table="User")
    private String firstname;
    
    @Column(name = "Lastname", table="User")
    private String lastname;
    
     @Column(name = "usertype", table="login")
     private String usertype;
    
    @Column(name = "Username", table="login")
     private String username;
    
   @Column(name = "Password", table="login")
    private String password;
    
    
    
    
    @Column(name = "Address", table="User")
     private String address;
    
   
    @Column(name = "District", table="User")
    private String district;
    
    public User(){
        
    }
    

   public User(int id, String firstname, String lastname, String username, String password, String email,String address,String district, String usertype) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address=address;
        this.district=district;
        this.usertype=usertype;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    
    public String getusertype() {
        return usertype;
    }

    

    public void setusertype(String usertype) {
        this.usertype=usertype; //To change body of generated methods, choose Tools | Templates.
    }

   
*/
    
    

