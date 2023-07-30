package program.model.readandwrite;

import com.google.gson.Gson;
import program.model.animals.mainClass.AnimalClass;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class ReadClass {
    private static final Gson gson = new Gson();
    public static ArrayList<AnimalClass> readFromJson(String filePath){
        try (Reader reader = new FileReader(filePath)){
            AnimalWrapper animalWrapper = gson.fromJson(reader, AnimalWrapper.class);
            return new ArrayList<>(animalWrapper.getAnimals());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


