package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengerDataPage {

    WebDriver driver;

    //Locators:
    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_BookingPasseggeriPassengerInputRestylingBookingPasseggeriView_TextBoxFirstName_0")
    WebElement passengerOneNameField;

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_BookingPasseggeriPassengerInputRestylingBookingPasseggeriView_TextBoxFirstName_1")
    WebElement passengerTwoNameField;

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_BookingPasseggeriPassengerInputRestylingBookingPasseggeriView_TextBoxLastName_1")
    WebElement passengerTwoLastNameField;

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_BookingPasseggeriPassengerInputRestylingBookingPasseggeriView_TextBoxLastName_0")
    WebElement passengerOneLastNameField;

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_BookingPasseggeriPassengerInputRestylingBookingPasseggeriView_TextBoxPassengerAddressLine1_0_0")
    WebElement passengerOneEmailField;

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_BookingPasseggeriPassengerInputRestylingBookingPasseggeriView_TextBoxPassengerAddressLine1_1_0")
    WebElement passengerTwoEmailField;

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_confermaEmailField_1")
    WebElement passengerOneConfirmEmailField;

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_BookingPasseggeriPassengerInputRestylingBookingPasseggeriView_TextBoxPassengerAddressPhone_0_0")
    WebElement passengerOnePhoneField;

    @FindBy(id="BookingPasseggeriRestylingBookingPasseggeriView_ButtonSubmit")
    WebElement goPaymentButton;

    //Constructor:
    public PassengerDataPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    //Methods:
    public void writeNameOne (String nameOne) {
        passengerOneNameField.sendKeys(nameOne);
    }

    public void writeNameTwo (String nameTwo) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true); arguments[0].focus();", passengerTwoNameField);
        passengerTwoNameField.sendKeys(nameTwo);
    }

    public void writeLastNameOne (String lastNameOne){
        passengerOneLastNameField.sendKeys(lastNameOne);
    }

    public void writeLastNameTwo (String lastName) {
        passengerTwoLastNameField.sendKeys(lastName);
    }

    public void writeEmailOne (String emailOne){
        passengerOneEmailField.sendKeys(emailOne);
    }

    public void writeConfirmEmailOne (String emailOneC){
        passengerOneConfirmEmailField.sendKeys(emailOneC);
    }

    public void writeEmailTwo (String emailTwo) {
        passengerTwoEmailField.sendKeys(emailTwo);
    }

    public void writePhoneOne (String phone) {
        passengerOnePhoneField.sendKeys(phone);
    }

    public void goToPaymentPage () {
        goPaymentButton.click();
    }

    //Steps:

    public void fillPassengerOne (String nameOne, String lastNameOne, String emailOne,
                                     String emailOneC, String phone ) {
        writeNameOne(nameOne);
        writeLastNameOne(lastNameOne);
        writeEmailOne(emailOne);
        writeConfirmEmailOne(emailOneC);
        writePhoneOne(phone);
    }

    public void fillPassengerTwo (String nameTwo, String lastNameTwo, String  emailTwo) {
        writeNameTwo(nameTwo);
        writeLastNameTwo(lastNameTwo);
        writeEmailTwo(emailTwo);
        goToPaymentPage();
    }

}
