package lecture15.visitor.doubledispatch.solving;

public class Solving {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Shape(),
                new Dot(1, 2),
                new Circle(5, 5, 10),
                new Rectangle(0, 0, 15, 20)
        };
        ExporterVisitor exporter = new ExporterVisitor();

        System.out.println("Exporting shapes to XML:");
        for (Shape shape : shapes) {
            shape.accept(exporter);
        }
    }
}

interface Graphic {
    void draw();
}

interface ShapeVisitor {
    void visit(Shape shape);

    void visit(Dot dot);

    void visit(Circle circle);

    void visit(Rectangle rectangle);
}

class ExporterVisitor implements ShapeVisitor {
    @Override
    public void visit(Shape shape) {
        System.out.println("Exporting shape");
    }

    @Override
    public void visit(Dot dot) {
        System.out.println("Exporting dot");
    }

    @Override
    public void visit(Circle circle) {
        System.out.println("Exporting circle");
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Exporting rectangle");
    }
}

interface VisitorAcceptor {
    void accept(ShapeVisitor visitor);
}

class Shape implements Graphic, VisitorAcceptor {
    public void move(int x, int y) {
        System.out.println("Move shape");

    }

    @Override
    public void draw() {
        System.out.println("Draw shape");
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
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

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
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

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
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

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}