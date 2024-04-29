import java.io.*;
import java.util.*;

public class Datebase implements Iterable<Animals>{
    private final List<Animals> animals;
    private static final String filePath = "src/datebase.txt";
    private Scanner sc = new Scanner(System.in);

    public Datebase(){
        animals = new ArrayList<>();
        loadDatabase();
    }


    public void addAnimals(Animals pet){
        animals.add(pet);
    }

    @Override
    public Iterator<Animals> iterator() {
        return new AnimalIterator(animals);
    }

    void saveDatabase() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Animals animals : animals) {
                String className = animals.getClass().getSimpleName();
                String name = animals.getName();
                String age = animals.getAge();
                String abilities = animals.getAbilities().replaceAll(",\\s+", ", ");


                String line = className + "," + name + "," + age + "," + abilities;
                writer.write(line);
                writer.newLine();
            }
            System.out.println("База данных успешно сохранена.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении базы данных: " + e.getMessage());
        }
    }

    private void loadDatabase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String className = data[0];
                    String name = data[1];
                    String age = data[2];
                    String abilities = String.join(",", Arrays.copyOfRange(data, 3, data.length));



                    Animals animal;

                    switch (className) {
                        case "Dog" -> animal = new Dog(name,age, abilities);
                        case "Cat" -> animal = new Cat(name,age, abilities);
                        case "Hamster" -> animal = new Hamster(name,age, abilities);
                        default -> {
                            System.out.println("Неизвестный класс животного: " + className);
                            continue;
                        }
                    }
                    animals.add(animal);
                } else {
                    System.out.println("Ошибка в файле: " + line);
                }
            }
            System.out.println("База данных успешно загружена.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении базы данных: " + e.getMessage());
        }
    }

    public void showAllAnimals() {
        int id = 1;
            try {
                FileReader file = new FileReader(filePath);
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()) {
                    String animalData = fileScanner.nextLine();
                    System.out.println(id++ + " " + animalData);
                    System.out.println();
                }

                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден.");
                return;
            }
        System.out.println("Нажмите Enter для продолжения: ");
            String x = sc.nextLine();
            if(x.equals(null)){
                return;
            }
    }

    public void newAbilities(String name, String abilities){
        for(Animals animals : animals){
            if(animals.getName().equals(name)){
                animals.addCommand(abilities);
            }
        }
    }

    public void showAbilities(String name){
        for(Animals animal: animals){
            if(animal.getName().equals(name)){
                animal.showAbilities();
                return;
            }
        }
        System.out.println("Такого животно нет");
    }



}
