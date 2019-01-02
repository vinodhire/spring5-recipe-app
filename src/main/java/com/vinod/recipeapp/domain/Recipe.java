package com.vinod.recipeapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"ingredients","notes"})
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int preTime;
    private int cookTime;
    private int servings;
    private String source;
    private String url;

    public Recipe(String description, int preTime, int cookTime, int servings, String source, String url, String directions, Set<Ingradient> ingredients, Byte[] image, Difficulty difficulty, Notes notes, Set<Category> categories) {
        this.description = description;
        this.preTime = preTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.source = source;
        this.url = url;
        this.directions = directions;
        this.ingredients = ingredients;
        this.image = image;
        this.difficulty = difficulty;
        this.notes = notes;
        this.categories = categories;
    }

    @Lob
    private String directions;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
    private Set<Ingradient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;


    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "id"))
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingradient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}
