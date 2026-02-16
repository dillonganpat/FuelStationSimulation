package FuelStationSimulation;


public class Vehicle {
    private double tankCapacity;
    private String fuelType;
    private static int plateNumberCounter = 0;
    private String plateID;
    private String make;
    private String model;
    private int year;
    private int vehicleClassification;


    // Constructors
    public Vehicle(double tankCapacity, String fuelType) {
        this.tankCapacity = tankCapacity;
        this.fuelType = fuelType;
        this.make = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.vehicleClassification = 0;

        plateNumberCounter++;
        this.plateID = "V" + plateNumberCounter;
    }

    public Vehicle(double tankCapacity, String fuelType, String make, String model, int year) {
        this(tankCapacity, fuelType);
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Vehicle(double tankCapacity, String fuelType, String make, String model, int year, int vehicleClassification) {
        this(tankCapacity, fuelType, make, model, year);
        this.vehicleClassification = vehicleClassification;
    }

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vehicleClassification = 0;

        plateNumberCounter++;
        this.plateID = "V" + plateNumberCounter;
    }

    public Vehicle(String make, String model, int year, int classification) {
        this(make, model, year);
        this.vehicleClassification = classification;
    }


    // Getters
    public String getFuelType() {
        return fuelType;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public String getPlateID() {
        return plateID;
    }

    public int getVehicleClassification() {
        return vehicleClassification;
    }

    public String getVehicleClassification(int format) {
        switch (vehicleClassification) {
            case 1:
                return "Motorcycle";
            case 3:
                return "Light motor vehicle";
            case 4:
                return "Heavy motor vehicle";
            default:
                return "Unknown";
        }
    }

    //toString
    @Override
    public String toString() {
        return "Vehicle [" + plateID + "] " +
                "Make: " + make +
                ", Model: " + model +
                ", Year: " + year +
                ", Fuel Type: " + fuelType +
                ", Tank Capacity: " + tankCapacity +
                ", Classification: " + getVehicleClassification(0);
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle other = (Vehicle) obj;
            return this.plateID.equals(other.plateID);
        }
        return false;
    }
}
