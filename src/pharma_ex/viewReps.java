
package pharma_ex;

public class viewReps {
    private int id;
    private String Fname;
    private String Lname;
    private String email;
    private String Company;

    viewReps(int ID, String Fname, String Lname, String email, String Company) {
       this.id = ID;
       this.Fname=Fname;
       this.Lname=Lname;
       this.email=email;
       this.Company=Company;
       
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return Fname;
    }
    public String getLname() {
        return Lname;
    }
    public String getEmail() {
        return email;
    }
    public String getCompany() {
        return Company;
    }
    
}
