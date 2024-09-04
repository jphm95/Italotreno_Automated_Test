package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DepartureOptionsPage {

    WebDriver driver;
    WebDriverWait wait;

    //Locators:
    @FindBy(css="div.oGMzg1KnBMdFpRbUerJ8:nth-child(1) > header:nth-child(1) > div:nth-child(1) > div:nth-child(5)")
    WebElement tripDetails;

    @FindBy(css=".bNSZMvCfDFZUHStNlsEV > div:nth-child(1) > main:nth-child(1) > section:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)")
    WebElement tripPrice;

    @FindBy(css=".bNSZMvCfDFZUHStNlsEV > div:nth-child(1) > main:nth-child(1) > footer:nth-child(3) > div:nth-child(1) > button:nth-child(2)")
    WebElement goToReturnTripButton;

    //Constructor:
    public DepartureOptionsPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Methods:
     public void openTripDetails () {
        tripDetails.click();
     }

     public void selectTripPrice () {
        tripPrice.click();
     }

     public void goToReturnOptionsPage () {
        goToReturnTripButton.click();
     }

     //Steps:

     public void selectDepartureTrip () {
         openTripDetails();
         selectTripPrice();
         goToReturnOptionsPage();
     }







}

