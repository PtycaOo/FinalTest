import java.util.ArrayList;
import java.util.List;

public class Datebase {
    private final List<Animals> animals;

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
}
