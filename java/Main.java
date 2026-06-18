import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        EspressoMachineDataBase machineDB = new EspressoMachineDataBase();
        GrinderDataBase grinderDB = new GrinderDataBase();

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Coffee equipment hub");
        System.out.println("-------------------------------");

        System.out.println("Please Enter your espresso machine brand name");
        String brandName = input.next();
        ArrayList<CoffeeKit> machineResults = machineDB.brandSearch(brandName);
        for(CoffeeKit m : machineResults) {
            System.out.println(m);
        }
        System.out.println("Enter the ID of your specific machine from the list above:");
        int machineId = input.nextInt();

        System.out.println("Please Enter your beans grinder brand name");
        String grinder = input.next();
        ArrayList<CoffeeKit> grinderResults = grinderDB.brandSearch(grinder);
        for(CoffeeKit g : grinderResults) {
            System.out.println(g);
        }
        System.out.println("Enter the ID of your specific grinder from the list above:");
        int grinderId = input.nextInt();
        System.out.println("-------------------------------");

        CoffeeKit selectedMachine = machineDB.idSearch(machineId);
        CoffeeKit selectedGrinder = grinderDB.idSearch(grinderId);

        if (selectedMachine == null) {
            System.out.println("Machine not found!");
            return;
        }

        System.out.println("Your setup:");
        System.out.println("Machine: " + selectedMachine);
        System.out.println("Grinder: " + selectedGrinder);
        System.out.println("-------------------------------");

        System.out.println("How many grams of coffee did you put in the basket?");
        double doseGrams = input.nextDouble();

        System.out.println("How many ml of espresso came out?");
        double yieldMl = input.nextDouble();

        System.out.println("How many seconds did the extraction take?");
        double timeSeconds = input.nextDouble();

        double ratio = yieldMl / doseGrams;

        System.out.println("Shot ratio (1 : " + ratio + ")");

        String diagnosis;
        String tips;

        if (timeSeconds < 20) {
            diagnosis = "Fast extraction (under-extracted) - the shot will likely taste sour and weak.";
            tips = "Try grinding finer, tamp a bit firmer, and make sure the grounds are spread evenly in the basket.";
        } else if (timeSeconds <= 35) {
            diagnosis = "Good extraction time.";
            tips = "Your time is in a healthy range. Taste the shot and adjust the grind only slightly if needed.";
        } else {
            diagnosis = "Slow extraction (over-extracted) - the shot will likely taste bitter and harsh.";
            tips = "Try grinding coarser, reduce your dose a little, and check the basket for clumps or uneven distribution.";
        }

        if (ratio < 1.5) {
            tips = tips + " Also, your ratio is quite concentrated (ristretto-like) - consider letting more water through next time.";
        } else if (ratio > 2.5) {
            tips = tips + " Also, your ratio is on the diluted side (lungo-like) - consider stopping the shot earlier.";
        }

        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Tips: " + tips);

        input.close();
    }
}