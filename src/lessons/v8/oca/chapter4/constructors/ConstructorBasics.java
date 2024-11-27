package lessons.v8.oca.chapter4.constructors;

public class ConstructorBasics {

    static class Vehicle {
        final String type;
        public Vehicle(String type) {
            this.type = type;
            System.out.println("Vehicle constructor called: " + type);
        }
    }

    static class Car extends Vehicle {
        String brand;
        int year;
        public Car() {
            super("Car");
            this.brand = "Unknown";
            this.year = 0;
            System.out.println("Default Car constructor called");
        }
        public Car(String brand) {
            this();
            this.brand = brand;
            System.out.println("Car constructor with brand: " + brand);
        }

        public Car(String brand, int year) {
            this(brand);
            this.year = year;
            System.out.println("Car constructor with brand and year: " + brand + ", " + year);
        }

        public void display() {
            System.out.println("Vehicle Type: " + type + ", Brand: " + brand + ", Year: " + year);
        }
    }

    public static void main(String[]args){
        Car defaultCar = new Car();
        defaultCar.display();

        Car brandCar = new Car("Toyota");
        brandCar.display();

        Car detailedCar = new Car("Tesla", 2022);
        detailedCar.display();
    }
}
