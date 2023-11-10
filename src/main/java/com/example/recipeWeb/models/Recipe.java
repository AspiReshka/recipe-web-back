package com.example.recipeWeb.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "image_id", nullable = false)
    private long image_id;
    @Column(name = "timeForCooking")
    private long timeForCookingMinutes; //TODO: maybe should use different type
    @Column(name = "calorie")
    private long calorie;
    @ManyToMany
    Set<Product> ingredients;
    @ManyToMany
    Set<User> likes;

    public Recipe() {
    }

    public Recipe(String name, long img) {
        this.name = name;
        this.image_id = img;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getTimeForCookingMinutes() {
        return timeForCookingMinutes;
    }
    public void setTimeForCookingMinutes(long timeForCookingMinutes) {
        this.timeForCookingMinutes = timeForCookingMinutes;
    }
    public long getCalorie() {
        return calorie;
    }
    public void setCalorie(long calorie) {
        this.calorie = calorie;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getImage() {
        return image_id;
    }
    public void setImage(long img_id) {
        this.image_id = img_id;
    }
}
