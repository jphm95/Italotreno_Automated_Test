package Tests;

import Pages.HomePage;
import Pages.SingUpPage;
import Utilities.ExcelData;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.IOException;

public class TestSingUp {

    WebDriver driver;

    String url = "https://www.italotreno.com/it";


    @BeforeSuite
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }
    @Test(priority = 1)
    public void openRegistrationForm () {

        HomePage home;
        home = new HomePage(driver);

        home.registerUser();

    }


    @Test(priority = 2)
    public void singUp () {

        SingUpPage signUp;
        signUp = new SingUpPage(driver);

        signUp.fillUserForm ("Juan","Pablo",
                             "juan@mail.com", "juan@mail.com",
                             "Password123&","Password123",
                             "123456789");





    }

    @Test(priority = 3)
    public void receivePromotions () {
        SingUpPage signUp;
        signUp = new SingUpPage(driver);

        signUp.acceptPromotions ("02/06/1995");
        //signUp.submitSingUp();

        }

/*
    @DataProvider(name = "User Data")
    public Object [][] getUserData() throws Exception {
        String excelName = "/Users/juanpablohernandezmonter/Downloads/Users.xlsx";
        String sheetName = "Users";

        return ExcelData.readExcel(excelName, sheetName);
*/








}
