package FuelStationSimulation;

public class FuelStation {
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;

    // Constructor
    public FuelStation(String fuelType, double fuelVolume, double fuelRate) {
        this.fuelType = fuelType;
        this.fuelVolume = fuelVolume;
        this.fuelRate = fuelRate;
        this.fuelSales = 0.0;
    }

    //Getters
    public String getFuelType() {
        return this.fuelType;
    }
    public double getFuelVolume() {
        return this.fuelVolume;
    }
    public double getFuelRate() {
        return this.fuelRate;
    }
    public double getFuelSales() {
        return this.fuelSales;
    }


    //Setters
    public void setFuelRate(double fuelRate) {
        this.fuelRate = fuelRate;
    }
    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }
    public boolean canDispenseFuelType(Vehicle v){
        return (this.fuelType.equals(v.getFuelType()));
    }

    public double dispense (Vehicle v) {
        if (canDispenseFuelType(v)) {
            double v_tankCap = v.getTankCapacity();
            if (this.fuelVolume > v_tankCap) {
                this.fuelVolume = this.fuelVolume - v_tankCap;
                this.fuelSales = this.fuelSales + (v_tankCap * this.fuelRate);
                return v_tankCap;
            }
            System.out.println("WARNING! NOT ENOUGH FUEL");
        }
        return 0;

    }

    //toString
    public String toString() {
        return "fuelStation[fuelType=" + fuelType +
                ", fuelVolume=" + fuelVolume +
                ", fuelRate=" + fuelRate +
                ", fuelSales=" + fuelSales + "]";
    }
}


