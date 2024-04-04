package com.cuisinehub.recipes.services.recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisinehub.recipes.entities.recipes.Tag;
import com.cuisinehub.recipes.repositories.recipes.TagRepository;

@Service
public class TagService {
    
    @Autowired TagRepository tagRepository;
    @Autowired RecipeTagService recipeTagService;

    // Returns a List with all Tags
    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }


}
