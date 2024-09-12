package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SingUpPage {

    WebDriver driver;
    WebDriverWait wait;




    //Locators:
    @FindBy(id = "CustomerInputRestylingCustomerAccountRegistrazioneView_TextBoxName")
    WebElement nameField;

    @FindBy(id = "CustomerInputRestylingCustomerAccountRegistrazioneView_TextBoxSurnameLegalName")
    WebElement surnameField;

    @FindBy(id = "CustomerInputRestylingCustomerAccountRegistrazioneView_TextBoxEmail")
    WebElement emailField;

    @FindBy(id = "CustomerInputRestylingCustomerAccountRegistrazioneView_confermaEmailField")
    WebElement confirmEmailField;

    @FindBy(id = "CustomerInputRestylingCustomerAccountRegistrazioneView_TextBoxPassword")
    WebElement passwordField;

    @FindBy(id = "CustomerInputRestylingCustomerAccountRegistrazioneView_TextBoxPasswordConfirm")
    WebElement confirmPasswordField;

    @FindBy(id = "CustomerInputRestylingCustomerAccountRegistrazioneView_TextBoxMobilePhone")
    WebElement mobilePhoneField;

    @FindBy(xpath = "(//input[@type='text'])[9]")
    WebElement provincesList;

    @FindBy(css = "#pageContainer > div > div > div:nth-child(3) > div > div.registration-form > div > div:nth-child(6) > div > div > div:nth-child(1) > div > div > span")
    WebElement province; // (Perugia)

    @FindBy(css = "div.fFhdHedbK9iZ5g3_5wQQ:nth-child(2) > div:nth-child(2) > input:nth-child(3)")
    WebElement citiesList;

    @FindBy(css = "#pageContainer > div > div > div:nth-child(3) > div > div.registration-form > div > div:nth-child(6) > div > div > div:nth-child(2) > div > div > span.v6IvYk_Ynw6C73kbWMcK.zSRbh3agMK1GTM3AAhxY")
    WebElement city; // (Preugia)

    @FindBy(id = "CustomerInputRestylingCustomerAccountRegistrazioneView_TextBoxDateofBirth")
    WebElement dateOfBirthField;

    @FindBy(css = ".ada-checkbox-body > div:nth-child(2) > div:nth-child(2) > label:nth-child(2)")
    WebElement acceptOffersCheckbox;

    @FindBy(id = "CustomerInputRestylingCustomerAccountRegistrazioneView_ButtonSubmit")
    WebElement submitButton;

    //Constructor:
    public SingUpPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    //Methods:

    public void writeName (String name) {
        nameField.sendKeys(name);
    }

    public void writeSurname (String surname) {
        surnameField.sendKeys(surname);
    }

    public void writeEmail (String email) {
        emailField.sendKeys(email);
    }
    public void writeConfirmEmail (String emailConfirmed) {
        confirmEmailField.sendKeys(emailConfirmed);
    }

    public void writePassword (String password) {
        passwordField.sendKeys(password);
    }

    public void writeConfirmPassword (String passwordConfirmed) {
        confirmPasswordField.sendKeys(passwordConfirmed);
    }

    public void writeMobilePhone (String mobilePhone) {
        mobilePhoneField.sendKeys(mobilePhone);
    }

    public void selectProvince () {
       // wait.until(ExpectedConditions.elementToBeClickable(provincesList))
        provincesList.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(province).click().perform();
        /*
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dropdown); */



    }

    public void selectCity () {
        citiesList.sendKeys("Perugia");
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(city));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dropdown);
    }

    public void writeDateOfBirth (String dateOfBirth) {
        Actions actions = new Actions(driver);
        actions.moveToElement(dateOfBirthField).sendKeys(dateOfBirth).perform();
    }

    public void acceptOffers () {
        acceptOffersCheckbox.click();
    }

    public void submitSingUp () {
        submitButton.click();
    }

    // Steps:

    public void fillUserForm (String name, String surename, String email, String emailConfirmed, String password,
                              String passwordConfirmed, String mobilePhone){
        writeName(name);
        writeSurname(surename);
        writeEmail(email);
        writeConfirmEmail(emailConfirmed);
        writePassword(password);
        writeConfirmPassword(passwordConfirmed);
        writeMobilePhone(mobilePhone);


    }

    public void acceptPromotions (String dateOfBirth) {

        writeDateOfBirth(dateOfBirth);
        selectProvince();
        selectCity();
       // acceptOffers();
    }




    }












