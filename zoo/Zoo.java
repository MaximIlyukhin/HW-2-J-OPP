package zoo;

import java.util.ArrayList;
import animal.Animal;

public class Zoo {
    private ArrayList<Animal> zooList;

    public Zoo() {
        this.zooList = new ArrayList<Animal>();
    }

    public void add(Animal animal) {
        zooList.add(animal);
    }

    public void remove(int i) {
        zooList.remove(i - 1);
    }

    public void show(int i) {
        for (String property : zooList.get(i - 1).toString().split(", ")) {
            System.out.println(property);
        }
    }

    public void showAll() {
        for (int i = 1; i <= zooList.size(); i++) {
            System.out.printf("%d. %s",
                    i, zooList.get(i).toString());
        }
    }

    public void makeSound(int i) {
        System.out.printf("%s издает звук \"%s\"\n",
                zooList.get(i).getClass().getSimpleName(), zooList.get(i).getSound());
    }

    public void makeSoundAll() {
        for (Animal animal : zooList) {
            System.out.printf("%s издает звук \"%s\"\n",
                    animal.getClass().getSimpleName(), animal.getSound());
        }
    }

    public Animal getAnimal(int i) {
        return zooList.get(i);
    }

    public ArrayList<Animal> getAll() {
        return zooList;
    }
}
