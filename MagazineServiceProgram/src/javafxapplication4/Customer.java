package javafxapplication4;


import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;


public class Customer {
   private int id;
   private String name,email;
   private ObservableList<Supplement> supply;
   private  Adress adress;

    public Customer(int id,String name,Adress adress, String email, ObservableList<Supplement> supply) {
        this.id =id;
        this.name = name;
        this.email = email;
        this.supply = supply;
        this.adress = adress;
    }
    public Customer(){
        
    }
    public void addSupplement(Supplement supp)
    {
        supply.add(supp);
    }
    public void removeSupplement(Supplement supp)
    {
        supply.remove(supp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ObservableList<Supplement> getSupply() {
        return supply;
    }

    public void setSupply(ObservableList<Supplement> supply) {
        this.supply = supply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the adress
     */
    public Adress getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(Adress adress) {
        this.adress = adress;
    }
   
}
class Adress  {
    
    private int StreetNo,PostCode;
    private String StreetName,Suburb; 
    
    public Adress(int StreetNo,int PostCode,String StreetName,String Suburb){
        this.PostCode= PostCode;
        this.StreetName = StreetName;
        this.StreetNo = StreetNo;
        this.Suburb = Suburb;
        
    }
    public Adress(){
        
    }
    
    public int getStreetNo() {
        return StreetNo;
    }

   
    public void setStreetNo(int StreetNo) {
        this.StreetNo = StreetNo;
    }

    
    public int getPostCode() {
        return PostCode;
    }

    
    public void setPostCode(int PostCode) {
        this.PostCode = PostCode;
    }

    
    public String getStreetName() {
        return StreetName;
    }

   
    public void setStreetName(String StreetName) {
        this.StreetName = StreetName;
    }

   
    public String getSuburb() {
        return Suburb;
    }

 
    public void setSuburb(String Suburb) {
        this.Suburb = Suburb;
    }
    
}
class AssociateCustomer extends Customer
{
PayingCustomer pc;

    public AssociateCustomer(PayingCustomer pc,int id, String name,Adress adress, String email, ObservableList<Supplement> supply) {
        super(id,name,adress, email, supply);
        
        this.pc = pc;
    }

    public AssociateCustomer(){
        
    }   
    
    public PayingCustomer getPc() {
        return pc;
    }

    public void setPc(PayingCustomer pc) {
        this.pc = pc;
    }


}
class PayingCustomer extends Customer 
{
    ObservableList<AssociateCustomer> acust;
    String payment;

    public PayingCustomer(ObservableList<AssociateCustomer> acust,int id, String payment, String name,Adress adress, String email, ObservableList<Supplement> supply) {
        super(id, name,adress, email, supply);
        this.acust = acust;
        this.payment = payment;
    }
    public PayingCustomer(){
        
    }
    

    public ObservableList<AssociateCustomer> getAcust() {
        return acust;
    }
    public void setAcust(ObservableList<AssociateCustomer> acust) {
        this.acust = acust;
    }
    public void addAcust(AssociateCustomer ac){
        acust.add(ac);
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    public void list()
    {
System.out.print(getId());
System.out.print(getName());
System.out.print(getEmail());
System.out.print(getSupply());

    }
}


