public class Car implements Vehicle, CarVehicle {

    private String make; 
    private String model;
    private int year;
    private int door;
    private String type;

    // Constructor for Car
    public Car(String make, String model, int year, int door, String type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.door = door;
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

    // Implementation of setDoor()
    @Override
    public void setDoor(int door) {
        this.door = door;
    }

    // Implementation of setType()
    @Override
    public void setType(String type) {
        this.type = type;
    }

    // Implementation of getDoor() 
    @Override
    public int getDoor() {
        return door;
    }

    // Implementation of getType()
    @Override
    public String getType() {
        return type;
    }
}
