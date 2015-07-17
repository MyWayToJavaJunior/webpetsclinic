package ru.lessons.lesson_6;

/**
 * animal
 */
public class Animal implements Pet {
    private final String name;
    private final String owner;
    private final int age;

    public Animal(final String name, String owner, int age) {
        this.name = name;
        this.owner = owner;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getOwner() {
        return this.owner;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}