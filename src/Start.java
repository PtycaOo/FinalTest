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
                System.out.println("Добавить животное");
                System.out.println();
                System.out.println();
                System.out.println();
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
        String name = scanner.nextLine();
        System.out.println("Введите навык животного: ");
        String abilities = scanner.nextLine();
        System.out.println("Введите дату рождения животного в формате дд.мм.гггг");
        String age = scanner.nextLine();
        System.out.println("Выберете класс животного:\n" + "1. Собака\n" + "2. Кошка\n" + "3. Хомяк\n");
        int type = scanner.nextInt();

        Animals animals;
        switch (type){
            case 1: animals = new Dog(name, abilities, age);
            break;
            case 2: animals = new Cat(name, abilities, age);
            break;
            case 3: animals = new Hamster(name, abilities ,age);
            break;
            default: {
                System.out.println("Нет такого животного =( ");
                break;
            }
        }
    }

    public Datebase getDatebase() {
        return datebase;
    }
}
