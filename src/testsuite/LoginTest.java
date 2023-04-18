package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest { //Extended Class
    String baseUrl = "https://www.saucedemo.com/"; //Webpage Url


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }  //Set Up for Open Browser

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Input UserNameField
        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        usernameField.sendKeys("standard_user");
        //Input Password Field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("secret_sauce");
        // Click on Login Button
       WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Input UserName Field
        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        usernameField.sendKeys("standard_user");
        //Input Password Field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("secret_sauce");
        // Click on Login Button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        //Verify 6 products on page
        int expectedNumbers = 6;
        List<WebElement> actualElements =  driver.findElements(By.className("inventory_item"));
        int actualNumbers = actualElements.size();
        Assert.assertEquals("Does Match ", expectedNumbers,actualNumbers);

        driver.close();


    }
}