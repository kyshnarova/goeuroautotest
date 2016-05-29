package GoEuro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ky on 06.05.2016.
 */
public class GoEuroTest {
    static WebDriver driver;
    private String url = "http://www.goeuro.com/";
    private String cityFrom = "Lviv";
    private String cityTo = "London";
    private String dataValue = "12";
    private Integer monthValue = 10;
    private String yearValue = "2016";


    @BeforeMethod
    public void tearUp(){
        driver = new FirefoxDriver(); //тип класса = тип объекта
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void firstTest(){
        GoEuro goEuro = new GoEuro(driver);
        goEuro.open(url)
                .enterCityFrom(cityFrom)
                .enterCityTo(cityTo)
                .clickSearchButton();
        //Assert.assertTrue(isElementPresent(myProfileButton),"MyProfile button is not present");
    }

    @Test
    public void secondTest(){
        GoEuroUsingFindBy goEuroUsingFindBy = new GoEuroUsingFindBy(driver);
        goEuroUsingFindBy.open(url)
                .enterCityFrom(cityFrom)
                .enterCityTo(cityTo)
                .clickSearchButton();
    }

    @Test
    public void thirdTest(){
        GoEuro goEuro = new GoEuro(driver);
        goEuro.open(url)
                .setData(dataValue);
    }

    @Test
    public void fourthTest(){
        GoEuro goEuro = new GoEuro(driver);
        goEuro.open(url)
                .setData2(monthValue, dataValue);
    }
}
