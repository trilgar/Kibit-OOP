package lecture10.dry.example2;

public class BadExample {
    class Rectangle {
        private double width;
        private double height;

        public double area() {
            return width * height;
        }
    }

    class Triangle {
        private double base;
        private double height;

        public double area() {
            return (base * height) / 2;
        }
    }

    class Circle {
        private double radius;

        public double area() {
            return Math.PI * radius * radius;
        }
    }
}


