package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReturnOptionsPage {

    WebDriver driver;
    WebDriverWait wait;

    //Locators:
    @FindBy(css="div.main-body:nth-child(5) div.sGzGQkSyGP5nuvRoS5yS main.vc5W9ySG3a_9aIvwgN6K:nth-child(6) div.oGMzg1KnBMdFpRbUerJ8.gNpRaPmpjjXOx1xC8qXn:nth-child(1) header:nth-child(1) > div.xMhiaBtkJGJcWMnVEEJd")
    WebElement tripTwoDetails;

    @FindBy(css=".bNSZMvCfDFZUHStNlsEV > div:nth-child(1) > main:nth-child(1) > section:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)")
    WebElement tripTwoPrice;

    @FindBy(css=".bNSZMvCfDFZUHStNlsEV > div:nth-child(1) > main:nth-child(1) > footer:nth-child(3) > div:nth-child(1) > button:nth-child(2)")
    WebElement nextPageButton;

    //Constructor:
    public ReturnOptionsPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Methods:
    public void openTripTwoDetails () {
        tripTwoDetails.click();
    }

    public void selectTripTwoPrice () {
        tripTwoPrice.click();
    }

    public void goToPassengersPage () {
        nextPageButton.click();
    }

    //Steps:

    public void selectReturnTrip () {
        openTripTwoDetails();
        selectTripTwoPrice();
        goToPassengersPage();
    }



}
