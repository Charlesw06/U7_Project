public class PackageSimRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Package Simulator!\n----------------------------\n What wouldyou like to do?");
        System.out.println("1. Calculate cost of one package\n2. Simulate packages\n3. How package costs are calculated\n4. Exit");
        PackageSimulator p = new PackageSimulator();
        for (int i = 0; i < 10000; i++) {
            p.generatePackages(1);
        }
    }
}
