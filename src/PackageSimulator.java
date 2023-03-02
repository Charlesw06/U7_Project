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
        resetSimulation();
        for (int i = 0; i < packageNum; i++) {
            Address origin = generateAddress();
            Address destination = generateAddress();

            double weight = generateWeight();
            double length = generateDimension(weight);
            double height = generateDimension(weight);
            double width = generateDimension(weight);

            packages.add(new Package(origin, destination, weight, length, height, width));
        }
        return packages;
    }

    public double generateTotalCost() {
        double totalCost = 0;
        for (Package newPackage : packages) {
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
        return popCities.get(index) + "," + popStates.get(index);
    }

    private double generateWeight() {
       int a = (int) (Math.random() * 7);
       if (a == 0 || a == 1) {
           return (Math.random() * 5)+1;
       }
       else if (a == 2 || a == 3 || a == 4) {
           return (Math.random() * 10) + 5;
       }
       else if (a == 5 || a == 6){
           return (Math.random() * 15) + 15;
       }
       else {
           return (Math.random() * 30) + 30;
       }
    }

    private double generateDimension(double weight) {
        if (weight < 5) {
            return (Math.random() * 5) + 5;
        }
        else if (weight >= 5 && weight < 15) {
            return (Math.random() * 10) + 7;
        }
        else if (weight >= 15 && weight < 30) {
            return (Math.random() * 10) + 10;
        }
        else {
            return (Math.random() * 10) + 15;
        }
    }

    private Address generateAddress() {
        String zipCode = generateZipCode();
        String cityAndState = generateCityAndState();
        String city = cityAndState.substring(0, cityAndState.indexOf(","));
        String state = cityAndState.substring(cityAndState.indexOf(",")+1);
        String streetNum = Integer.toString((int) (Math.random() * 900) + 100);
        String streetName = ((int) (Math.random() * 80) + 1) + "th Street";
        String[] apartmentLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        String apartmentNum = "Apt " + ((int) (Math.random() * 9)+1) + apartmentLetters[(int) (Math.random() * apartmentLetters.length)];
        return new Address(streetNum, streetName, city, state, zipCode, apartmentNum);
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
