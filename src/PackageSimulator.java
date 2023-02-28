import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PackageSimulator {
    private ArrayList<Package> packages;
    private ArrayList<String> zipCodes;

    public PackageSimulator() {
        packages = new ArrayList<Package>();
        zipCodes = zipCodes("src/ZipCodes");
    }

    public ArrayList<Package> generatePackages(int packageNum) {
        ArrayList<Package> newPackages = new ArrayList<Package>();
        for (int i = 0; i < packageNum; i++) {
            String zipCode = generateZipCode();


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

    private double generateWeight() {
        return 0.0;
    }

    private static ArrayList<String> zipCodes(String fileName) {
        ArrayList<String> zipCodeList = new ArrayList<String>();
        try {
            File zipCodes = new File(fileName);
            Scanner reader = new Scanner(zipCodes);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                zipCodeList.add(line);
            }
        }
        catch (FileNotFoundException noFile) {
            return null;
        }
        return zipCodeList;
    }
}
