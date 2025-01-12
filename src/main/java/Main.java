
import animals.Animal;
import data.AnimalFactory;
import data.InputIntValidator;
import menu.Command;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        //Добавмил сканнер
        Scanner scanner = new Scanner(System.in);

        //Добавил валидатор для int значений.
        InputIntValidator validator = new InputIntValidator(scanner);

        //Создал ArrayList Animal
        List<Animal> animals = new ArrayList<>();

        //меню
        while (true) {
            System.out.println("Привет! Вводи команду Add / List / Exit : ");

            String input = scanner.nextLine().toUpperCase().trim();

            Command command = Command.fromString(input);

            if (command == null) {
                System.out.print("Неверная команда, попробуйте еще : ");
                continue;
            }
            //переключатель комманд.
            switch (command) {
                case ADD:
                    System.out.println("Выберите животное: cat/dog/duck");

                    String type;
                    boolean rightType = false;
                    do{
                        type = scanner.nextLine().trim().toUpperCase();
                      if ("CAT".equals(type) || "DOG".equals(type) || "DUCK".equals(type)){
                          rightType = true;
                      }else {
                          System.out.println("Неизвестное животное, попробуйте еще раз");
                      }
                    } while (!rightType);

                    //Проверка на ввод int значений возраста и веса.
                    System.out.println("Как зовут животное?");
                    String name = scanner.nextLine().trim();

                    int age = validator.getValidInput("Сколько ему лет?", "Возраст должен", 1, 20);

                    int weight = validator.getValidInput("Сколько оно весит?", "Вес должен", 1, 100);

                    System.out.println("Какого цвета животное?");
                    String color = scanner.nextLine().trim().toUpperCase();

                    try {
                        Animal newAnimal = AnimalFactory.createAnimal(type, name, age, weight, color);
                        animals.add(newAnimal);
                        newAnimal.say();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.print("Вводи команду Add / List / Exit : ");
                    break;

                case LIST:
                    if (animals.isEmpty()) {
                        System.out.print("Список пуст, добавьте животное Add / Exit : ");
                    } else {
                        for (Animal animal : animals) {
                            System.out.println(animal.toString());
                        }
                        System.out.print("Вводи команду Add / List / Exit : ");
                    }
                    break;

                case EXIT:
                        System.out.println("Выход");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Не верная команда");;
            }
        }
    }
}
