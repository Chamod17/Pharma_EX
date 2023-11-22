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



public class Admin_pharmacist_View {
    private int id;
    private String f_name;
    private String l_name;
    private String email;
    private String contact;
    private String phar_name;
    String district;

    Admin_pharmacist_View(int id, String f_name, String l_name, String email, String contact, String phar_name, String district) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.contact = contact;
        this.phar_name = phar_name;
        this.district = district;
    }
    
    public int getId() {
        return id;
    }
    public String getF_name() {
        return f_name;
    }
    public String getL_name() {
        return l_name;
    }
    public String getEmail() {
        return email;
    }
    public String getContact() {
        return contact;
    }
    public String getPhar_name() {
        return phar_name;
    }
    public String getDistrict() {
        return district;
    }
    
}
