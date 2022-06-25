package javafxapplication4;


import java.util.ArrayList;
import javafx.collections.ObservableList;


public class Magazine {
 
       private int id;
       int cost;
       ObservableList<Supplement> supply;

    public Magazine(int id,int cost, ObservableList<Supplement> supply) {
        this.id = id;
        this.cost = cost;
        this.supply = supply;
    }

   public Magazine(){
       
   }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ObservableList<Supplement> getSupply() {
        return supply;
    }

    public void setSupply(ObservableList<Supplement> supply) {
        this.supply = supply;
    }   
    public void addSupply(Supplement sp){
        supply.add(sp);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
