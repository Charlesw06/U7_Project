import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PackageSimulator {
    private ArrayList<Package> packages;
    private ArrayList<String> zipCodes;
    private ArrayList<String> popCities;
    private ArrayList<String> popStates;

    public PackageSimulator() {
        packages = new ArrayList<Package>();
        zipCodes = fileToList("src/ZipCodes");
        popCities = fileToList("src/PopularCities");
        popStates = fileToList("src/StatesOfPopularCities");
    }

    public ArrayList<Package> generatePackages(int packageNum) {
        ArrayList<Package> newPackages = new ArrayList<Package>();
        for (int i = 0; i < packageNum; i++) {
            String zipCode = generateZipCode();
            String cityAndState = generateCityAndState();
            String city = cityAndState.substring(0, cityAndState.indexOf(" "));
            String state = cityAndState.substring(cityAndState.indexOf(" ")+1);
            double weight = generateWeight();



            /* Research links
            https://www.statista.com/statistics/974065/cross-border-delivery-package-weight-worldwide/


             */
        }
        return newPackages;
    }

    public double generateTotalCost (ArrayList<Package> newPackages) {
        double totalCost = 0;
        for (Package newPackage : newPackages) {
            totalCost += PostageCalculator.calculatePostage(newPackage);
        }
        return totalCost;
    }
    public void resetSimulation() {
        packages = new ArrayList<Package>();
    }

    private String generateZipCode() {
        int index = (int) (Math.random() * zipCodes.size());
        return zipCodes.get(index);
    }

    private String generateCityAndState() {
        int index = (int) (Math.random() * popCities.size());
        return popCities.get(index) + " " + popStates.get(index);
    }

    private double generateWeight() {
       int a = (int) (Math.random() * 7);
       if (a == 0 || a == 1) {
           return Math.random() * 5;
       }
       else if (a == 2 || a == 3 || a == 4) {
           return (Math.random() * 10) + 5;
       }
       else if (a == 5 || a == 6){
           return (Math.random() * 15) + 15;
       }
       else {
           return (Math.random() * 20) + 30;
       }
    }

    private static ArrayList<String> fileToList(String fileName) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                list.add(line);
            }
        }
        catch (FileNotFoundException noFile) {
            return null;
        }
        return list;
    }
}
