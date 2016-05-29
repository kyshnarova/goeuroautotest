package GoEuro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ky on 06.05.2016.
 */
public class GoEuro extends BasePage {

    public GoEuro(WebDriver driver) {
        super(driver);
    }

    private By cityFromLocator = By.xpath(".//input[@id='from_filter']");
    private By cityToLocator = By.xpath(".//input[@id='to_filter']");
    private By searchLocator = By.xpath(".//*[@value='Search']");
    private By dataCommonLocator = By.xpath(".//input[@id='departure_date']");
    private String dataValueLocator = ".//a[contains(@class, 'ui-state-default')][contains(text(), '%s')]";
    private String getDataValueLocator2 = ".//td[contains(@data-month, '%d')]/a[contains(@class, 'ui-state-default')][contains(text(), '%s')]";
    private By nextButtonLocator = By.xpath(".//a[@data-handler='next']");
    private By prevButtonLocator = By.xpath(".//a[@data-handler='prev']");


    public GoEuro open (String url){
        driver.get(url);

        return this;
    }

    public GoEuro enterCityFrom(String cityFromValue){
        /*WebElement cityFrom = driver.findElement(cityFromLocator);
        cityFrom.clear();
        cityFrom.sendKeys(cityFromValue);*/
        sendKeys(cityFromLocator,cityFromValue);

        return this;
    }

    public GoEuro enterCityTo(String cityToValue){
        /*WebElement cityTo = driver.findElement(cityToLocator);
        cityTo.clear();
        cityTo.sendKeys(cityToValue);*/
        sendKeys(cityToLocator, cityToValue);

        return this;
    }

    public GoEuro clickSearchButton(){
        /*WebElement searchButton = driver.findElement(searchLocator);
        searchButton.click();*/
        clickButton(searchLocator);

        return this;
    }
    public GoEuro setData(String dataValue){
        clickButton(dataCommonLocator);
        selectData(dataValueLocator, dataValue);

       // String currentMonth = driver.findElement(By.xpath(".//td[@data-handler= 'selectDay']")).getAttribute("data-month");
        //new WebElement().getAttribute("data");

        return this;
    }

    public GoEuro setData2 (Integer monthValue, String dataValue){
        clickButton(dataCommonLocator);
        String currentMonthString = driver.findElement(By.xpath(".//td[@data-handler= 'selectDay']")).getAttribute("data-month");
        Integer currenyMonth = Integer.parseInt(currentMonthString) + 1;

        Integer difference = currenyMonth-monthValue;
        if (difference > 0){
            for (int i = 0; i < difference; i++){
                clickButton(nextButtonLocator);
            }
        }
        if (difference < 0){
            for (int i = 0; i < -difference; i++){
                clickButton(nextButtonLocator);
            }
        }

        selectData2(getDataValueLocator2, monthValue, dataValue );

        return this;
    }

    @Override
    protected void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(cityFromLocator));
    }
}
