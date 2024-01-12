public class Main {
    public static void main(String[] args) throws Exception {
        
        // Create vehicle1 of type Car
        Car vehicle1 = new Car("Tesla", "Model S", 2022, 4, "Electric");
       
        // Create vehicle2 of type Motorcycle
        Motorcycle vehicle2 = new Motorcycle("Ducati", "Panigale V4", 2022, 2, "Sport");
        
        // Create vehicle1 of type Truck        
        Truck vehicle3 = new Truck("Ford", "F-150", 2022, 1, "Automatic");

        // Retrieve information of vehicle1
        System.out.println(
            "I have a sleek and eco-friendly " + vehicle1.getMake() + " "
            + vehicle1.getModel() + ", a " + vehicle1.getYear() + " model with "
            + vehicle1.getDoor() + " doors, powered by " + vehicle1.getType()
            + " for a modern and sustainable automotive experience."
        );

        // Retrieve information of vehicle2
        System.out.println(
            "I also have an exhilarating " + vehicle2.getMake() + " "
            + vehicle2.getModel() + ", a " + vehicle2.getType() + " motorcycle from "
            + vehicle2.getYear() + " with " + vehicle2.getWheel() 
            + " wheels, delivering a thrilling ride with its powerful engine."
        );

        // Retrieve the information of vehicle3
        System.out.println(
            "I also own a robust " + vehicle3.getMake() + " "
            + vehicle3.getModel() + ", featuring an " + vehicle3.getType()
            + " and the capability to handle " + vehicle3.getCapacity() 
            + " ton of cargo with its impressive tonnage capacity."
        );

    }
}
