# Домашнее задание №2
##  Создать родительский класс Animal
### Свойства:
- name
- age
- weight
- color
### Методы:
***Getter and Setter***
- Say(Вывод на экран: "Я говорю"),
- Go(Вывод на экран: "Я иду"),
- Drink(Вывод на экран: "Я пью"),
- Eat(Вывод на экран: "Я ем")
- Переопределите метод toString (Возврат строки: "Привет! меня зовут name, мне age лет(/год/года), я вешу - weight кг, мой цвет - color").<br>
***Примеры:***
- Привет! меня зовут Бобик, мне 5 лет, я вешу - 15 кг, мой цвет - черный
- Привет! меня зовут Бобик, мне 1 год, я вешу - 15 кг, мой цвет - черный
- Привет! меня зовут Бобик, мне 2 года, я вешу - 15 кг, мой цвет - черный

## Создайте интерфейс Flying
### Методы:
- Fly. 

## Создайте класс Cat унаследуйте его от Animal
### Методы:
- Say. 
- Переопределить метод Say(Вывод на экран: "Мяу"). 

## Создайте класс Dog унаследуйте его от Animal
### Методы:
- Say.
- Переопределить метод Say(Вывод на экран: "Гав").

## Создайте класс Duck унаследуйте его от Animal, реализуйте интерфейс Flying
### Методы:
- Say.
- Fly.
- Переопределить метод Say(Вывод на экран: "Кря")
- Реализовать метод Fly(Вывод на экран: "Я лечу")

## В основной программе:
- Создайте ArrayList Animal. 
- Создайте в консоли меню, при входе в приложение на экран выводится запрос команды add/list/exit. 
- Команды оформить в enum. 
- При вводе команды она должна быть регистронезависимой и обрезать пробелы в начале и конце.
   
***Если add*** 

- Спросить какое животное(cat/dog/duck).
- Спросить имя, возраст, вес, цвет.
- Инициализировать класс, добавить экземпляр в ArrayList и вызвать метод Say().
- Вернуться к главному меню.
  
***Если list*** 

- Вывести на экран метод toString() для всех елементов массива.
  
***Если exit***
- Выйти из программы.

    ***
  
