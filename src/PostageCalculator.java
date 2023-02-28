public class PostageCalculator {
    public static double calculatePostage(String originZip, String destinationZip, double weight, double length, double width, double height) {
        double cost = 3.75;
        cost += 0.05 * (weight / 0.1);
        cost += (double) (Math.abs(Integer.parseInt(originZip.substring(0,3)) - Integer.parseInt(destinationZip.substring(0,3)))) / 100;
        if (weight > 40) {
            cost += 0.1 * ((40 - weight) / 0.1);
        }
        if (height + length + width > 36) {
            cost += 0.1 * (length + width + height - 36);
        }
        return cost;
    }

    public static double calculatePostage(Address origin, Address destination, double weight, double length, double width, double height) {
        return calculatePostage(origin.getZipCode(), destination.getZipCode(), weight, length, width, height);
    }

    public static double calculatePostage(Package p) {
        return calculatePostage(p.getOrigin().getZipCode(), p.getDestination().getZipCode(), p.getWeight(), p.getLength(), p.getWidth(), p.getHeight());
    }
}
