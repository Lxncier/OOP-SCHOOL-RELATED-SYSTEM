package model.model1;

import java.util.UUID;

abstract class Person {
    private UUID id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public abstract void displayInfo();
}