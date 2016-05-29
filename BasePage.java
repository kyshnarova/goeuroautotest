package GoEuro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Ky on 07.05.2016.
 */
public abstract class BasePage {
    protected WebDriver driver; //наследуется и видна только в этом классе

    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    protected void sendKeys(By locator, String value){
        WebElement input = driver.findElement(locator);
        input.clear();
        input.sendKeys(value);
    }

    protected void clickButton(By buttonLocator){
        WebElement button = driver.findElement(buttonLocator);
        button.click();
    }

    protected void selectData(String locator, String value){
        WebElement selectedData = driver.findElement(By.xpath(String.format(locator, value)));
        selectedData.click();
    }

    protected void selectData2(String locator, Integer month, String day){
        WebElement selectedData = driver.findElement(By.xpath(String.format(locator, month, day)));
        selectedData.click();
    }

    protected abstract void waitForPageToLoad();
}
