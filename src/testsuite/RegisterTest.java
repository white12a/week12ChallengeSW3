package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Random;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay() {
        clickOnElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));
        verifyText("Signing up is easy!",By.xpath("//div[@id='rightPanel']/h1"),"Error Message");
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() {
        clickOnElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));
        sendTextToElement(By.id("customer.firstName"),"lee");
        sendTextToElement(By.id("customer.lastName"),"lolo");
        sendTextToElement(By.id("customer.address.street"),"420, chor gali");
        sendTextToElement(By.id("customer.address.city"),"ulasnaga");
        sendTextToElement(By.id("customer.address.state"),"ohio");
        sendTextToElement(By.id("customer.address.state"),"357006");
        sendTextToElement(By.id("customer.phoneNumber"),"074204204200");
        sendTextToElement(By.id("customer.ssn"),"34567");
        WebElement emailField=driver.findElement(By.id("customer.username"));
        emailField.click();
        Random randomGenerator = new Random();// random generator class
        int randomInt = randomGenerator.nextInt(1000);
        emailField.sendKeys("username"+ randomInt +"@gmail.com");// creating random email generator
        sendTextToElement(By.id("customer.password"),"123456");
        sendTextToElement(By.id("repeatedPassword"),"123456");
        clickOnElement(By.xpath("//input[@value='Register']"));


        //driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a")).click();
        //driver.findElement(By.id("customer.firstName")).sendKeys("lee");
       // driver.findElement(By.id("customer.lastName")).sendKeys("lolo");
        //driver.findElement(By.id("customer.address.street")).sendKeys("420, chor gali");
        //driver.findElement(By.id("customer.address.city")).sendKeys("ulasnagar");
       // driver.findElement(By.id("customer.address.state")).sendKeys("ohio");
        //driver.findElement(By.id("customer.address.zipCode")).sendKeys("357006");
        //driver.findElement(By.id("customer.phoneNumber")).sendKeys("074204204200");
        //driver.findElement(By.id("customer.ssn")).sendKeys("34567");
        /*driver.findElement(By.id("customer.password")).sendKeys("123456");
        driver.findElement(By.id("repeatedPassword")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@value='Register']")).click();*/
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
