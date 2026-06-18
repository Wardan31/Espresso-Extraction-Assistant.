import java.io.FileNotFoundException;
public class GrinderDataBase extends CoffeeKitDataBase  {
    public GrinderDataBase() throws FileNotFoundException{
        super.loadData("grinders.txt","grinder");
    }
}
