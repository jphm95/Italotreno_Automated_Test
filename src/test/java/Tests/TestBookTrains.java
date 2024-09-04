package Tests;

import Pages.DepartureOptionsPage;
import Pages.HomePage;
import Pages.PassengerDataPage;
import Pages.ReturnOptionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;

public class TestBookTrains {

    WebDriver driver;

    String url = "https://www.italotreno.com/it";

    @BeforeSuite
    public void openBrowser() {
        String firefoxProfilePath = "/Users/juanpablohernandezmonter/Library/Application Support/Firefox/Profiles/8bg3ihot.sa1";
        FirefoxProfile automationProfile1 = new FirefoxProfile(new File(firefoxProfilePath));
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(automationProfile1);
        options.addPreference("general.useragent.override", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:129.0) Gecko/20100101 Firefox/129.0");

        driver = new FirefoxDriver(options);
        //driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test
    public void searchTrains() {

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


        /*
        departureOptions = new DepartureOptionsPage(driver);
        departureOptions.selectDepartureTrip();*/
    }

    @Test
    public void selectReturnTrain () {
        ReturnOptionsPage returnOptions;
        returnOptions = new ReturnOptionsPage(driver);
        returnOptions.openTripTwoDetails();
        returnOptions.selectTripTwoPrice();
        returnOptions.goToPassengersPage();

      //  returnOptions.selectReturnTrip();
    }

    @Test
    public void fillPassengersData (){
        PassengerDataPage passengerData;
        passengerData = new PassengerDataPage(driver);
        passengerData.writeName("Juan");
        passengerData.writeLastName("Pablo");
        passengerData.writeEmail("<EMAIL>");
        passengerData.goToPaymentPage();

      //  passengerData.fillPassengerTwoData("Juan Pablo", "HM" , "jp@gmail.com");
    }


    @AfterSuite
    public void tearDown () {
        driver.close();
    }



}
