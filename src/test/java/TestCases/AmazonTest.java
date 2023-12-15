package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class AmazonTest {

    public WebDriver setDriver (){
        return  Driver.getDriver();
    }

    private WebDriver driver = setDriver();

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\17044\\Desktop\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver.get("http://www.amazon.com/");
    }

    @Test
    public void addProductToCart() {
        String productName = "PAPERAGE 2024 Weekly & Monthly Hardcover Planner";
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.searchProduct(productName);
        ProductSelectionPage productSelectionPage = new ProductSelectionPage(driver);
        List<WebElement> searchResultList = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div"));
        filterResultSearch(searchResultList);
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        AddedToCartPage addedToCartPage = new AddedToCartPage(driver);
        String actualHeaderText = addedToCartPage.getHeaderText();
        System.out.println(actualHeaderText);
        String expectedHeader = "Added to Cart";
        Assert.assertEquals(actualHeaderText,expectedHeader);
        driver.close();
    }

    @Test
    public void searchProductByASIN(){
        String productASIN = "B0B72CG1TM";
        String productName = "PAPERAGE 2024 Weekly & Monthly Hardcover Planner";
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.searchProduct(productASIN);
        String searchedProductName = getTextOfProductName(productASIN);
        System.out.println(searchedProductName);
        Assert.assertTrue(searchedProductName.contains(productName), "ASIN number and product name do not match");
        selectProductWithSpecificAsinNumber(productASIN);
        ProductPage productPage = new ProductPage(driver);
        String tableText = productPage.getAdditionalInfoTableText();
        Assert.assertTrue(tableText.contains(productASIN),"The ASIN number is not listed in the table.");
        driver.close();
    }

    /**
     * Helper method to select a random product from the list; this method excludes the first 2 and the last 5 items
     * The removed items are not the products
     * @param searchResultList
     * @return
     */
    private List<WebElement> filterResultSearch(List<WebElement>searchResultList){
        searchResultList.remove(searchResultList.get(0));
        searchResultList.remove(searchResultList.get(0));
        searchResultList.remove(searchResultList.get(searchResultList.size()-1));
        searchResultList.remove(searchResultList.get(searchResultList.size()-1));
        searchResultList.remove(searchResultList.get(searchResultList.size()-1));
        searchResultList.remove(searchResultList.get(searchResultList.size()-1));
        searchResultList.remove(searchResultList.get(searchResultList.size()-1));
        searchResultList.get(searchResultList.size()-1).click();
        return searchResultList;
    }

    /**
     * This helper method gets the text of the title/description of the product with a specific ASIN number
     * @param asinNumber
     * @return
     */
    private String getTextOfProductName(String asinNumber){
        String productByASIN = "//div[@data-asin='";
        WebElement element = driver.findElement(By.xpath(productByASIN+asinNumber+"']"));
        return element.getText();
    }

    /**
     * This method clicks/selects the product with a specific ASIN number
     * @param asinNumber
     */
    private void selectProductWithSpecificAsinNumber(String asinNumber){
        String productByASIN = "//div[@data-asin='";
        WebElement element = driver.findElement(By.xpath(productByASIN+asinNumber+"']"));
        element.click();
    }

}
