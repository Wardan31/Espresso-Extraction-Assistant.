import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class CoffeeKitDataBase {
    private ArrayList<CoffeeKit> CoffeeKitList = new ArrayList<>();

    public void loadData(String fileName , String type) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(fileName));
        while(sc.hasNext()){
            int id = sc.nextInt();
            String brandName = sc.next();
            String model = sc.next();
            if (type.equalsIgnoreCase("grinder")) {
                CoffeeKitList.add(new Grinder(id, brandName, model));
            } else if (type.equalsIgnoreCase("Espresso machine")) {
                CoffeeKitList.add(new EspressoMachine(id, brandName, model));
            }
        }
        sc.close();
    }

    public ArrayList<CoffeeKit> brandSearch(String brandName) {
        ArrayList<CoffeeKit> searchResult = new ArrayList<>();
        for(CoffeeKit item : CoffeeKitList) {
            if(item.getBrandName().toLowerCase().contains(brandName.toLowerCase())) {
                searchResult.add(item);
            }
        }
        return searchResult;
    }

    public CoffeeKit idSearch(int id) {
        for (CoffeeKit item : CoffeeKitList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}