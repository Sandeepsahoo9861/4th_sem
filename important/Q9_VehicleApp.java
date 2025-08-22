//Write a Java program demonstrating interfaces, method overriding, and method  
//overloading. Define a Vehicle interface with abstract methods accelerate() and 
//brake(). Implement Car and Bicycle classes that override these methods with specific 
//messages for acceleration and braking. Introduce method overloading in both classes 
//by defining multiple accelerate() methods with different parameters (e.g., speed, 
//duration). In the VehicleApp class, instantiate Car and Bicycle objects, test 
//overridden methods, and invoke overloaded accelerate() methods to showcase 
//polymorphism




package important;

interface Vehicle {
    void accelerate();
    void brake();
}
class car implements Vehicle {
    @Override
    public void accelerate() {
        System.out.println("Car is accelerating.");
    }
    @Override
    public void brake() {
        System.out.println("Car is braking.");
    }
    public void accelerate(int speed) {
        System.out.println("Car is accelerating at " + speed + " km/h.");
    }
    public void accelerate(int speed, int duration) {
        System.out.println("Car is accelerating at " + speed + " km/h for " + duration + " seconds.");
    }
}
class Bicycle implements Vehicle {
    @Override
    public void accelerate() {
        System.out.println("Bicycle is speeding up.");
    }
    @Override
    public void brake() {
        System.out.println("Bicycle is slowing down.");
    }
    public void accelerate(int speed) {
        System.out.println("Bicycle is accelerating at " + speed + " km/h.");
    }
    public void accelerate(int speed, int duration) {
        System.out.println("Bicycle is accelerating at " + speed + " km/h for " + duration + " seconds.");
    }
}
public class Q9_VehicleApp {
    public static void main(String[] args) {
        car car = new car();
        Bicycle bicycle = new Bicycle();
        System.out.println("Testing Car methods:");
        car.accelerate();
        car.brake();
        System.out.println();
        System.out.println("Testing Bicycle methods:");
        bicycle.accelerate();
        bicycle.brake();
        System.out.println();
        System.out.println("Testing method overloading in Car:");
        car.accelerate(60);
        car.accelerate(80, 10);
        System.out.println();
        System.out.println("Testing method overloading in Bicycle:");
        bicycle.accelerate(20);
        bicycle.accelerate(30, 5);
    }
}
