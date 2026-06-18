import java.io.FileNotFoundException;
public class EspressoMachineDataBase extends CoffeeKitDataBase  {
public EspressoMachineDataBase() throws FileNotFoundException{
    super.loadData("EspressoMachines.txt","Espresso machine");
}
}
