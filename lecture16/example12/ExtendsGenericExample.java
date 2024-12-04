package lecture16.example12;

public class ExtendsGenericExample {
    public static void main(String[] args) {
        Example<ParentObject> example = new Example<>(new ChildObject());
        example.display();

        // Example<ChildObject> example2 = new Example<>(new ParentObject()); // Помилка компіляції

        // Example<GrandChildObject> example3 = new Example<>(new GrandChildObject());
    }

}

class Example<T extends ParentObject> {
    T value;

    public Example(T value) {
        this.value = value;
    }

    public void display() {
        value.someMethod(); // Метод доступний, оскільки T — це підтип SomeObject
    }
}

class ParentObject {
    public void someMethod() {
        System.out.println("Parent object method");
    }
}

class ChildObject extends ParentObject {
    @Override
    public void someMethod() {
        System.out.println("Child object method");
    }
}

class GrandChildObject extends ChildObject {
    @Override
    public void someMethod() {
        System.out.println("Grandchild object method");
    }
}
