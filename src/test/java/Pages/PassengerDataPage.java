package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengerDataPage {

    WebDriver driver;

    //Locators:

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_BookingPasseggeriPassengerInputRestylingBookingPasseggeriView_TextBoxFirstName_1")
    WebElement passengerTwoNameField;

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_BookingPasseggeriPassengerInputRestylingBookingPasseggeriView_TextBoxLastName_1")
    WebElement passengerTwoLastNameField;

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_BookingPasseggeriPassengerInputRestylingBookingPasseggeriView_TextBoxPassengerAddressLine1_1_0")
    WebElement passengerTwoEmailField;


    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_ButtonSubmit")
    WebElement goPaymentButton;

    //Constructor:
    public PassengerDataPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    //Methods:

    public void writeName (String name) {
        passengerTwoNameField.sendKeys(name);
    }

    public void writeLastName (String lastName) {
        passengerTwoLastNameField.sendKeys(lastName);
    }

    public void writeEmail (String email) {
        passengerTwoEmailField.sendKeys(email);
    }


    public void goToPaymentPage () {
        goPaymentButton.click();
    }

    //Steps:

    public void fillPassengerTwoData (String name, String lastName, String  email) {
        writeName(name);
        writeLastName(lastName);
        writeEmail(email);
        goToPaymentPage();
    }

}
