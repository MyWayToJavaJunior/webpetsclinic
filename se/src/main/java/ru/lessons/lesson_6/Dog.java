package ru.lessons.lesson_6;

/**
 * dog
 */
public class Dog implements Pet {
    private final Animal animal;

    public Dog(Animal animal) {
        this.animal = animal;
    }

    public String getName() {
        return this.animal.getName();
    }

    @Override
    public String getOwner() {
        return this.animal.getOwner();
    }

    public int getAge() {
        return this.animal.getAge();
    }
}