import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void checkAvailabilitySauceTest() {
        String expected = "SAUCE";
        String actual = String.valueOf(IngredientType.valueOf("SAUCE"));
        Assert.assertEquals("Нет начинки SAUCE", expected, actual);
    }

    @Test
    public void checkAvailabilityFillingTest() {
        String expected = "FILLING";
        String actual = String.valueOf(IngredientType.valueOf("FILLING"));
        Assert.assertEquals("Нет начинки FILLING", expected, actual);
    }

    @Test
    public void checkNonexistentIngredientTypeTest() {
        String expected = "Non-existent ingredient";
        String actual = String.valueOf(IngredientType.valueOf("FILLING"));
        Assert.assertNotEquals("Наличие несуществующей начинки", expected, actual);
    }

    @Test
    public void checkSizeIngredientTypeTest() {
        int expected = 2;
        int actual = IngredientType.values().length;
        Assert.assertEquals("Ошибка в размере IngredientType", expected, actual);
    }
}
