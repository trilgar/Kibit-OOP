package lecture15.visitor.doubledispatch.problem;

interface Graphic {
    void draw();
}

class Shape implements Graphic {
    public void move(int x, int y) {
        System.out.println("Move shape");

    }

    @Override
    public void draw() {
        System.out.println("Draw shape");
    }
}

class Dot extends Shape {
    int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Dot at (" + x + ", " + y + ")");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Circle extends Shape {
    int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle at (" + x + ", " + y + ") with radius " + radius);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}

class Rectangle extends Shape {
    int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class Exporter {
    public void export(Dot dot) {
        System.out.println("Exporting Dot");
    }

    public void export(Circle circle) {
        System.out.println("Exporting Circle");
    }

    public void export(Rectangle rectangle) {
        System.out.println("Exporting Rectangle");
    }

    public void export(Shape shape) {
        System.out.println("Exporting Shape");
    }

}

public class ProblemExample {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Shape(),
                new Dot(1, 2),
                new Circle(5, 5, 10),
                new Rectangle(0, 0, 15, 20)
        };
        Exporter exporter = new Exporter();

        System.out.println("Exporting shapes to XML:");
        for (Shape shape : shapes) {
            exporter.export(shape);
        }
    }
}
