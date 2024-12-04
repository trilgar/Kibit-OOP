package lecture16.example11;

public class HashCodeExample {
}


class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        // (int) (Math.random() * 100); - невірна реалізація
        // 42  - правильна але погана реалізація (усі об'єкти будуть мати однаковий хешкод)
        // x + y - правильна реалізація, але може бути колізія
        return x * 97 + y; // - правильна реалізація
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Point p) {
            return this.x == p.x && this.y == p.y;
        }
        else {
            return false;
        }
    }
}