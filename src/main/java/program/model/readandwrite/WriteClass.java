package program.model.readandwrite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import program.model.animals.mainClass.AnimalClass;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteClass {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void writeToJson(ArrayList<AnimalClass> anmals, String filePath) {
        AnimalWrapper animalWrapper = new AnimalWrapper(anmals);
        try (FileWriter writer = new FileWriter(filePath)){
            gson.toJson(animalWrapper, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


