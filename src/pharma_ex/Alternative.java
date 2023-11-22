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
public class Alternative {

    private String alt_name;
    private String description;
    String drug;

    
    public Alternative(String Alt_name,String Alt_description) {
        this.alt_name = Alt_name;
        this.description = Alt_description;
        
    }

  

    public String getAlt_name() {
        return alt_name;
    }

    public String getDes() {
        return description;
    }
    
   

   
   
    
    
}
