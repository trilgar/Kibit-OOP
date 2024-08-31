// абстрактні класи
package lecture2.example5;

abstract class Animal {
}

abstract class AnimalWithBackbone extends Animal {
}

abstract class AnimalWithoutBackbone extends Animal {
}

// конкретні класи

class Mammal extends AnimalWithBackbone {
    public Mammal() {
    }
}

class Fish extends AnimalWithBackbone {
    public Fish() {
    }
}

class Amphibian extends AnimalWithBackbone {
    public Amphibian() {
    }
}

class Insect extends AnimalWithoutBackbone {
    public Insect() {
    }
}