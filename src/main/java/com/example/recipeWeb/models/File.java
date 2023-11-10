package com.example.recipeWeb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "path", nullable = false)
    private String filePath;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPath() {
        return this.filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
