package lecture11.factory;

public class FactoryExample {
    private static VehicleFactory initFactory(String type) {
        VehicleFactory vehicleFactory;
        if (type.equals("car")) {
            vehicleFactory = new CarFactory();
        } else if (type.equals("motorcycle")) {
            vehicleFactory = new MotorcycleFactory();
        } else {
            vehicleFactory = new TruckFactory();
        }
        return vehicleFactory;
    }

    public static void main(String[] args) {
        // Створення автомобіля через фабрику
        VehicleFactory carFactory = initFactory("car");
        Vehicle car = carFactory.createVehicle();
        car.drive();

        // Створення мотоцикла через фабрику
        VehicleFactory motorcycleFactory = initFactory("motorcycle");
        Vehicle motorcycle = motorcycleFactory.createVehicle();
        motorcycle.drive();

        // Створення вантажівки через фабрику
        VehicleFactory truckFactory = initFactory("truck");
        Vehicle truck = truckFactory.createVehicle();
        truck.drive();
    }
}


// Інтерфейс для транспортних засобів
interface Vehicle {
    void drive();
}

// Конкретний клас - Автомобіль
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

// Конкретний клас - Мотоцикл
class Motorcycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a motorcycle");
    }
}

// Конкретний клас - Вантажівка
class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck");
    }
}

// Фабрика для створення транспортних засобів
interface VehicleFactory {
    Vehicle createVehicle();
}

// Фабрика для створення автомобілів
class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

// Фабрика для створення мотоциклів
class MotorcycleFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }
}

// Фабрика для створення вантажівок
class TruckFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}
