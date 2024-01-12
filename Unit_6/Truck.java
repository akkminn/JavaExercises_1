public class Truck implements Vehicle, TruckVehicle{

    private String make; 
    private String model;
    private int year;
    private int tons;
    private String type;

    // Constructor of Truck
    public Truck (String make, String model, int year, int tons, String type) {

        this.make = make;
        this.model = model;
        this.year = year;
        this.tons = tons;
        this.type = type;
    }
    
    // Implementation of getMake()
    @Override
    public String getMake() {
        return make;
    }

    // Implementation of getModel()
    @Override
    public String getModel() {
        return model;
    }

    // Implementation of getYear()
    @Override
    public int getYear() {
        return year;
    }

    // Implementation of setCapacity()
    @Override
    public void setCapacity(int tons) {
        this.tons = tons;
    }

    // Implementation of setType()
    @Override
    public void setType(String type) {
        this.type = type;
    }

    // Implementation of getCapacity()
    @Override
    public int getCapacity() {
        return tons;
    }

    // Implementation of getType()
    @Override
    public String getType() {
        return type;
    }
}
