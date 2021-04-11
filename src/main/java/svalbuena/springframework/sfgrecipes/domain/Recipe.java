package svalbuena.springframework.sfgrecipes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;

    private Integer preparationTime;

    private Integer cookTime;

    private Integer servings;

    private String source;

    private String url;

    @Lob
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Recipe(final String description,
                  final Integer preparationTime,
                  final Integer cookTime,
                  final Integer servings,
                  final String source,
                  final String url,
                  final String directions,
                  final Difficulty difficulty,
                  final Byte[] image,
                  final Notes notes) {
        this.description = description;
        this.preparationTime = preparationTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.source = source;
        this.url = url;
        this.directions = directions;
        this.difficulty = difficulty;
        this.image = image;
        setNotes(notes);
    }

    public Recipe addIngredient(final Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    public Recipe addCategory(final Category category) {
        category.addRecipe(this);
        categories.add(category);
        return this;
    }

    public void setNotes(final Notes notes) {
        notes.setRecipe(this);
        this.notes = notes;
    }
}
