public class CoffeeKit {
    private String brandName;
    private String model;
    private int id;
    public CoffeeKit(){
        this.id= 0;
        this.brandName="Unknown Brand";
        this.model ="Unknown Model";
    }
    public CoffeeKit(int id , String brandName , String model){
        this.id=id;
        this.brandName=brandName;
        this.model=model;
    }
public int getId(){
    return id;
}
public String getBrandName(){
    return brandName;
}
public String getModel(){
    return model;
}
@Override
public String toString(){
    return "[" + id + "] " + brandName + " - " + model;
}
}
