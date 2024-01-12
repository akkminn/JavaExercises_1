public class Motorcycle implements Vehicle, MotorVehicle {
    
    private String make; 
    private String model;
    private int year;
    private int wheels;
    private String type;

    // Constructor of motorcycle
    public Motorcycle (String make, String model, int year, int wheels, String type) {

        this.make = make;
        this.model = model;
        this.year = year;
        this.wheels = wheels;
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

    // Implementation of setWheel()
    @Override
    public void setWheel (int wheels) {
        this.wheels = wheels;
    }

    // Implementation of setType()
    @Override
    public void setType(String type) {
        this.type = type;
    }

    // Implementation of getWheel()
    @Override
    public int getWheel() {
        return wheels;
    }

    // Implementation of getType() 
    @Override
    public String getType() {
        return type;
    }

}
