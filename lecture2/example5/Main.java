package lecture2.example5;

public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкти конкретних класів
        Mammal mammal = new Mammal("Elephant", 10, "Gray");
        Fish fish = new Fish("Shark", 5, true);
        Amphibian amphibian = new Amphibian("Frog", 2, "Moist");
        Insect insect = new Insect("Beetle", 1, 6);

        // Викликаємо методи для кожного об'єкта
        System.out.println(mammal.getName() + " is " + mammal.getAge() + " years old and has " + mammal.getFurColor() + " fur.");
        mammal.makeSound();

        System.out.println(fish.getName() + " is " + fish.getAge() + " years old and is " + (fish.isSaltwater() ? "a saltwater" : "a freshwater") + " fish.");
        fish.makeSound();

        System.out.println(amphibian.getName() + " is " + amphibian.getAge() + " years old and has " + amphibian.getSkinType() + " skin.");
        amphibian.makeSound();

        System.out.println(insect.getName() + " is " + insect.getAge() + " years old and has " + insect.getNumberOfLegs() + " legs.");
        insect.makeSound();

        // Пробуємо створити об'єкт абстрактного класу
        // Animal animal = new Animal(); // Помилка компіляції
    }
}
