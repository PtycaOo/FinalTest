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
                System.out.println("5. Сохранить и выйти");
                System.out.print("Терминал ждет команду: ");
                int choise = scanner.nextInt();

                switch (choise){
                    case 1: addAnimals();
                        break;
                    case 2: teachNewAbilities();
                        break;
                    case 3:
                        break;
                    case 4: datebase.displayAllAnimals();
                        break;
                    case 5:
                        return;
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
        System.out.println("Введите дату рождения животного в формате дд.мм.гггг");
        String age = scanner.next();
        System.out.println("Введите навык животного: ");
        String abilities = scanner.next();
        System.out.print("Выберете класс животного:\n" + "1. Собака\n" + "2. Кошка\n" + "3. Хомяк\n" + "Выберите класс животного: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        Animals animals;

        switch (type){
            case 1 -> animals = new Dog(name,age, abilities);
            case 2 -> animals = new Cat(name,age, abilities);
            case 3 -> animals = new Hamster(name,age, abilities);
            default -> {
                System.out.println("Нет такого животного =( ");
                return;
            }
        }
        datebase.addAnimals(animals);
        datebase.saveDatabase();
        System.out.println("Животное добавленно");
        System.out.println();
    }

    private void teachNewAbilities(){
        System.out.println("Введите имя искомого животного");
        String name = scanner.next();
        System.out.println("Чему научить животное?");
        String abilities = scanner.next();

        datebase.newAbilities(name,abilities);
        datebase.saveDatabase();
        System.out.println("Навык добавлен");
        System.out.println();
        System.out.println("Нажмите Enter для продолжения");
        String wait = scanner.next();
        if(wait.equals(null)){
            return;
        }
    }
}
