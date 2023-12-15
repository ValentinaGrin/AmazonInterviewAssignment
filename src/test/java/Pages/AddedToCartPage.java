package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class AddedToCartPage extends BasePage{
    public AddedToCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(),'Added to Cart')]") WebElement addedToCartHeader;

    /**
     * This method is to get text of the header to verify expected vs actual result
     * @return
     */
    public String getHeaderText(){
        return addedToCartHeader.getText();
    }

}
