package lecture5.example42;

public class DynamicBindingExample {
    public static void main(String[] args) {
        // create triangle, square and circle objects
        // create an array of shapes
        // loop through the array and call the calculateArea method. Define the class of object using switch with instanceof
        Triangle triangle = new Triangle(10, 20);
        Square square = new Square(10);
        Circle circle = new Circle(10);
        Shape[] shapes = {triangle, square, circle};

        for (Shape shape : shapes) {
            shape.calculateArea();
        }
    }
}

class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public void calculateArea() {
        System.out.println("Unknown shape");
    }

    public String getName() {
        return name;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    @Override
    public void calculateArea() {
        double area = 0.5f * base * height;
        System.out.printf("Area of %s is %s%n", getName(), area);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        double area = (3.14 * radius * radius);
        System.out.printf("Area of %s is %s%n", getName(), area);
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        super("Square");
        this.side = side;
    }

    public void calculateArea() {
        double area = side * side;
        System.out.printf("Area of %s is %s%n", getName(), area);
    }
}

