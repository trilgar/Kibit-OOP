
package lecture11.builder;

public class BuilderExample {
    public static void main(String[] args) {
        House house = House.builder()
                .withWindows(4)
                .withDoors(2)
                .withGarage(true)
                .withSwimmingPool(false)
                .withGarden(true)
                .build();

        System.out.println(house);
    }
}

class House {
    // Необов'язкові параметри
    private final int windows;
    private final int doors;
    private final boolean hasGarage;
    private final boolean hasSwimmingPool;
    private final boolean hasGarden;

    private House(Builder builder) {
        this.windows = builder.windows;
        this.doors = builder.doors;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarden = builder.hasGarden;
    }

    @Override
    public String toString() {
        return "House with " + windows + " windows, " + doors + " doors" +
                (hasGarage ? ", a garage" : "") +
                (hasSwimmingPool ? ", a swimming pool" : "") +
                (hasGarden ? ", a garden" : "") + ".";
    }

    public static Builder builder() {
        return new Builder();
    }

    // Builder клас
    public static class Builder {
        private int windows = 0;
        private int doors = 0;
        private boolean hasGarage = false;
        private boolean hasSwimmingPool = false;
        private boolean hasGarden = false;

        public Builder withWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public Builder withDoors(int doors) {
            this.doors = doors;
            return this;
        }

        public Builder withGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public Builder withSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public Builder withGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}


