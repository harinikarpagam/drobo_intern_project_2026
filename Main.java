class Vehicle {
    void wheel(){
        System.out.println("Vehicle has wheel");
    }
}
class MotorBike extends Vehicle{
    void wheel(){
        System.out.println("The motor bike has two wheels");
    }
}
class Auto extends Vehicle{
    void wheel(){
        System.out.println("The auto has 3 wheels");
    }
}
class Car extends Vehicle{
    void wheel(){
        System.out.println("The car has 4 wheels");
    }
}
public class Main{
    public static void main(String args[]){
    MotorBike m1 = new MotorBike();
    Auto a1 = new Auto();
    Car c1 = new Car();

    m1.wheel();
    c1.wheel();
    a1.wheel();
}
}
