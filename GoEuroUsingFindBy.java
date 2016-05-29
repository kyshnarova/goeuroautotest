package GoEuro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ky on 07.05.2016.
 */
public class GoEuroUsingFindBy {
    private WebDriver driver;

    public GoEuroUsingFindBy(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoEuroUsingFindBy open(String url){
        driver.get(url);
        return this;
    }

    @FindBy (xpath = ".//input[@id='from_filter']")
    private WebElement cityFrom;

    @FindBy (xpath = ".//input[@id='to_filter']")
    private WebElement cityTo;

    @FindBy (xpath = ".//*[@value='Search']")
    private WebElement searchButton;

    public GoEuroUsingFindBy enterCityFrom(String cityFromValue){
        cityFrom.clear();
        cityFrom.sendKeys(cityFromValue);

        return this;
    }

    public GoEuroUsingFindBy enterCityTo(String cityToValue){
        cityTo.clear();
        cityTo.sendKeys(cityToValue);

        return this;
    }

    public GoEuroUsingFindBy clickSearchButton(){
        searchButton.click();

        return this;
    }

}
