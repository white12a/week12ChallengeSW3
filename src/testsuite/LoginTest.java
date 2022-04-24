package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessFullyWithValidCredentials() {
        sendTextToElement(By.xpath("//div[@id='loginPanel']/form/div[1]/input"),"markie123@gmail.com");
        sendTextToElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input"),"123456");
        clickOnElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input"));
        verifyText("Accounts Overview",By.xpath("//div[@id='rightPanel']/div/div/h1"),"Login Text Validation");
    }
    @Test
    public void verifyTheErrorMessage() {
        sendTextToElement(By.xpath("//div[@id='loginPanel']/form/div[1]/input"),"markie123@gmail.com");
        clickOnElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input"));
        verifyText("Please enter a username and password.",By.xpath("//div[@id='rightPanel']/p"),"Login Error message Validation");
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        sendTextToElement(By.xpath("//div[@id='loginPanel']/form/div[1]/input"),"markie123@gmail.com");
        sendTextToElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input"),"123456");
        clickOnElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input"));
        clickOnElement(By.xpath("//div[@id='leftPanel']/ul/li[8]/a"));
        verifyText("Customer Login",By.xpath("//div[@id='leftPanel']/h2"),"Customer Login Message");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
