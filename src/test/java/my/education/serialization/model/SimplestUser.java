package my.education.serialization.model;

import java.io.Serializable;

/**
 * Created by bender on 06.08.2018.
 */
public class SimplestUser implements Serializable{
    private String name;
    private int age;
    private int weight;

    public SimplestUser() {
    }

    public SimplestUser(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
