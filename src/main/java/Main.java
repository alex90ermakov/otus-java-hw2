
import animals.Animal;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalFactory;
import data.InputIntValidator;
import data.InputStringValidator;
import menu.Command;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        //Добавил сканнер
        Scanner scanner = new Scanner(System.in);

        //Добавил валидатор для int значений.
        InputIntValidator validator = new InputIntValidator(scanner);
        InputStringValidator validator1 = new InputStringValidator(scanner);

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
                    String name = validator1.getValidInput("Как зовут животное?", "Имя должно", 1,15).trim().toUpperCase();

                    int age = validator.getValidInput("Сколько ему лет?", "Возраст должен", 1, 20);

                    int weight = validator.getValidInput("Сколько оно весит?", "Вес должен", 1, 100);

                    String color = validator1.getValidInput("Какого цвета животное?", "Вводи", 1, 15).trim().toUpperCase();


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
