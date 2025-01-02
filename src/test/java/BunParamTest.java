import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParamTest {

    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
        this.expectedName = name;
        this.expectedPrice = price;
    }

    @Parameterized.Parameters(name = "{index}: Тестовые данные: Название={0}, Цена={1}")
    public static Object[][] getBun() {
        return new Object[][] {
                {"Булка с кунжутом", 1.1F},
                {"", 1.1F},
                {null, 1.1F},
                {"Очень длинная строка для булки с кунжутом", 1.1F},
                {"!@#$%^&&*({[\"", 1.1F},
                {"Б", 1.1F},
                {"Sesame bun", 1.1F},
                {"Булка с кунжутом", -1.1F},
                {"Булка с кунжутом", 0F},
                {"Булка с кунжутом", Float.MAX_VALUE},
                {"Булка с кунжутом", Float.MIN_VALUE},
        };
    }

    @Test
    public void checkGetBunNameTest() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        Assert.assertEquals("Ошибка в названии булки", expectedName, actual);
    }

    @Test
    public void checkGetBunPriceTest() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        Assert.assertEquals("Ошибка в цене булки", expectedPrice, actual, 0);
    }
}
