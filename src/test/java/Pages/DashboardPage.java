package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends BasePage{


    @FindBy(xpath = "//input[@placeholder='Search Amazon']") WebElement amazonSearchInputField;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']") WebElement searchButton;
    @FindBy(xpath = "//div[@id='nav-cart-count-container']") WebElement cartIcon;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method is used to search for a specific product from dashboard page
     * @param product
     */
    public void searchProduct(String product){
        amazonSearchInputField.sendKeys(product);
        searchButton.click();
    }

    /**
     * This method would be used to click on Cart icon on the upper right
     */
    public void clickCartIcon(){
        cartIcon.click();
    }

}
