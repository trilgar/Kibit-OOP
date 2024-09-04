package lecture1;

class First {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("Сума елементів: " + sum);
    }
}

class Second {
    // Функція для обчислення суми елементів масиву за допомогою рекурсії
    public static int calculateSum(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        }
        return numbers[index] + calculateSum(numbers, index + 1);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = calculateSum(numbers, 0);
        System.out.println("Сума елементів: " + sum);
    }
}