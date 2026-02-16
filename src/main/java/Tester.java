package FuelStationSimulation;

public class Tester {
    public static void main(String[] args) {
        FuelStation fStation = new FuelStation("Regular", 10010, 1.53);
        System.out.println(fStation.toString());

        Vehicle v1 = new Vehicle(120, "Regular", "Toyota", "Corolla", 2018, 0);
        System.out.println(v1.toString());

        double dispensed = fStation.dispense(v1);
        System.out.println("Dispensed: " + dispensed);
        System.out.println(fStation);

    }

}
