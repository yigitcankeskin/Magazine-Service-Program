package javafxapplication4;


public class Supplement {
    private String name;
    private String date;
    private int id;
    int cost;

    public Supplement(int id,String name,String date, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.date = date;
    }
    public Supplement(){
        
    }

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
}
