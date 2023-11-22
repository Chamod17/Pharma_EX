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
class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private int id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "usertype")
    private String usertype;
    
    @Column(name = "email")
    private String email;
    
    

    public Login(int id,String username,String password,String usertype,String email) {
         this.id=id;
         this.username=username;
         this.password=password;
            this.usertype=usertype;
this.email=email;//To change body of generated methods, choose Tools | Templates.
    }

    Login() {
       
    }

   
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    void setUsername(String username) {
        this.username=username; //To change body of generated methods, choose Tools | Templates.
    }
    public String getPassword() {
        return password;
    }
    void setPassword(String password) {
       this.password=password;//To change body of generated methods, choose Tools | Templates.
    }
public String getusertype() {
        return usertype;
    }
    void setusertype(String usertype) {
        this.usertype=usertype; //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email=email; //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
