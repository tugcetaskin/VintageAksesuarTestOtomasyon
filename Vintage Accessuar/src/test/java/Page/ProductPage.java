package Page;

import Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {

    By leftListLocator = By.id("LeftBlocksList");
    By productListLocator = By.cssSelector(".showcaseItem");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public int selectRandomProduct() {
        Random random = new Random();
        int i = random.nextInt(30);
        return i;
    }

    public List<WebElement> findAllProduct() {
        return findAll(productListLocator);
    }

    public void selectProduct() {
        Assertions.assertTrue(isDisplace(leftListLocator),"Not on the product page!");
        wait(3);
        findAllProduct().get(selectRandomProduct()).click();
    }
}
