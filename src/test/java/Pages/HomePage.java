package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class HomePage {

     WebDriver driver;
     WebDriverWait wait;

    //Locators:

    //Login:
    @FindBy(id ="login__button__customerB2C" )
    WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()='Iscriviti gratis!']")
    WebElement registerLink;

    //Departure and Return Fields:
    @FindBy(xpath = "(//input[@placeholder='Inserisci città o stazione'])[1]")
    WebElement departureField;

    @FindBy(xpath = "(//input[@placeholder='Inserisci città o stazione'])[2]")
    WebElement returnField;

    //Travel Dates:
    @FindBy(css = "div.pSB9dR2pzFl_C9X4wrRA:nth-child(1) > div:nth-child(1) > svg:nth-child(1)")
    WebElement calendarDeparture ;

    @FindBy(css = ".HKxdl6YrbF5LMO49NHoa")
    WebElement calendarReturn;

    @FindBy(css =".ZY2Re97U8PJfdhD6tgfQ > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(7)" )
    WebElement dateDeparture; // September 15th

    @FindBy(css = ".ZY2Re97U8PJfdhD6tgfQ > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(7)")
    WebElement dateReturn ; // September 22nd

    //Passenger Management
    @FindBy(css=".zc26gIS0KbAEGxVRq3bF.RwiGXPsplqZAj_QxPRSm")
    WebElement addPassengersButton;

    @FindBy(css="div.go9ndDUex_l7im6ev40o.pP_GvbEtMkqJI4B_7xz0.CbAcZotdM0tMcYZXddxQ div.RARHw8KGmOHgA0vKM_LA div.YWXGZ1XQUNBsmcmHWMQi:nth-child(3) div.U4cwanfdkThQZjhAzofR:nth-child(3) main.rSm1B1izTcetBhfrHsXw.Zsn4XtujFa2gbizxOEMN div.mbDPmv7QDJ4AUH7Gls9n.jOnZHch5Ybsei_lNHkCF div.J6yPKhs2DkyWSL2bOaPJ.d4lS_661eb9CTvXUMM0i div.MQXGn8S5Fn0eyElD0Q7p div.KWmWBBR_l4yD6KWgHBGg div.vEOUSX0B0Nhu7eh_qI9v._5luZiCYhPtFByjY0mqwZ.i6RgKmgv_sK0LZRqwsHZ.ZY2Re97U8PJfdhD6tgfQ.qEfowZdgvSs51U4sTOxV div.VHuZB6qHKQgxAmCIXHLZ div.HqDTq0JlWG7JAZetH8dW div.SDJb7E5VePc2q_qYer02:nth-child(4) div.IdJhg3fLLG4lB9ffI1Uz > div.V2qstMXNkWMGmNayg56u:nth-child(3)")
    WebElement incrementGiovanneCounterButton;

    @FindBy(css=".ifo5tjfBkO_s4uzEMiFj")
    WebElement confirmPassengersLabel;

    //Search
    @FindBy(css="button[type='submit'] span")
    WebElement searchButton ;

    //Departure Spot Desired: (Firenze)
    @FindBy(css="div[class=\"vEOUSX0B0Nhu7eh_qI9v tdnZ04LAqHnYqLTWPd0W j3v2DCntTOwpnAAMUfZd DeFXESsbSTRBoi2MWoT0 ZY2Re97U8PJfdhD6tgfQ\"] span:nth-child(1)")
    WebElement originStationOption ;

    //Return Spot Desired (Brescia)
    @FindBy(css = "div.go9ndDUex_l7im6ev40o.pP_GvbEtMkqJI4B_7xz0.CbAcZotdM0tMcYZXddxQ div.RARHw8KGmOHgA0vKM_LA div.YWXGZ1XQUNBsmcmHWMQi:nth-child(3) div.U4cwanfdkThQZjhAzofR:nth-child(3) main.rSm1B1izTcetBhfrHsXw.Zsn4XtujFa2gbizxOEMN div.RfOZfYgiQMKAyj22jkC8.gZmlHI6EfOOQ7Gr6K1sc div.FJ5ql5zCbMw6cIpEP_m3.bpK1xcdjL1GwS6yK8ihv.bI1HQJLS3WALDp1qLFUt div.hq9qdFds5fDafc7MZl8C:nth-child(3) div.J6yPKhs2DkyWSL2bOaPJ.d4lS_661eb9CTvXUMM0i div.KWmWBBR_l4yD6KWgHBGg.AEzdoBFWJQLdLoAYU6Ph div.vEOUSX0B0Nhu7eh_qI9v.tdnZ04LAqHnYqLTWPd0W.j3v2DCntTOwpnAAMUfZd.kTVaDk7s6BBoj2M3mJpw.ZY2Re97U8PJfdhD6tgfQ div.lV4qFWyb3XToIjP5cb2D ul.ZFf2dAH9W7jwNzWGLVsM > li:nth-child(1)")
    WebElement returnStationOption;

    //Constructor:
    public HomePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }


    // Methods


    public void writeOrigin (String origin) {
        wait.until(ExpectedConditions.visibilityOf(departureField));
        departureField.sendKeys(origin);
    }

    public void writeDestination (String destination) {
        wait.until(ExpectedConditions.visibilityOf(returnField));
        returnField.sendKeys(destination);
    }

    public void confirmOriginStation () {
        originStationOption.click();
    }

    public void confirmReturnStation () {
        wait.until(ExpectedConditions.visibilityOf(returnStationOption));
        Actions actions = new Actions(driver);
        actions.moveToElement(returnStationOption).click().perform();
    }

    public void clickCalendar () {
        calendarDeparture.click();
    }

    public void clickCalendarReturn () {
        calendarReturn.click();
    }

    public void setDateDeparture () {
        dateDeparture.click();
    }

    public void setDateReturn () {
        dateReturn.click();
    }

    public void addPassengers () {
        addPassengersButton.click();
    }

    public void addTwoGiovannePassenger () {
        incrementGiovanneCounterButton.click();
        incrementGiovanneCounterButton.click();
    }

    public void confirmPassengers () {
        confirmPassengersLabel.click();
    }

    public void searchTrains () {
        searchButton.click();
    }

    public void clickLogin () {
        loginButton.click();
    }

    public void clickSingUpText () {
        registerLink.click();

    }

    // Steps:

    public void setRoutes (String origin, String destination) {
        writeOrigin(origin);
        confirmOriginStation();
        writeDestination(destination);
        confirmReturnStation();
    }

    public void setDates () {
        clickCalendar();
        setDateDeparture();
        clickCalendarReturn();
        setDateReturn();
    }

    public void setPassengers () {
        addPassengers();
        addTwoGiovannePassenger();
        confirmPassengers();
    }

    public void registerUser () {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        clickLogin();
        clickSingUpText();
    }









}
