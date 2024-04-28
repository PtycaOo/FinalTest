import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    private final Datebase datebase;
    private final Scanner scanner;

    public Start(Datebase datebase){
        this.datebase = datebase;
        scanner = new Scanner(System.in);
    }

    public void menu(){
        while(true){
            try {
                System.out.println("Выберите дейтсвие");
                System.out.println("1. Добавить животное");
                System.out.println("2. Добавит способность животному");
                System.out.println("3. Вывести список команд животного");
                System.out.println("4. Вывести список животных");
                int choise = scanner.nextInt();

                switch (choise){
                    case 1: addAnimals();
                    break;
                    case 2:
                }



            } catch (InputMismatchException e) {
                System.out.println("Упс... Где то ошибка");
                scanner.nextLine();
            }
        }
    }

    private void addAnimals() {
        System.out.println("Введите имя животного: ");
        String name = scanner.next();
        System.out.println("Введите навык животного: ");
        String abilities = scanner.next();
        System.out.println("Введите дату рождения животного в формате дд.мм.гггг");
        String age = scanner.next();
        System.out.println("Выберете класс животного:\n" + "1. Собака\n" + "2. Кошка\n" + "3. Хомяк\n");
        int type = scanner.nextInt();
        scanner.nextLine();

        Animals animals;

        switch (type){
            case 1 -> animals = new Dog(name, abilities, age);
            case 2 -> animals = new Cat(name, abilities, age);
            case 3 -> animals = new Hamster(name, abilities ,age);
            default -> {
                System.out.println("Нет такого животного =( ");
                return;
            }
        }
        datebase.addAnimals(animals);
        System.out.println("Животное добавленно");
    }
}
