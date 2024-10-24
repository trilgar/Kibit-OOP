package lecture10.dry.example2;

public class GoodExample {
    public interface Shape {
        double area();
    }

    public class Rectangle implements Shape {
        private double width;
        private double height;

        @Override
        public double area() {
            return width * height;
        }
    }

    public class Triangle implements Shape {
        private double base;
        private double height;

        @Override
        public double area() {
            return (base * height) / 2;
        }
    }

    public class Circle implements Shape {
        private double radius;

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

}
