// Клас для представлення клієнта
package lecture1;
class Customer {
    String name;
    String address;

    // Метод для надсилання замовлення
    String takeOrder(SalesPerson salesPerson, String sofaType, String deliveryDate) {
        return salesPerson.processOrder(sofaType, deliveryDate);
    }
}

// Клас для представлення продавця
class SalesPerson {
    String name;

    // тут міститься інформація про доступні дивани, доставку та інше

    // Метод для обробки замовлення
    String processOrder(String sofaType, String deliveryDate) {
        if (checkStock(sofaType) && checkDeliveryDate(deliveryDate)) {
            deliverOrder(sofaType, deliveryDate);
            return "Ваше замовлення виконано. Ми доставимо товар у " + deliveryDate;
        } else {
            return "Вибачте, ваш запит не може бути виконано.";
        }
    }

    // Метод для перевірки запасу
    boolean checkStock(String sofaType) {
        // Логіка перевірки запасу
        return true; // припустимо, що товар є на складі
    }

    // Метод для перевірки дати доставки
    boolean checkDeliveryDate(String deliveryDate) {
        // Логіка перевірки дати доставки
        return true; // припустимо, що дата підходить
    }

    // Метод для доставки замовлення
    void deliverOrder(String sofaType, String deliveryDate) {
        // Логіка доставки товару
    }
}