package guru.springframework.services;

import java.util.HashSet;
import java.util.Set;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;

    @Mock RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() throws Exception {

        final Recipe recipe = new Recipe();
        final HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipesData);

        final Set<Recipe> recipes = recipeService.getRecipes();

        Assert.assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }

}