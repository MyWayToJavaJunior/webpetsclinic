package kz.petsclinic.clinic.emulatedUsers;

import java.util.Random;

/**
 * Генерация имен для
 * Персон и животных
 */
public class Generator {
    private final static String[] PERSON_NAMES =
            {"Bill", "Mike", "Bob", "Peter", "Alex",
                    "Vasya", "Petya", "Senya", "Oleg", "Igor",
            "Mila", "Katy", "Inna", "Masha", "Irina", "Emma",
            "Olga", "Natasha", "Nastya", "Nina"};
    private final static String[] PET_NAMES =
            {"Barsik", "Tuzik", "Sharik", "Bobik", "Muhtar", "Bim", "Murzik", "Kesha", "Yasha", "Popka"};
    private final static String[] PET_TYPES =
            {"Cat", "Bird", "Dog"};

    public static String getPersonName() {
        return generate(PERSON_NAMES);
    }

    public static String getPetName() {
        return generate(PET_NAMES);
    }

    public static String getPetType() {
        return generate(PET_TYPES);
    }

    private static String generate(String[] strings) {
        Random rand = new Random();
        return strings[rand.nextInt(strings.length)];
    }

}
