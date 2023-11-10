package com.example.recipeWeb.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recipe_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", length = 6, nullable = false)
    private long id;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private String name;
    private String password;
    @ManyToMany
    Set<Recipe> favourites;
    public User() {
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getPassword() {return password;}
    public void setPassword(String newPassword) {this.password = newPassword;}
    public String getName() {return name;}
    public void setName(String newName) {this.name = name;}
    public Set<Role> getRoles() {return roles;}
    public void setRole(Role newRole) {
        if (roles.contains(newRole))
            return;
        roles.add(newRole);
    }

    public void setRoles(Set<Role> singleton) {
        setRole(singleton.stream().findFirst().get());
    }
}

