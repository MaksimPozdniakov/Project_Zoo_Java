package program.model.animals.mainClass;

public class AnimalClass {
    protected int id;
    protected String typeAnimal;
    protected String animalBreed;
    protected String name;
    protected int age;

    protected AnimalClass(int id, String typeAnimal, String animalBreed, String name, int age){
        this.id = id;
        this.typeAnimal = typeAnimal;
        this.animalBreed = animalBreed;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + " " + typeAnimal + " " + animalBreed + " " + name + " " + age;
    }

}
