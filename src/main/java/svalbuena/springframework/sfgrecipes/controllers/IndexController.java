package svalbuena.springframework.sfgrecipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import svalbuena.springframework.sfgrecipes.domain.Category;
import svalbuena.springframework.sfgrecipes.domain.UnitOfMeasure;
import svalbuena.springframework.sfgrecipes.repositories.CategoryRepository;
import svalbuena.springframework.sfgrecipes.repositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(final CategoryRepository categoryRepository, final UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping({"", "/"})
    public String getIndexPage() {
        final Optional<Category> category = categoryRepository.findByDescription("American");
        final Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Grams");
        System.out.println("Category = " + category.get().getId());
        System.out.println("UOM = " + unitOfMeasure.get().getId());

        return "index";
    }
}
