package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    //Locators:
    @FindBy(css = "div[id='buttonExternalAccount'] div[class='open-panel-container'] img")
    WebElement paymentMethodCard;

    @FindBy(id = "BookingPagamentoRestylingBookingPagamentoView_BookingPagamentoPaymentInputRestylingBookingPagamentoView_TextBoxCC__AccountHolderName")
    WebElement nameField;

    @FindBy(id = "BookingPagamentoRestylingBookingPagamentoView_BookingPagamentoPaymentInputRestylingBookingPagamentoView_TextBoxACCTNO")
    WebElement cardNumberField;

    @FindBy(id = "BookingPagamentoRestylingBookingPagamentoView_BookingPagamentoPaymentInputRestylingBookingPagamentoView_DropDownListEXPDAT_Month")
    WebElement monthField;

    @FindBy(id = "BookingPagamentoRestylingBookingPagamentoView_BookingPagamentoPaymentInputRestylingBookingPagamentoView_DropDownListEXPDAT_Year")
    WebElement yearField;

    @FindBy(id = "BookingPagamentoRestylingBookingPagamentoView_BookingPagamentoPaymentInputRestylingBookingPagamentoView_TextBoxCC__VerificationCode")
    WebElement cvvField;

    @FindBy(className = "label-checkbox-black content-box-sizing")
    WebElement checkBoxTerms;

    @FindBy(id = "BookingPagamentoRestylingBookingPagamentoView_ButtonSubmit")
    WebElement submitPaymentButton;

    //Constructor:
    public PaymentPage (WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);

    }

    //Methods:

    public void clickPaymentMethodCard () {
        paymentMethodCard.click();
    }

    public void writeName (String name) {
        nameField.sendKeys(name);
    }

    public void writeCardNumber (String number) {
        cardNumberField.sendKeys(number);
    }

    public void writeMonthExp (String mm) {
        monthField.sendKeys(mm);
    }

    public void writeYear (String yyyy) {
        yearField.sendKeys(yyyy);
    }

    public void writeCVV (String cvv) {
        cvvField.sendKeys(cvv);
    }



    //Steps:

    public void fillCardData (String name, String number, String mm, String yyyy,
                              String cvv) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", paymentMethodCard);
        clickPaymentMethodCard();
        wait.until(ExpectedConditions.visibilityOf(nameField));
        writeName(name);
        writeCardNumber(number);
        writeMonthExp(mm);
        writeYear(yyyy);
        writeCVV(cvv);
    }

    public void submitPayment (){
        checkBoxTerms.click();
        submitPaymentButton.click();

    }




}
