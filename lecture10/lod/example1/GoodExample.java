package lecture10.lod.example1;

public class GoodExample {
    public class Driver {
        private Car car;

        public void checkFuel() {
            double fuelLevel = car.getFuelLevel();
            if (fuelLevel < 10) {
                System.out.println("Low fuel level");
            }
        }
    }
    public class Car {
        private Engine engine;

        public double getFuelLevel() {
            return engine.getFuelLevel();
        }
    }

    public class Engine {
        private FuelTank fuelTank;

        public double getFuelLevel() {
            return fuelTank.getFuelLevel();
        }
    }

    public class FuelTank {
        private double fuelLevel;

        public double getFuelLevel() {
            return fuelLevel;
        }
    }

}
