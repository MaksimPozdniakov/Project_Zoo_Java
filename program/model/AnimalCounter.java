package program.model;

public class AnimalCounter implements AutoCloseable{

    private int count = 0;
    private boolean resourceClosed = false;

    public void add(){
        if (resourceClosed) {
            throw new IllegalStateException("Ошибка: Работа с объектом типа AnimalCounter была не в ресурсном try.");
        }

        count++;
    }


    @Override
    public void close(){
        resourceClosed = true;
        if (count == 0) {
            throw new IllegalStateException("Ошибка: Ресурс AnimalCounter был оставлен открытым.");
        }
    }
}
