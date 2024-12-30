import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final Burger burger = new Burger();;

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient anotherIngredient;

    @Test
    public void checkAddIngredientTest() {
        burger.ingredients.add(ingredient);
        burger.addIngredient(anotherIngredient);
        int expected = 2;
        int actual = burger.ingredients.size();
        Assert.assertEquals("Ошибка добавления ингредиента", expected, actual);
    }

    @Test
    public void checkRemoveIngredientTest() {
        burger.ingredients.addAll(List.of(ingredient, anotherIngredient));
        burger.removeIngredient(0);
        int expected = 1;
        int actual = burger.ingredients.size();
        Assert.assertEquals("Ошибка удаления ингредиента", expected, actual);
    }

    @Test
    public void checkMoveIngredientTest() {
        burger.ingredients.addAll(List.of(ingredient, anotherIngredient));
        burger.moveIngredient(0, 1);
        List<Ingredient> expected = new ArrayList<>(Arrays.asList(anotherIngredient, ingredient));
        Assert.assertEquals("Ошибка перемещения ингредиента", expected, burger.ingredients);
    }

    @Test
    public void checkGetPriceTest() {
        burger.ingredients.addAll(List.of(ingredient, anotherIngredient));
        burger.setBuns(bunMock);
        Mockito.when(bunMock.getPrice()).thenReturn(11F);
        Mockito.when(ingredient.getPrice()).thenReturn(12F);
        Mockito.when(anotherIngredient.getPrice()).thenReturn(13F);
        float expected = 47F;
        float actual = burger.getPrice();
        Assert.assertEquals("Ошибка в получении стоимости бургера", expected, actual, 0);
    }

    @Test
    public void checkGetReceiptTest() {
        burger.ingredients.addAll(List.of(ingredient, anotherIngredient));
        burger.setBuns(bunMock);
        Mockito.when(bunMock.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bunMock.getPrice()).thenReturn(1255F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Сыр с астероидной плесенью");
        Mockito.when(ingredient.getPrice()).thenReturn(4142F);
        Mockito.when(anotherIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(anotherIngredient.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(anotherIngredient.getPrice()).thenReturn(90F);
        String expected = String.format("(==== %s ====)%n", "Краторная булка N-200i") +
                String.format("= %s %s =%n", "filling", "Сыр с астероидной плесенью") +
                String.format("= %s %s =%n", "sauce", "Соус Spicy-X") +
                String.format("(==== %s ====)%n", "Краторная булка N-200i") +
                String.format("%nPrice: %f%n", 6742F);
        StringBuilder actual = new StringBuilder(burger.getReceipt());
        Assert.assertEquals("Ошибка в рецепте бургера", expected, actual.toString());
    }
}
