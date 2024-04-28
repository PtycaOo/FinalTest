import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Datebase implements Iterable<Animals>{
    int id;
    private final List<Animals> animals;
    private static final String filePath = "src/datebase.txt";

    public Datebase(){
        animals = new ArrayList<>();
    }

    public void addAnimals(Animals pet){
        animals.add(pet);
    }

    @Override
    public String toString() {
        return "Datebase{" +
                "animals=" + animals +
                '}';
    }

    @Override
    public Iterator<Animals> iterator() {
        return new AnimalIterator(animals);
    }
}
