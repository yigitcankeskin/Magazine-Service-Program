package javafxapplication4;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;


/**
 *
 * @author yc_ke
 */
public class FXMLDocumentController2 implements Initializable  {
    
      @FXML
       private String ScreenNow = "ViewScene";
      @FXML
       private Stage stage;
       @FXML
       private Scene scene;
       @FXML
       private Parent root;
       @FXML
       private TableView<Supplement> TableSupplements;
       @FXML
       private TableColumn<Supplement ,String> ColumnId;
       @FXML
       private TableColumn<Supplement ,String> ColumnName;
       @FXML
       private TableColumn<Supplement ,String> ColumnCost;
       @FXML
       private  ObservableList<Supplement> Supplements = FXCollections.observableArrayList();
       @FXML
       private TableView<Customer> TableCustomers;
       @FXML
       private TableColumn<Customer, String> ColumnCustomerID;
       @FXML
       private TableColumn<Customer, String> ColumnCustomerName;
       @FXML
       private TableColumn<Customer, String> ColumnCustomerEmail;
       @FXML
       private ObservableList<Customer> Customers = FXCollections.observableArrayList();
       @FXML
       private ObservableList<AssociateCustomer> AssociateCustomer = FXCollections.observableArrayList();
       @FXML
       private ObservableList<PayingCustomer> PayingCustomer = FXCollections.observableArrayList();
       @FXML
       private TableView<Magazine> TableMagazines;
       @FXML
       private TableColumn<Magazine, String> ColumnMagazineId;
       @FXML
        private TableColumn<Magazine, String> ColumnMagazineCost;
       @FXML
        private TableColumn<Magazine, String> ColumnMagazineSupplements;
       @FXML
        private ObservableList<Magazine> Magazine = FXCollections.observableArrayList();
       @FXML
       private TextField FieldID,FieldName,FieldDate,FieldCustomerIDs,FieldCost;
       @FXML
       private TextField FieldCustomerId,FieldCustomerName,FieldCustomerAdress,FieldCustomerPayment
               ,FieldCustomerEmail,FieldCustomerSupplementIds,FieldCustomerStatus,FieldCustomerAssociateCustomers,FieldCustomerPaying;
       @FXML
       private TextField FieldMagazineId,FieldMagazineCost,FieldMagazineSupply1,FieldMagazineSupply2,FieldMagazineSupply3,FieldMagazineSupply4;
        @FXML
       private TextField FieldCustomerAdressStreetName,FieldCustomerAdressStreetNo,FieldCustomerAdressPostCode,FieldCustomerAdressSuburb,
               FieldCustomerAssociateCustomer1,FieldCustomerAssociateCustomer2,FieldCustomerAssociateCustomer3,
               FieldCustomerSupplementId1,FieldCustomerSupplementId2,FieldCustomerSupplementId3;
      
       public static boolean isInteger(String s) {
    System.out.println(String.format("Parsing string value: \"%s\"", s));
    
    if(s == null || s.equals("")) {
      System.out.println("Cannot parse the string since it either null or empty");
      return false;
    }
    
    try {
      int iVal = Integer.parseInt(s);
      return true;
    }
    catch(NumberFormatException e) {
      System.out.println("Cannot parse the string to integer");
    }
    return false;
  }
       public void ButtonCreateMagazine(){
           Boolean Control=false;
           ObservableList<Supplement> Supplements1 = FXCollections.observableArrayList();
           Magazine m = new Magazine();
           if(FieldMagazineCost.getText().equals("")||FieldMagazineId.getText().equals("")){
               Control=true;
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There are Empty Field");
               Warning.setContentText("You have to Fill Fields for Create.");
               Warning.showAndWait(); 
           }
           else if(!isInteger(FieldMagazineCost.getText())||!isInteger(FieldMagazineId.getText())
                   ||(!FieldMagazineSupply1.getText().equals("")&&!isInteger(FieldMagazineSupply1.getText()))
                   ||(!FieldMagazineSupply2.getText().equals("")&&!isInteger(FieldMagazineSupply2.getText()))
                   ||(!FieldMagazineSupply3.getText().equals("")&&!isInteger(FieldMagazineSupply3.getText()))
                   ||(!FieldMagazineSupply4.getText().equals("")&&!isInteger(FieldMagazineSupply4.getText()))
                   ){
               Control=true;
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There are wrong variable entered");
               Warning.setContentText("You have to Fill Fields with Integer for Create.");
               Warning.showAndWait(); 
           }
           for(int j=0;j<Magazine.size();j++){
               if(Magazine.get(j).getId()==Integer.parseInt(FieldMagazineId.getText())){
                  Control=true;
                  Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There are same ID variable entered");
               Warning.setContentText("You have to Fill different Id with Integer for Create.");
               Warning.showAndWait(); 
               }
           }
           if(Control==false){
           
               
           m.setId(Integer.parseInt(FieldMagazineId.getText()));
           
           m.setCost(Integer.parseInt(FieldMagazineCost.getText()));
            
           if(FieldMagazineSupply1.getText().equals(""))
               FieldMagazineSupply1.setText("0");
           if(FieldMagazineSupply2.getText().equals(""))
               FieldMagazineSupply2.setText("0");
           if(FieldMagazineSupply3.getText().equals(""))
               FieldMagazineSupply3.setText("0"); 
           if(FieldMagazineSupply4.getText().equals(""))
               FieldMagazineSupply4.setText("0");
           
           for(int i = 0 ; i<Supplements.size();i++){
               
               if(Supplements.get(i).getId()==Integer.parseInt(FieldMagazineSupply1.getText())
                ||Supplements.get(i).getId()==Integer.parseInt(FieldMagazineSupply2.getText()) 
                ||Supplements.get(i).getId()==Integer.parseInt(FieldMagazineSupply3.getText())  
                ||Supplements.get(i).getId()==Integer.parseInt(FieldMagazineSupply4.getText()))
               {
                    
                Supplements1.add(Supplements.get(i));
                   
               }
           }
           m.setSupply(Supplements1);
           Magazine.add(m);
           FillTableMagazines();
           }
       }
       public void ButtonCreateSupplement(){
           boolean Control=false;
           if(FieldID.getText().equals("")||FieldCost.getText().equals("")||FieldDate.getText().equals("")||FieldName.getText().equals("")){
             Control=true;  
             Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There are Empty Field");
               Warning.setContentText("You have to Fill Fields for Create.");
               Warning.showAndWait(); 
           }
           else if(!isInteger(FieldID.getText())||!isInteger(FieldCost.getText())){
               Control=true;
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There are Wrong variable entered ");
               Warning.setContentText("You have to Fill Integer to ID and Cost for Create.");
               Warning.showAndWait(); 
           }
           for(int i =0 ; i<Supplements.size();i++){
               if(Supplements.get(i).getId()==Integer.parseInt(FieldID.getText())){
                  Control=true;
                   Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There is a user with same ID  ");
               Warning.setContentText("You have to change ID for Create.");
               Warning.showAndWait(); 
               }
                   
           }
            if (!Control==true){
            Supplement sc = new Supplement();
            sc.setId(Integer.parseInt(FieldID.getText()));
            sc.setCost(Integer.parseInt(FieldCost.getText()));
            sc.setDate(FieldDate.getText());
            sc.setName(FieldName.getText());
            Supplements.add(sc);
            FillTableSupplements();
           }
       }
       public void ButtonCreateCustomer(){
           boolean Control=false;
            
           try{
           if(FieldCustomerAdressPostCode.getText().equals("")||FieldCustomerAdressStreetName.getText().equals("")||FieldCustomerAdressStreetNo.getText().equals("")||FieldCustomerAdressSuburb.getText().equals("")||FieldCustomerEmail.getText().equals("")||FieldCustomerId.getText().equals("")||FieldCustomerName.getText().equals("")||FieldCustomerStatus.getText().equals("")){
              Control=true;
                                     
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There are Empty Field");
               Warning.setContentText("You have to Fill Fields for Create.");
               Warning.showAndWait(); 
           }
           else if(!isInteger(FieldCustomerAdressPostCode.getText())||!isInteger(FieldCustomerId.getText())||!isInteger(FieldCustomerAdressStreetNo.getText())
                   ||(!FieldCustomerAssociateCustomer1.getText().equals("")&&!isInteger(FieldCustomerAssociateCustomer1.getText()))
                   ||(!FieldCustomerAssociateCustomer2.getText().equals("")&&!isInteger(FieldCustomerAssociateCustomer3.getText()))
                   ||(!FieldCustomerAssociateCustomer2.getText().equals("")&&!isInteger(FieldCustomerAssociateCustomer3.getText()))
                   ||(!FieldCustomerSupplementId1.getText().equals("")&&!isInteger(FieldCustomerSupplementId1.getText()))
                   ||(!FieldCustomerSupplementId2.getText().equals("")&&!isInteger(FieldCustomerSupplementId2.getText()))
                   ||(!FieldCustomerSupplementId3.getText().equals("")&&!isInteger(FieldCustomerSupplementId3.getText()))
                   ||(!FieldCustomerPaying.getText().equals("")&&!isInteger(FieldCustomerPaying.getText()))
                   ){
               Control=true;
               
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There are wrong variable entered.");
               Warning.setContentText("You have to enter Integer variable to -Customer ID Fields-Adress PostCode - Adress Street No- Supplement ID - Associate Customer ID - Customer Paying for Create.");
               Warning.showAndWait(); 
           }
           }catch(Exception e){
               System.out.println(e);
           }
           ObservableList<Supplement> Supplements1 = FXCollections.observableArrayList();
           ObservableList<Customer> Customers1 = FXCollections.observableArrayList();
           
           Adress a = new Adress();
           
           a.setPostCode(Integer.parseInt(FieldCustomerAdressPostCode.getText()));
           a.setStreetNo(Integer.parseInt(FieldCustomerAdressStreetNo.getText()));
           a.setStreetName(FieldCustomerAdressStreetName.getText());
           a.setSuburb(FieldCustomerAdressSuburb.getText());
           
           //Customer ID Control
           for(int ij=0;ij<Customers.size();ij++){
               if(Integer.parseInt(FieldCustomerId.getText())==Customers.get(ij).getId()){
               Control=true;
                Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There is same Customer ID ");
               Warning.setContentText("You have to Change Customer ID for Create.");
               Warning.showAndWait();
               }
           }
           
           if(FieldCustomerStatus.getText().equals("Associate Customer")&&Control==false){
               
               
            AssociateCustomer c = new AssociateCustomer();
            boolean control=false,control2=false;
            for(int i=0;i<PayingCustomer.size();i++){
                //here
                if(PayingCustomer.get(i).getId()==Integer.parseInt(FieldCustomerPaying.getText())){
                  control=true;
                 
                 
                  c.setPc(PayingCustomer.get(i));
                  PayingCustomer.get(i).addAcust(c);
                  
                }
                 
            }
            
           if(FieldCustomerSupplementId1.getText().equals("")&&FieldCustomerSupplementId2.getText().equals("")&&FieldCustomerSupplementId3.getText().equals("")){
                   
               }
               else{
                   if(FieldCustomerSupplementId1.getText().equals(""))
                       FieldCustomerSupplementId1.setText("0");
                   if(FieldCustomerSupplementId2.getText().equals(""))
                       FieldCustomerSupplementId2.setText("0");
                   if(FieldCustomerSupplementId3.getText().equals(""))
                       FieldCustomerSupplementId3.setText("0");
               for(int j=0;j<Supplements.size();j++){
               if(Supplements.get(j).getId()==Integer.parseInt(FieldCustomerSupplementId1.getText())||Supplements.get(j).getId()==Integer.parseInt(FieldCustomerSupplementId2.getText())||Supplements.get(j).getId()==Integer.parseInt(FieldCustomerSupplementId3.getText())){
                   control2=true;
                   
                   try{
                       System.out.println("Calisti3--"+Supplements.get(j).getName());
                      Supplements1.add(Supplements.get(j)); 
                   }catch(Exception e){
                       System.out.println(e);
                   }
                   
                   
               }
           }    
                    }
           c.setSupply(Supplements1);
           
           c.setAdress(a);
           c.setEmail(FieldCustomerEmail.getText());
           c.setName(FieldCustomerName.getText());
           c.setId(Integer.parseInt(FieldCustomerId.getText()));
           
           if(control==false||control2==false){
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There is no paying customer with the ID you typed or Supplement ID you typed");
               Warning.setContentText("You have to write a true Paying Customer and a Supplement ID you typed ID for Create.");
               Warning.showAndWait();
               
            }
           else{
              AssociateCustomer.add(c);
              Customers.add(c);
              FillTableCustomers();
           }
           }
           else if(FieldCustomerStatus.getText().equals("Paying Customer")&&Control==false){
               boolean control=false,control2=false;
               
            PayingCustomer c = new PayingCustomer();
            System.out.println("Calisti1");
            for(int i=0;i<AssociateCustomer.size();i++){
                
                try{
              if(FieldCustomerAssociateCustomer1.getText().equals("")&&FieldCustomerAssociateCustomer1.getText().equals("")&&FieldCustomerAssociateCustomer1.getText().equals("")){
                  
              }
              else{
              if(AssociateCustomer.get(i).getId()==Integer.parseInt(FieldCustomerAssociateCustomer1.getText())||AssociateCustomer.get(i).getId()==Integer.parseInt(FieldCustomerAssociateCustomer2.getText())||AssociateCustomer.get(i).getId()==Integer.parseInt(FieldCustomerAssociateCustomer3.getText())){
                  control=true;
                  c.addAcust(AssociateCustomer.get(i));
                  System.out.println("Calisti2");
              }
              }  
              }catch(Exception e){
                    System.out.println(e);
                }
            }
               if(FieldCustomerSupplementId1.getText().equals("")&&FieldCustomerSupplementId2.getText().equals("")&&FieldCustomerSupplementId3.getText().equals("")){
                   
               }
               else{
                   if(FieldCustomerSupplementId1.getText().equals(""))
                       FieldCustomerSupplementId1.setText("0");
                   if(FieldCustomerSupplementId2.getText().equals(""))
                       FieldCustomerSupplementId2.setText("0");
                   if(FieldCustomerSupplementId3.getText().equals(""))
                       FieldCustomerSupplementId3.setText("0");
               for(int j=0;j<Supplements.size();j++){
               if(Supplements.get(j).getId()==Integer.parseInt(FieldCustomerSupplementId1.getText())||Supplements.get(j).getId()==Integer.parseInt(FieldCustomerSupplementId2.getText())||Supplements.get(j).getId()==Integer.parseInt(FieldCustomerSupplementId3.getText())){
                   control2=true;
                   
                   try{
                       System.out.println("Calisti3--"+Supplements.get(j).getName());
                      Supplements1.add(Supplements.get(j)); 
                   }catch(Exception e){
                       System.out.println(e);
                   }
                   
                   
               }
           }    
                    }
               System.out.println("Calisti4");
            c.setSupply(Supplements1);
            c.setPayment(FieldCustomerPayment.getText());
            c.setAdress(a);
            c.setEmail(FieldCustomerEmail.getText());
            c.setName(FieldCustomerName.getText());
            c.setId(Integer.parseInt(FieldCustomerId.getText()));
            if(control==false||control2==false){
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There is no Associate customer with the ID you typed or Supplement ID you typed");
               Warning.setContentText("You have to write a true Associate Customer and a Supplement ID you typed ID for Create.");
               Warning.showAndWait();
               
            }
           else{
              PayingCustomer.add(c);
              Customers.add(c);
              FillTableCustomers();
           }
           }
           else if(Control==true){
               
           }
           else{
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There is no true Customer Status");
               Warning.setContentText("You have to write 'Paying Customer' or 'Associate Customer' to status ");
               Warning.showAndWait(); 
           }
       }
       public void ButtonUpdateCustomer(){
           try{
            boolean flag = false;
            Customer cs1 = TableCustomers.getSelectionModel().getSelectedItem();
            System.out.println(cs1.getId());
            for(int i=0;i<PayingCustomer.size();i++){
                if(PayingCustomer.get(i).getId()==cs1.getId()){
                 flag=true;
                 PayingCustomer.get(i).setId(Integer.parseInt(FieldCustomerId.getText()));
                 PayingCustomer.get(i).setName(FieldCustomerName.getText());
                 PayingCustomer.get(i).setEmail(FieldCustomerEmail.getText());
                 PayingCustomer.get(i).setAdress(UpdatePayingCustomerAdress(PayingCustomer.get(i)));
                 //PayingCustomer.get(i).setAcust(AssociateCustomer);
                 //PayingCustomer.get(i).setSupply(Supplements);
                 FillTableCustomers();
                }
            }
            if(flag==false){
                for(int j=0;j<AssociateCustomer.size();j++){
                    if(AssociateCustomer.get(j).getId()==cs1.getId()){
                        flag=true;
                       
                 AssociateCustomer.get(j).setId(Integer.parseInt(FieldCustomerId.getText()));
                 AssociateCustomer.get(j).setName(FieldCustomerName.getText());
                 AssociateCustomer.get(j).setEmail(FieldCustomerEmail.getText());
                 AssociateCustomer.get(j).setAdress(UpdatePayingCustomerAdress(PayingCustomer.get(j)));
                 FillTableCustomers();
                    }
                }
            }
           
            if(flag==false){
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There is no choice");
               Warning.setContentText("You have to choose a supplement for Update.");
               Warning.showAndWait();
               
           }
       }catch(NullPointerException e){
             // Because of There is a empty error message.
         }
       }
       public void ButtonRemoveCustomer(){
           try{
            boolean flag = false;
            Customer cs1 = TableCustomers.getSelectionModel().getSelectedItem();
            System.out.println(cs1.getId());
            for(int i=0;i<PayingCustomer.size();i++){
                if(PayingCustomer.get(i).getId()==cs1.getId()){
                 flag=true;
                 PayingCustomer.remove(i);
                 
                }
            }
            for(int j=0;j<Customers.size();j++){
                    if(Customers.get(j).getId()==cs1.getId()){
                     Customers.remove(j);
                    }
                }
            if(flag==false){
                for(int j=0;j<AssociateCustomer.size();j++){
                    if(AssociateCustomer.get(j).getId()==cs1.getId()){
                        flag=true;
                     AssociateCustomer.remove(j);
                    }
                }
                 for(int j=0;j<Customers.size();j++){
                    if(Customers.get(j).getId()==cs1.getId()){
                        flag=true;
                     Customers.remove(j);
                    }
                }
            }
           
            if(flag==false){
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There is no choice");
               Warning.setContentText("You have to choose a Customer for Update.");
               Warning.showAndWait();
               
           }
            FillTableCustomers();
       }
           catch(Exception e){
               System.out.println(e);
             // Because of There is a empty error message.
         }
       }
       public Adress UpdatePayingCustomerAdress(PayingCustomer pc){
           
         Adress a = pc.getAdress();
         a.setStreetName(FieldCustomerAdress.getText().substring(FieldCustomerAdress.getText().indexOf("No : ")+5,FieldCustomerAdress.getText().indexOf("//")));
         a.setStreetNo(Integer.parseInt(FieldCustomerAdress.getText().substring(FieldCustomerAdress.getText().indexOf("//")+2,FieldCustomerAdress.getText().indexOf("Suburb"))));
         a.setSuburb(FieldCustomerAdress.getText().substring(FieldCustomerAdress.getText().indexOf("Suburb")+6,FieldCustomerAdress.getText().indexOf("PostCode")));
         a.setStreetNo(Integer.parseInt(FieldCustomerAdress.getText().substring(FieldCustomerAdress.getText().indexOf("PostCode")+8)));
         return a;
       }
        public Adress UpdateAssociateCustomerAdress(AssociateCustomer ac){
         Adress a = ac.getAdress();
         a.setStreetName(FieldCustomerAdress.getText().substring(FieldCustomerAdress.getText().indexOf("No : ")+5,FieldCustomerAdress.getText().indexOf("//")));
         a.setStreetNo(Integer.parseInt(FieldCustomerAdress.getText().substring(FieldCustomerAdress.getText().indexOf("//")+2,FieldCustomerAdress.getText().indexOf("Suburb"))));
         a.setSuburb(FieldCustomerAdress.getText().substring(FieldCustomerAdress.getText().indexOf("Suburb")+6,FieldCustomerAdress.getText().indexOf("PostCode")));
         a.setStreetNo(Integer.parseInt(FieldCustomerAdress.getText().substring(FieldCustomerAdress.getText().indexOf("PostCode")+8)));
         return a;
       }
       public void ButtonUpdateSupplement(){
           int selected = TableSupplements.getSelectionModel().getSelectedIndex();
           System.out.println("secilen indeks"+selected);
           if(selected != -1){
               Supplements.get(selected).setId(Integer.parseInt(FieldID.getText()));
               Supplements.get(selected).setCost(Integer.parseInt(FieldCost.getText()));
               Supplements.get(selected).setDate(FieldDate.getText());
               Supplements.get(selected).setDate(FieldCustomerIDs.getText());
               Supplements.get(selected).setName(FieldName.getText());
               FillTableSupplements();
           }
           else{
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There is no choice");
               Warning.setContentText("You have to choose a supplement for Update.");
               Warning.showAndWait();
               
           }
       }
        public void ButtonRemoveSupplement(){
           int selected = TableSupplements.getSelectionModel().getSelectedIndex();
           System.out.println("secilen indeks"+selected);
           if(selected != -1){
               Supplements.remove(selected);
               FillTableSupplements();
           }
           else{
               Alert Warning = new Alert(AlertType.ERROR);
               Warning.setTitle("Mistake");
               Warning.setHeaderText("There is no choice");
               Warning.setContentText("You have to choose a supplement for Remove.");
               Warning.showAndWait();
               
           }
       }
        public void FillTableMagazines(){
            ColumnMagazineId.setCellValueFactory(new PropertyValueFactory<Magazine, String>("id"));
            ColumnMagazineCost.setCellValueFactory(new PropertyValueFactory<Magazine, String>("cost"));
            TableMagazines.setItems(Magazine);
            TableMagazines.refresh();
        }
       public void FillTableSupplements(){
        ColumnId.setCellValueFactory(new PropertyValueFactory<Supplement, String>("id"));
        ColumnName.setCellValueFactory(new PropertyValueFactory<Supplement, String>("name"));
        ColumnCost.setCellValueFactory(new PropertyValueFactory<Supplement, String>("cost"));
        TableSupplements.setItems(Supplements);
        TableSupplements.refresh();
        
}
       public void FillTableCustomers(){
        ColumnCustomerID.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
        ColumnCustomerName.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        ColumnCustomerEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
        TableCustomers.setItems(Customers);
        TableCustomers.refresh();
                  
}
        public void ShowSupplement(Supplement Supplement){
             FieldCost.setText("");
             FieldCustomerIDs.setText("");
             FieldDate.setText("");
             FieldName.setText("");
             FieldID.setText("");
         if(Supplement != null){
             FieldID.setText(String.valueOf(Supplement.getId()));
             FieldName.setText(Supplement.getName());
             FieldDate.setText(Supplement.getDate());
             FieldCost.setText(String.valueOf(Supplement.getCost()));
             FieldCustomerIDs.setText(DetectCustomerSupplements(Supplement.getId()));
         }
         else{
             FieldCost.setText("");
             FieldCustomerIDs.setText("");
             FieldDate.setText("");
             FieldName.setText("");
             FieldID.setText("");
             
         }
           
         
       }
       public void ShowPayingCustomer(PayingCustomer Customer){
           //System.out.println("  asd"+Customer.getName());
           FieldCustomerId.setText("");
             FieldCustomerName.setText("");
             FieldCustomerPayment.setText("");
             FieldCustomerAdress.setText("");
             FieldCustomerEmail.setText("");
             FieldCustomerSupplementIds.setText("");
             FieldCustomerStatus.setText("");
             FieldCustomerAssociateCustomers.setText("");
           if(Customer != null){
             FieldCustomerId.setText(""+Customer.getId());
             FieldCustomerName.setText(Customer.getName());
             FieldCustomerPayment.setText(Customer.getPayment());
             FieldCustomerAdress.setText(DetectPayingCustomerAdress(Customer.getId()));
             FieldCustomerEmail.setText(Customer.getEmail());
             FieldCustomerSupplementIds.setText(DetectCustomerOnSupplements(Customer.getId()));
             FieldCustomerStatus.setText("Paying Customer");
             FieldCustomerAssociateCustomers.setText(DetectCustomerOnAssociateCustomers(Customer.getId()));
           }
       }
       public void ShowAssociateCustomer(AssociateCustomer Customer){
           FieldCustomerId.setText("");
             FieldCustomerName.setText("");
             FieldCustomerAdress.setText("");
             FieldCustomerEmail.setText("");
             FieldCustomerSupplementIds.setText("");
             FieldCustomerStatus.setText("");
             FieldCustomerAssociateCustomers.setText("");
             FieldCustomerPayment.setText("");
           if(Customer != null){
             FieldCustomerId.setText(""+Customer.getId());
             FieldCustomerName.setText(Customer.getName());
             FieldCustomerAdress.setText(DetectAssociateCustomerAdress(Customer.getId()));
             FieldCustomerEmail.setText(Customer.getEmail());
             FieldCustomerSupplementIds.setText(DetectAssociateCustomerOnSupplements(Customer.getId()));
             FieldCustomerStatus.setText("Associate Customer");
             FieldCustomerAssociateCustomers.setText("THERE İS NO");
             FieldCustomerPayment.setText("partner of "+Customer.getPc().getName());
           }
       }
       public String DetectCustomerOnAssociateCustomers(int CustomerId){
           String Result ="";
       for(int i=0;i<PayingCustomer.size();i++){
          PayingCustomer c = PayingCustomer.get(i);
          if(c.getId()==CustomerId){
            ObservableList<AssociateCustomer> ac = c.getAcust();
            for(int j=0;j<ac.size();j++){
                Result = Result + ac.get(j).getId()+", ";
            }
       }
       }
           return Result;
       }
       public String DetectCustomerOnSupplements(int CustomerId){
           String Result ="";
       for(int i=0;i<PayingCustomer.size();i++){
          PayingCustomer c = PayingCustomer.get(i);
           if(c.getId()==CustomerId){
          ObservableList<Supplement> sp = c.getSupply();
           for(int j=0;j<sp.size();j++){
               Result = Result + sp.get(j).getId()+", ";
           }
       }
       }
         return Result;
       }
        public String DetectAssociateCustomerOnSupplements(int CustomerId){
           String Result ="";
       for(int i=0;i<AssociateCustomer.size();i++){
          AssociateCustomer c = AssociateCustomer.get(i);
           if(c.getId()==CustomerId){
          ObservableList<Supplement> sp = c.getSupply();
           for(int j=0;j<sp.size();j++){
               Result = Result + sp.get(j).getId()+", ";
           }
       }
       }
         return Result;
       }
       public String DetectPayingCustomerAdress(int id){
           String Result="";
           for(int i=0;i<PayingCustomer.size();i++){
               PayingCustomer p =PayingCustomer.get(i);
               if(p.getId()==id){
                   Adress a = p.getAdress();
                   Result = "Street Name/No : "+a.getStreetName()+"//"+a.getStreetNo()+"Suburb"+a.getSuburb()+"PostCode"+a.getPostCode();
               }
           }
           return Result;
       }
       public String DetectAssociateCustomerAdress(int id){
           String Result="";
           for(int i=0;i<AssociateCustomer.size();i++){
               AssociateCustomer p =AssociateCustomer.get(i);
               if(p.getId()==id){
                   Adress a = p.getAdress();
                   Result = "Street Name/No : "+a.getStreetName()+"//"+a.getStreetNo()+"Suburb"+a.getSuburb()+"PostCode"+a.getPostCode();
               }
           }
           return Result;
       }
       public String DetectCustomerSupplements(int SupplementId){
           String Result ="";
       for(int i=0;i<Customers.size();i++){
          Customer c = Customers.get(i);
           
          ObservableList<Supplement> sp = c.getSupply();
           for(int j=0;j<sp.size();j++){
               if(SupplementId==sp.get(j).getId()){
                   Result = Result+c.getId()+", ";
               }
               
           }
       }
           
         return Result;
       }
       public void TransferVariable(ObservableList<Magazine> Magazines,ObservableList<Supplement> Supplements, ObservableList<Customer> Customers, ObservableList<AssociateCustomer> AssociateCustomers,  ObservableList<PayingCustomer> PayingCustomers){
           
          this.Magazine.setAll(Magazines);
          this.Supplements=Supplements;
          this.Customers=Customers;
          this.AssociateCustomer=AssociateCustomers;
          this.PayingCustomer=PayingCustomers;
          FillTableCustomers();
          FillTableSupplements();
       }
       
       public void switchToViewScene(ActionEvent event) throws IOException{
           ScreenNow = "ViewScene";
           FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewScene.fxml"));	
		root = loader.load();
           FXMLDocumentController fd =loader.getController();
           fd.TransferVariable(Magazine, Supplements, Customers, AssociateCustomer, PayingCustomer);
           stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
          
           
           /* ScreenNow = "ViewScene";
           Parent root = FXMLLoader.load(getClass().getResource("ViewScene.fxml"));
           stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
           */ 
           
           
       }
       
       public void switchToEditScene(ActionEvent event) throws IOException{
            ScreenNow = "EditScene";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EditScene.fxml"));	
		root = loader.load();
           FXMLDocumentController2 fd =loader.getController();
           fd.TransferVariable(Magazine, Supplements, Customers, AssociateCustomer, PayingCustomer);
           stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
          
       }
       public void switchToCreateScene(ActionEvent event) throws IOException{
           ScreenNow = "CreateScene";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateScene.fxml"));	
		root = loader.load();
           FXMLDocumentController3 fd =loader.getController();
           fd.TransferVariable(Magazine, Supplements, Customers, AssociateCustomer, PayingCustomer);
           stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
           
       }
       public ArrayList<String> ReturnPayingCustomerId(){
           ArrayList<String> a=new ArrayList<String>();
           for(int i = 0 ; i<PayingCustomer.size();i++){
               a.add(String.valueOf(PayingCustomer.get(i).getId()));
           }
           return a;
                }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println(Magazine.get(0).getId());
        try{
         if(ScreenNow.equals("ViewScene")){
          FillTableSupplements();
          FillTableCustomers();
          
          
          TableSupplements.getSelectionModel().selectedItemProperty().addListener(
        (observable,oldValue , newValue) -> ShowSupplement(newValue)
       );
        TableCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    
        public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label

        if(TableCustomers.getSelectionModel().getSelectedItem() != null) 
        {    
           TableViewSelectionModel selectionModel = TableCustomers.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
           for(int i=0;i<PayingCustomer.size();i++){
              PayingCustomer py = PayingCustomer.get(i);
              if((int)val==py.getId()){
                  System.out.println(" --\n--\n "+py.getName()); 
                  ShowPayingCustomer(py);
              }
              
           }
           for(int j=0;j<AssociateCustomer.size();j++){
              AssociateCustomer ppy = AssociateCustomer.get(j);
              if((int)val==ppy.getId()){
                   System.out.println("--\n--\n"+ppy.getName());
                  ShowAssociateCustomer(ppy);
              }  
           }
         }
         }
     });    
        
       }
       FillTableMagazines();
       }
         catch(NullPointerException e){
             // Because of There is a empty error message.
         }
          
           
      
      
       }
    
}

