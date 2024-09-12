package Tests;

import Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        String firefoxProfilePath = "/Users/juanpablohernandezmonter/Library/Application Support/Firefox/Profiles/kt4q1vdt.sa3";
        FirefoxProfile automationProfile2 = new FirefoxProfile(new File(firefoxProfilePath));
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(automationProfile2);
        options.addPreference("general.useragent.override", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:129.0) Gecko/20100101 Firefox/129.0");

        driver = new FirefoxDriver(options);
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void searchTrains() {

        HomePage home;
        home = new HomePage(driver);

        home.setRoutes("Firenze", "Brescia");
        home.setDates();
        home.setPassengers();
        home.searchTrains();
    }

    @Test(priority = 2)
    public void selectDepartureTrain () {

        DepartureOptionsPage departureOptions;
        departureOptions = new DepartureOptionsPage(driver);

        departureOptions.openTripDetails();
        departureOptions.selectTripPrice();
        departureOptions.goToReturnOptionsPage();



        /*departureOptions = new DepartureOptionsPage(driver);
        departureOptions.selectDepartureTrip();*/
    }

    @Test(priority = 3)
    public void selectReturnTrain () {
        ReturnOptionsPage returnOptions;
        returnOptions = new ReturnOptionsPage(driver);
        returnOptions.openTripTwoDetails();
        returnOptions.selectTripTwoPrice();
        returnOptions.goToPassengersPage();

      //  returnOptions.selectReturnTrip();
    }

    @Test(priority = 4)
    public void fillPassengerOneData () {
        PassengerDataPage passengerData;
        passengerData = new PassengerDataPage(driver);

        passengerData.fillPassengerOne("Juan", "Pablo",
                                       "jp@mail.com","jp@mail.com",
                                       "123456789");
    }

    @Test(priority = 5)
    public void fillPassengerTwoData () {
        PassengerDataPage passengerData;
        passengerData = new PassengerDataPage(driver);

        passengerData.fillPassengerTwo("Juan Pablo", "HM" , "jp@gmail.com");
    }

    @Test(priority = 6)
    public void payTickets () {
        PaymentPage payment;
        payment = new PaymentPage(driver);

        payment.fillCardData("Juan", "1234123412341234", "01",
                    "2025", "123");

        payment.submitPayment();
    }

/*
    @AfterSuite
    public void tearDown () {
        driver.close();
    }

*/
    }
