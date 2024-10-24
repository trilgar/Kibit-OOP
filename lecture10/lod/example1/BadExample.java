package lecture10.lod.example1;

public class BadExample {
    public class Driver {
        private Car car;

        public void checkFuel() {
            double fuelLevel = car.getEngine().getFuelTank().getFuelLevel();
            if (fuelLevel < 10) {
                System.out.println("Low fuel level");
            }
        }
    }

    public class Car {
        private Engine engine;

        public Engine getEngine() {
            return engine;
        }
    }

    public class Engine {
        private FuelTank fuelTank;

        public FuelTank getFuelTank() {
            return fuelTank;
        }
    }

    public class FuelTank {
        private double fuelLevel;

        public double getFuelLevel() {
            return fuelLevel;
        }
    }



}

