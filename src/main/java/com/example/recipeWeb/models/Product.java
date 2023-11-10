package com.example.recipeWeb.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_id", nullable = false)
    private long image_id;

    @ManyToMany
    Set<Recipe> recipes;
    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getImage() {
        return image_id;
    }
    public void setImage(long img_id) {
        this.image_id = img_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
