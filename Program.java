import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import animal.Animal;
import animal.bird.Fly;
import animal.bird.chicken.Chicken;
import animal.bird.stork.Stork;
import animal.domestic.ShowAffection;
import animal.domestic.cat.Cat;
import animal.domestic.dog.Dog;
import animal.domestic.dog.Train;
import animal.wild.tiger.Tiger;
import animal.wild.wolf.Wolf;
import zoo.Zoo;

public class Program {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.add(new Tiger(0, 0, null, null, null));
        zoo.add(new Wolf(0, 0, null, null, null, false));
        zoo.add(new Cat(0, 0, null, null, null, null, null, null, false));
        zoo.add(new Dog(0, 0, null, null, null, null, null, null, false));
        zoo.add(new Stork(0, 0, null, 0));
        zoo.add(new Chicken(0, 0, null, 0));

        try (Scanner sc = new Scanner(System.in)) {
            workWithZoo(sc, zoo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void workWithZoo(Scanner sc, Zoo zoo) {
        while (true) {
            System.out.println("Главное меню виртуального зоопарка \"Москва-зуу\"");
            System.out.println("\t1. Посмотреть информацию о конкретном животном");
            System.out.println("\t2. Показать информацию о всех животных в зоопарке");
            System.out.println("\t3. Добавить животное в зоопарк");
            System.out.println("\t4. Удалить животное из зоопарка");
            System.out.println("\t5. Заставить животное издать звук");
            System.out.println("\t6. Заставить всех животных издать звук");
            System.out.println("\t7. Показать кто что может (тест интерфейсов)");
            System.out.println("\t8. Выход");
            System.out.print("Выбери действие >: ");

            switch (sc.nextInt()) {
                case 1: {
                    getAnimalToShow(sc, zoo);
                    break;
                }
                case 2: {
                    System.out.println("Все животные зоопарка:");
                    zoo.showAll();
                    break;
                }
                case 3: {
                    getAnimalToAdd(sc, zoo);
                    break;
                }
                case 4: {
                    getAnimalToRemove(sc, zoo);
                    break;
                }
                case 5: {
                    getAnimalForMakeSound(sc, zoo);
                    break;
                }
                case 6: {
                    zoo.makeSoundAll();
                    break;
                }
                case 7: {
                    showAllActivities(zoo);
                    break;
                }
                case 8: {
                    System.out.println("Пока!");
                    ;
                    return;
                }
            }
        }
    }

    private static void showAllActivities(Zoo zoo) {
        for (Animal animal : zoo.getAll()) {
            showActive(animal);
        }
    }

    private static void getAnimalForMakeSound(Scanner sc, Zoo zoo) {
        System.out.println("Меню звуков животных");
        zoo.showAll();
        System.out.println("Введи номер животного для извлечения из него звука >: ");
        zoo.makeSound(sc.nextInt() - 1);
    }

    private static void getAnimalToRemove(Scanner sc, Zoo zoo) {
        System.out.println("Меню удаления животного");
        zoo.showAll();
        System.out.println("Введи номер животного для удаления >: ");
        zoo.remove(sc.nextInt() - 1);
        System.out.println("Животное удалено!");
    }

    private static void showActive(Animal animal) {
        if (animal instanceof ShowAffection) {
            System.out.println(animal.getClass().getSimpleName() +
                    " может " + ((ShowAffection) animal).showAffection());
        }
        if (animal instanceof Train) {
            System.out.println(animal.getClass().getSimpleName() +
                    " может " + ((Train) animal).train());
        }
        if (animal instanceof Fly) {
            System.out.println(animal.getClass().getSimpleName() +
                    " может " + ((Fly) animal).fly());
        }
    }

    private static void getAnimalToAdd(Scanner sc, Zoo zoo) {
        System.out.println("Меню добавления животного");
        System.out.println("1. Добавить тигра");
        System.out.println("2. Добавить волка");
        System.out.println("3. Добавить кота");
        System.out.println("4. Добавить собаку");
        System.out.println("5. Добавить аиста");
        System.out.println("6. Добавить курицу");
        System.out.println("7. Отмена");
        System.out.print("Выбери действие >: ");
        Map<String, Object> properties = new HashMap<>();
        switch (sc.nextInt()) {
            case 1: {
                properties.putAll(getAnimalProperties(sc));
                properties.putAll(getDomesticProperties(sc));
                properties.putAll(getCatProperties(sc));
                zoo.add(getNewCat(properties));
                System.out.println("Кот добавлен в зоопарк!");
                return;
            }
            case 2: {
                properties.putAll(getAnimalProperties(sc));
                properties.putAll(getDomesticProperties(sc));
                properties.putAll(getDogProperties(sc));
                zoo.add(getNewDog(properties));
                System.out.println("Собака добавлена в зоопарк!");
                return;
            }
            case 3: {
                properties.putAll(getAnimalProperties(sc));
                properties.putAll(getWildProperties(sc));
                properties.putAll(getWolfProperties(sc));
                zoo.add(getNewWolf(properties));
                System.out.println("Волк добавлен в зоопарк!");
                return;
            }
            case 4: {
                properties.putAll(getAnimalProperties(sc));
                properties.putAll(getWildProperties(sc));
                zoo.add(getNewTiger(properties));
                System.out.println("Тигр добавлен в зоопарк!");
                return;
            }
            case 5: {
                properties.putAll(getAnimalProperties(sc));
                properties.putAll(getBirdProperties(sc));
                zoo.add(getNewChicken(properties));
                System.out.println("Курица добавлена в зоопарк!");
                return;
            }
            case 6: {
                properties.putAll(getAnimalProperties(sc));
                properties.putAll(getBirdProperties(sc));
                properties.putAll(getStorkProperties(sc));
                zoo.add(getNewStork(properties));
                System.out.println("Аист добавлена в зоопарк!");
                return;
            }
            case 7: {
                return;
            }
        }
    }

    private static void getAnimalToShow(Scanner sc, Zoo zoo) {
        System.out.println("Меню просмотра информации о животном");
        zoo.showAll();
        System.out.println("Введи номер животного просмотра информации >: ");
        zoo.show(sc.nextInt() - 1);
        showActive(zoo.getAnimal(sc.nextInt() - 1));
    }

    private static Dog getNewDog(Map<String, Object> properties) {
        return new Dog((float) properties.get("growth"),
                (float) properties.get("weight"),
                (String) properties.get("eyeColor"),
                (String) properties.get("name"),
                (String) properties.get("breed"),
                (String) properties.get("vaccinated"),
                (String) properties.get("coatColor"),
                (LocalDate) properties.get("dateOfBirth"),
                (boolean) properties.get("trained"));
    }

    private static Animal getNewWolf(Map<String, Object> properties) {
        return new Wolf((int) properties.get("growth"),
                (int) properties.get("weight"),
                (String) properties.get("eyeColor"),
                (String) properties.get("habitat"),
                (LocalDate) properties.get("dateOfLocation"),
                (boolean) properties.get("packLeader"));
    }

    private static Animal getNewTiger(Map<String, Object> properties) {
        return new Tiger((int) properties.get("growth"),
        (int) properties.get("weight"),
        (String) properties.get("eyeColor"),
        (String) properties.get("habitat"),
        (LocalDate) properties.get("dateOfLocation"));
    }

    private static Animal getNewChicken(Map<String, Object> properties) {
        return new Chicken((int) properties.get("growth"),
        (int) properties.get("weight"),
        (String) properties.get("eyeColor"),
        (int) properties.get("flightAltitude"));
    }

    private static Animal getNewStork(Map<String, Object> properties) {
        return new Stork((int) properties.get("growth"),
                (int) properties.get("weight"),
                (String) properties.get("eyeColor"),
                (int) properties.get("flightAltitude"));
    }

    private static Map<String, Object> getStorkProperties(Scanner sc) {
        return null;
    }

    private static Map<String, Object> getBirdProperties(Scanner sc) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.print("Введи высоту полёта >: ");
        map.put("flightAltitude", sc.nextInt());
        return map;
    }

    private static Map<String, Object> getWolfProperties(Scanner sc) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.print("Вожак стаи (False/True) >: ");
        map.put("leader", sc.next().equalsIgnoreCase("да"));
        return map;
    }

    private static Map<String, Object> getWildProperties(Scanner sc) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.print("Введи место обитания животного >: ");
        map.put("habitat", sc.next());
        System.out.print("Введи дату нахождения (день.месяц.год) >: ");
        map.put("dateOfLocation", parseDate(sc.next()));
        return map;
    }

    private static Map<String, Object> getDogProperties(Scanner sc) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.print("Дрессирован(-на) (да/нет) >: ");
        map.put("presenceOfWool", sc.next().equalsIgnoreCase("да"));
        return map;
    }

    private static Cat getNewCat(Map<String, Object> properties) {
        return new Cat((float) properties.get("growth"),
                (float) properties.get("weight"),
                (String) properties.get("eyeColor"),
                (String) properties.get("name"),
                (String) properties.get("breed"),
                (String) properties.get("vaccinated"),
                (String) properties.get("coatColor"),
                (LocalDate) properties.get("dateOfBirth"),
                (boolean) properties.get("presenceOfWool"));
    }

    private static Map<String, Object> getCatProperties(Scanner sc) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.print("Наличие шерсти у животного (да/нет) >: ");
        map.put("presenceOfWool", sc.next().equalsIgnoreCase("да"));
        return map;
    }

    private static Map<String, Object> getDomesticProperties(Scanner sc) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.print("Введи кличку животного >: ");
        map.put("name", sc.next());
        System.out.print("Введи породу >: ");
        map.put("breed", sc.next());
        System.out.print("Введи вакцинированно ли животное (да/нет) >: ");
        map.put("vaccinated", sc.next().equalsIgnoreCase("да"));
        System.out.print("Введи цвет шерсти животного >: ");
        map.put("coatColor", sc.next());
        System.out.print("Введи дату рождения животного (день.месяц.год) >: ");
        map.put("dateOfBirth", parseDate(sc.next()));
        return map;
    }

    private static Object parseDate(String date) {
        String[] dateArr = date.split("\\.");
        int day = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int year = Integer.parseInt(dateArr[2]);
        return LocalDate.of(year, month, day);
    }

    private static Map<String, Object> getAnimalProperties(Scanner sc) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println("Введи высоту животного >: ");
        map.put("growth", sc.nextInt());
        System.out.println("Введи вес животного >: ");
        map.put("weight", sc.nextInt());
        System.out.print("Введи цвет глаз животного >: ");
        map.put("eyeColor", sc.nextInt());
        return map;
    }
}