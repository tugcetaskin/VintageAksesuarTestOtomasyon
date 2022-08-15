package Page;

import Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.engine.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By increasedTheProduct = By.cssSelector(".icon-arrow-up-b");
    By completeTheTransTransaction = By.cssSelector("div[class='_panel-body-box'] a");
    By deleteTheProduct = By.cssSelector("a[class='_cart-item-delete _button _button-mini _button-white']");
    By numberOfProducts = By.xpath("//div[@class='_product-quantity']/input");
    By informationLocator = By.cssSelector("i[class='icon-information-circled _font-size-80']");

    By productNameInCartPage = By.xpath("//td[@class='_cart-item-name']/div/a");
    By productPriceInCartPage = By.cssSelector("span[id='totalAmount']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplaceCartPage() {
        return isDisplace(completeTheTransTransaction);
    }

    public boolean isProductNumberIncreased() {
        String productNumber = find(numberOfProducts).getAttribute("value");
        return productNumber.contains("2");
    }

    public String getProductNameInCart() {
        String productNameInCart = find(productNameInCartPage).getText().trim();
        return productNameInCart;
    }

    public boolean isProductNameCorrect() {
        return getProductNameInCart().contains(ProductControl.productNameCheck);
    }

    public String getProductPriceInCart() {
        String productPriceInCart = find(productPriceInCartPage).getText().trim();
        return productPriceInCart;
    }

    public boolean isProductPriceCorrect() {
        return getProductPriceInCart().contains(ProductControl.productPriceCheck);
    }

    public void isTheProductCorrect() {
        Assertions.assertTrue(isProductNameCorrect(),"The correct product was not added to the cart");
        wait(3);
        Assertions.assertTrue(isProductPriceCorrect(),"The correct product was not added to the cart");
    }

    public void increasedTheProduct() {
        Assertions.assertTrue(isDisplaceCartPage(),"Not on the cart page!");
        click(increasedTheProduct);
        wait(3);
        Assertions.assertTrue(isProductNumberIncreased(),"The number of products could not be increased!");
    }

    public void deleteTheProducts() {
        click(deleteTheProduct);
        wait(3);
        Assertions.assertTrue(isDisplace(informationLocator),"The products can not be deleted!");
    }


}
