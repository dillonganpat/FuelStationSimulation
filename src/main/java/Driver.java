package FuelStationSimulation;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.InputStream;

public class Driver {
    private String name;
    private Vehicle vehicle1;
    private Vehicle vehicle2;

    public Driver(String name) {
        this.name = name;
        this.vehicle1 = null;
        this.vehicle2 = null;
    }

    public boolean addVehicle(Vehicle v) {
        if (vehicle1 == null) {
            vehicle1 = v;
            return true;
        } else if (vehicle2 == null) {
            vehicle2 = v;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "Driver: " + name;
        if (vehicle1 != null) result += "\n Vehicle 1: " + vehicle1.toString();
        if (vehicle2 != null) result += "\n Vehicle 2: " + vehicle2.toString();
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Driver> drivers = new ArrayList<>();

        // Read vehicles from Vehicles.txt
        try {
            InputStream stream = Driver.class.getResourceAsStream("/Vehicles.txt");
            if (stream == null) {
                System.out.println("Vehicles.txt not found! Make sure it is in src/resources/");
                return;
            }

            try (Scanner sc = new Scanner(stream)) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.trim().isEmpty()) continue;

                    String[] parts = line.split(",");
                    double tankCapacity = Double.parseDouble(parts[0].trim());
                    String fuelType = parts[1].trim();
                    String make = parts[2].trim();
                    String model = parts[3].trim();
                    int year = Integer.parseInt(parts[4].trim());
                    int classification = Integer.parseInt(parts[5].trim());

                    Vehicle v = new Vehicle(tankCapacity, fuelType, make, model, year, classification);
                    vehicles.add(v);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading Vehicles.txt: " + e.getMessage());
            return;
        }

        // Create drivers
        String[] driverNames = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        for (String name : driverNames) {
            drivers.add(new Driver(name));
        }

        // Check total capacity to avoid infinite loop
        int totalCapacity = drivers.size() * 2;
        if (vehicles.size() > totalCapacity) {
            System.out.println("Warning: more vehicles than available driver slots. Some vehicles will not be assigned.");
        }

        // Assign vehicles randomly to drivers (max 2 per driver)
        Random rand = new Random();
        for (Vehicle v : vehicles) {
            boolean assigned = false;
            int attempts = 0;
            while (!assigned && attempts < drivers.size() * 2) {  // avoid infinite loop
                int driverIndex = rand.nextInt(drivers.size());
                Driver driver = drivers.get(driverIndex);
                assigned = driver.addVehicle(v);
                attempts++;
            }
            if (!assigned) {
                System.out.println("Could not assign vehicle: " + v.getPlateID());
            }
        }

        // Print all drivers with their vehicles
        for (Driver driver : drivers) {
            System.out.println(driver);
            System.out.println();
        }
    }
}
