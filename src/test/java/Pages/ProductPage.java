package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='add-to-cart-button']") WebElement addToCartButton;
    @FindBy(xpath = "//h1[contains(text(),'Additional Information')]/following-sibling::div") WebElement additionalInformationTable;

    /**
     * This method is used to click 'Add to Cart' button after the product has been selected
     */
    public void addToCart(){
        addToCartButton.click();
    }

    /**
     * This method gets the text from the table 'Additional Information' to verify that the ASIN number is present
     */
    public String getAdditionalInfoTableText(){
       return additionalInformationTable.getText();
    }
}
