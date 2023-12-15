package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductSelectionPage extends BasePage{

    public ProductSelectionPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div") List<WebElement> searchResultList;

}
