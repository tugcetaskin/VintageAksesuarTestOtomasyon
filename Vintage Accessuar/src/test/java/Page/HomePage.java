package Page;

import Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By slideLocator = By.cssSelector("div.smartSlider_1");
    By searchIconLocator = By.cssSelector(".search");
    By searchBoxLocator = By.xpath("//input[@class='searchInputClass QuickSearchBar']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct() {
        Assertions.assertTrue(isDisplace(slideLocator),"Not on the home page!");
        wait(3);
        click(searchIconLocator);
        type(searchBoxLocator,"Küpe ");
        find(searchBoxLocator).sendKeys(Keys.ENTER);
    }
}
