import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = type;
        this.expectedName = name;
        this.expectedPrice = price;
    }

    @Parameterized.Parameters(name = "{index}: Тестовые данные: Тип={0}, Название={1}, Цена={2}")
    public static Object[][] getIngredient() {
        return new Object[][] {
                {IngredientType.FILLING, "Сыр с плесенью", 1.1F},
                {IngredientType.FILLING, "", 1.1F},
                {IngredientType.FILLING, null, 1.1F},
                {IngredientType.FILLING, "Очень длинная строка для сыра с плесенью", 1.1F},
                {IngredientType.FILLING, "!@#$%^&&*({[\"", 1.1F},
                {IngredientType.FILLING, "С", 1.1F},
                {IngredientType.SAUCE, "Cheese with mold", 1.1F},
                {IngredientType.SAUCE, "Сыр с плесенью", -1.1F},
                {IngredientType.SAUCE, "Сыр с плесенью", 0F},
                {IngredientType.SAUCE, "Сыр с плесенью", Float.MAX_VALUE},
                {IngredientType.SAUCE, "Сыр с плесенью", Float.MIN_VALUE},
        };
    };

    @Test
    public void checkGetIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        Assert.assertEquals("Ошибка в цене ингредиента", expectedPrice, actual, 0);
    }

    @Test
    public void checkGetIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        Assert.assertEquals("Ошибка в названии ингредиента", expectedName, actual);
    }

    @Test
    public void checkGetTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("job", expectedType, actual);
    }
}
