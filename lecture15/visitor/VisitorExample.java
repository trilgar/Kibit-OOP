package lecture15.visitor;

interface Shape {
    void move(int x, int y);
    void draw();
    void accept(Visitor visitor);
}

class Dot implements Shape {
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDot(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Circle implements Shape {
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCircle(this);
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

class Rectangle implements Shape {
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRectangle(this);
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

interface Visitor {
    void visitDot(Dot dot);
    void visitCircle(Circle circle);
    void visitRectangle(Rectangle rectangle);
}

class XMLExportVisitor implements Visitor {
    @Override
    public void visitDot(Dot dot) {
        System.out.println("<dot x='" + dot.getX() + "' y='" + dot.getY() + "' />");
    }

    @Override
    public void visitCircle(Circle circle) {
        System.out.println("<circle x='" + circle.getX() + "' y='" + circle.getY() + "' radius='" + circle.getRadius() + "' />");
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("<rectangle x='" + rectangle.getX() + "' y='" + rectangle.getY() + "' width='" + rectangle.getWidth() + "' height='" + rectangle.getHeight() + "' />");
    }
}

public class VisitorExample {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Dot(1, 2),
                new Circle(5, 5, 10),
                new Rectangle(0, 0, 15, 20)
        };

        Visitor exportVisitor = new XMLExportVisitor();

        System.out.println("Exporting shapes to XML:");
        for (Shape shape : shapes) {
            shape.accept(exportVisitor);
        }
    }
}
