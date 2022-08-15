package Page;

import Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By selectStandart = By.cssSelector(".variantLink");
    By selectAnother = By.xpath("//div[@class='variantItem']/span[2]");
    By addToCartItemLocator = By.xpath("//div[@class='productCartButton _clearfix']/div[2]");
    By cartItemLocator = By.cssSelector(".iCart a");
    By cartNumberLocator = By.cssSelector(".iCartNumber");
    By goToCartLocator = By.xpath("//a[text()='Siparişi Tamamla']");

    By productNameLocator = By.cssSelector("div.productTitle h1");
    By productPriceLocator = By.cssSelector("div.productPriceWithTax ");

    By stockWarningLocator = By.xpath("//a[@data-selector='stock-warning']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        Assertions.assertTrue(isDisplace(addToCartItemLocator), "Not on the product detail page!");
        click(selectStandart);
        wait(3);

        /*if (isDisplace(stockWarningLocator)) {
            click(selectAnother);
        }*/

        click(addToCartItemLocator);
    }

    public boolean isOnTheCart() {
        String count = find(cartNumberLocator).getText();
        return count.contains("1");
    }

    public void goToCart() {
        wait(3);
        click(cartItemLocator);
        Assertions.assertTrue(isOnTheCart(), "The product can not added!");
        click(goToCartLocator);
    }

    public void getProductValues() {
        String productName = find(productNameLocator).getText().trim();
        ProductControl.productNameCheck = productName;

        String productPrice = find(productPriceLocator).getText().trim();
        ProductControl.productPriceCheck = productPrice;
    }
}
