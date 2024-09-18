package lecture5.example41;

public class StaticBindingExample {
    public static void main(String[] args) {
        // create triangle, square and circle objects
        // create an array of shapes
        // loop through the array and call the calculateArea method. Define the class of object using switch with instanceof
        Triangle triangle = new Triangle(10, 20);
        Square square = new Square(10);
        Circle circle = new Circle(10);
        Object[] shapes = {triangle, square, circle};
        for (Object shape : shapes) {
            switch (shape){
                case Triangle t -> t.calculateTriangleArea();
                case Square s -> s.calculateSquareArea();
                case Circle c -> c.calculateCircleArea();
                default -> System.out.println("Unknown shape");
            }
        }
    }
}

class Triangle {
    private String name;
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.name = "Triangle";
        this.base = base;
        this.height = height;
    }

    public void calculateTriangleArea() {
        double area = 0.5f * base * height;
        System.out.printf("Area of %s is %s%n", name, area);
    }
}

class Circle {
    private String name;
    private double radius;

    public Circle(double radius) {
        this.name = "Circle";
        this.radius = radius;
    }

    public void calculateCircleArea() {
        double area = (3.14 * radius * radius);
        System.out.printf("Area of %s is %s%n", name, area);
    }
}

class Square {
    private String name;
    private double side;

    public Square(double side) {
        this.name = "Square";
        this.side = side;
    }

    public void calculateSquareArea() {
        double area = side * side;
        System.out.printf("Area of %s is %s%n", name, area);
    }
}

