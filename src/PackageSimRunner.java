import java.util.Scanner;
import java.util.ArrayList;

public class PackageSimRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Package Simulator!\n------------------------------------------\nWhat would you like to do?");
        String input = "";

        while (!input.equals("4")) {
            System.out.println("1. Calculate cost of one package\n2. Simulate packages\n3. How package costs are calculated\n4. Exit");
            PackageSimulator p = new PackageSimulator();

            Scanner s = new Scanner(System.in);
            System.out.print("Input: ");
            input = s.nextLine();
            System.out.println("------------------------------------------");

            if (Integer.parseInt(input) == 1) {
                System.out.print("Enter the zip code of the package origin: ");
                String origin = s.nextLine();
                System.out.print("Enter the zip code of the package destination: ");
                String destination = s.nextLine();
                System.out.print("Enter the weight of the package: ");
                double weight = Double.parseDouble(s.nextLine());
                System.out.print("Enter the height of the package: ");
                double height = Double.parseDouble(s.nextLine());
                System.out.print("Enter the length of the package: ");
                double length = Double.parseDouble(s.nextLine());
                System.out.print("Enter the width of the package: ");
                double width = Double.parseDouble(s.nextLine());

                double cost = PostageCalculator.calculatePostage(origin, destination, weight, length, width, height);
                System.out.println("Cost: " + cost);
            }
            else if (Integer.parseInt(input) == 2) {
                System.out.print("How many packages would you like to simulate? ");
                String numPackages = s.nextLine();
                System.out.println("Randomly generated packages info: ");

                ArrayList<Package> packages = p.generatePackages(Integer.parseInt(numPackages));
                for (int i = 0; i < packages.size(); i++) {
                    System.out.println("Package " + (i+1) + ": ________________________________");
                    System.out.println("Origin address: " + packages.get(i).getOrigin().toString());
                    System.out.println("Destination address: " + packages.get(i).getDestination().toString());
                    System.out.println("Weight: " + packages.get(i).getWeight());
                    System.out.println("Height: " + packages.get(i).getHeight());
                    System.out.println("Length: " + packages.get(i).getLength());
                    System.out.println("Width: " + packages.get(i).getWidth());
                    System.out.println("Cost: " + PostageCalculator.calculatePostage(packages.get(i)));
                }
                System.out.println("________________________________");
                System.out.println("Total cost of all packages: " + p.generateTotalCost(packages));
            }
            else if (Integer.parseInt(input) == 3) {
                System.out.println("General Formula:\n   - Base cost of $3.75\n   - For each tenth of a pound, $0.05 is added\n   - Difference in county codes divided by 100 is added");
                System.out.println("\nRules for Oversize Packages:\n   - If package is over 36 combined inches, $0.10 added for each inch over 36\n   - If package weighs over 40 pounds, $0.10 added for each pound over 40");
            }

            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                System.out.print("\nPress enter to return to menu: ");
                s.nextLine();
                System.out.println("------------------------------------------\nWhat would you like to do?");
            }
        }
    }
}
