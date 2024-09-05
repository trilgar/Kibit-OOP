// абстрактні класи
package lecture2.example5;

abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Абстрактний метод, який буде реалізований у підкласах
    public abstract void makeSound();
}

abstract class AnimalWithBackbone extends Animal {
    protected boolean hasBackbone = true;

    public AnimalWithBackbone(String name, int age) {
        super(name, age);
    }

    public boolean hasBackbone() {
        return hasBackbone;
    }
}

abstract class AnimalWithoutBackbone extends Animal {
    protected boolean hasBackbone = false;

    public AnimalWithoutBackbone(String name, int age) {
        super(name, age);
    }

    public boolean hasBackbone() {
        return hasBackbone;
    }
}

// конкретні класи

class Mammal extends AnimalWithBackbone {
    private String furColor;

    public Mammal(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    public String getFurColor() {
        return furColor;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: I'm a mammal!");
    }
}

class Fish extends AnimalWithBackbone {
    private boolean isSaltwater;

    public Fish(String name, int age, boolean isSaltwater) {
        super(name, age);
        this.isSaltwater = isSaltwater;
    }

    public boolean isSaltwater() {
        return isSaltwater;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Blub blub!");
    }
}

class Amphibian extends AnimalWithBackbone {
    private String skinType;

    public Amphibian(String name, int age, String skinType) {
        super(name, age);
        this.skinType = skinType;
    }

    public String getSkinType() {
        return skinType;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Croak croak!");
    }
}

class Insect extends AnimalWithoutBackbone {
    private int numberOfLegs;

    public Insect(String name, int age, int numberOfLegs) {
        super(name, age);
        this.numberOfLegs = numberOfLegs;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Buzz buzz!");
    }
}
