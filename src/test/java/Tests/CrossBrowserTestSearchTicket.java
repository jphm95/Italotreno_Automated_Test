package Tests;

import Pages.DepartureOptionsPage;
import Pages.HomePage;
import Pages.ReturnOptionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestSearchTicket {

    WebDriver driver;
    String url = "https://www.italotreno.com/it";

    @BeforeTest
    @Parameters("Browser")
    public void openBrowser(String browser){
        if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Browser not supported");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    @Test
    public void searchTrains() throws InterruptedException{

        HomePage home;
        home = new HomePage(driver);

        home.setRoutes("Firenze", "Brescia");
        home.setDates();
        home.setPassengers();
        home.searchTrains();

    }

    @Test
    public void selectDepartureTrain () {

        DepartureOptionsPage departureOptions;
        departureOptions = new DepartureOptionsPage(driver);

        departureOptions.openTripDetails();
        departureOptions.selectTripPrice();
        departureOptions.goToReturnOptionsPage();

    }

    @Test
    public void selectReturnTrain () {
        ReturnOptionsPage returnOptions;
        returnOptions = new ReturnOptionsPage(driver);
        returnOptions.openTripTwoDetails();
        returnOptions.selectTripTwoPrice();
        returnOptions.goToPassengersPage();

    }

    public void tearDown () {
        driver.close();
    }



}
