package program.model.readandwrite;

import com.google.gson.Gson;
import program.model.AnimalCounter;
import program.model.animals.mainClass.AnimalClass;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class ReadClass {
    private static final Gson gson = new Gson();
    public static ArrayList<AnimalClass> readFromJson(String filePath, AnimalCounter counter){
        try (Reader reader = new FileReader(filePath)){
            AnimalWrapper animalWrapper = gson.fromJson(reader, AnimalWrapper.class);

            if (animalWrapper != null){
                counter.setCount(animalWrapper.getAnimals().size());
                return new ArrayList<>(animalWrapper.getAnimals());
            } else {
                // Возвращаем пустой список, если файл пустой
                return new ArrayList<>();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


