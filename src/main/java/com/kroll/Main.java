package com.kroll;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Додати користувача");
            System.out.println("2. Додати товар");
            System.out.println("3. Створити замовлення");
            System.out.println("4. Відобразити доступні товари");
            System.out.println("5. Відобразити користувачів");
            System.out.println("6. Відобразити замовлення");
            System.out.println("7. Оновити запас товару");
            System.out.println("8. Вийти");
            System.out.print("Виберіть опцію: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть ім'я користувача: ");
                    String username = scanner.nextLine();
                    User newUser = new User(platform.generateUserId(), username);
                    platform.addUser(newUser);
                    System.out.println("Користувач доданий успішно!");
                    break;

                case 2:
                    System.out.print("Введіть назву товару: ");
                    String productName = scanner.nextLine();
                    System.out.print("Введіть ціну товару: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Введіть кількість товару на складі: ");
                    int productStock = scanner.nextInt();

                    Product newProduct = new Product(platform.generateProductId(), productName, productPrice, productStock);
                    platform.addProduct(newProduct);
                    System.out.println("Товар доданий успішно!");
                    break;

                case 3:
                    System.out.print("Введіть ID користувача: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();

                    User user = platform.getUserById(userId);
                    if (user != null) {
                        System.out.println("Додавання товарів у кошик користувача: " + user.getUsername());
                        platform.displayAvailableProducts();
                        Map<Integer, Integer> productQuantities = new HashMap<>();

                        while (true) {
                            System.out.print("Введіть ID товару (або 0 для завершення): ");
                            int productId = scanner.nextInt();
                            if (productId == 0) {
                                break;
                            }
                            scanner.nextLine();
                            System.out.print("Введіть кількість товару: ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();

                            productQuantities.put(productId, quantity);
                        }

                        platform.createOrder(userId, productQuantities);
                        System.out.println("Замовлення створено успішно!");
                    } else {
                        System.out.println("Користувач не знайдений!");
                    }
                    break;

                case 4:
                    platform.displayAvailableProducts();
                    break;

                case 5:
                    platform.listUsers();
                    break;

                case 6:
                    platform.listOrders();
                    break;

                case 7:
                    System.out.print("Введіть ID товару для оновлення запасу: ");
                    int updateProductId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введіть новий запас товару: ");
                    int newStock = scanner.nextInt();
                    scanner.nextLine();

                    platform.updateProductStock(updateProductId, newStock);
                    System.out.println("Запас товару оновлено успішно!");
                    break;

                case 8:
                    System.out.println("Дякуємо за використання сервісу. До побачення!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }
}

