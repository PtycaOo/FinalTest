import java.util.Iterator;
import java.util.List;

public class AnimalIterator implements Iterator<Animals> {
    private int index = 0;
    private List<Animals> animalList;

    public AnimalIterator(List<Animals> animalList){
        this.animalList = animalList;
    }
    @Override
    public boolean hasNext() {
        return index < animalList.size();
    }

    @Override
    public Animals next() {
        return animalList.get(index++);
    }
}
