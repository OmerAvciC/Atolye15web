package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static Utilities.GWD.driver;

public class Atolye15Steps {

    DialogContent dc = new DialogContent();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

    @Given("Navigate to Atolye15 Website and Verify that you are on the homepage")
    public void navigateToAtolye15WebsiteAndVerifyThatYouAreOnTheHomepage() {
        GWD.getDriver().get("https://www.atolye15.com/");
        GWD.getDriver().manage().window().maximize();

        Assert.assertTrue(dc.homepageVerify.isDisplayed());
    }


    @When("User should able to click events")
    public void Usershouldabletoclickevents(){

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Events']")));
        dc.findAndClick("eventsLink");


    }
    @And("User should able to click open positions")
    public void Usershouldabletoclickopenpositions() {

        dc.scrollToElement(dc.openPositions);
        dc.findAndClick("LearnMore");

    }

    @And("User should able to switch new window and click QA Engineer")
    public void UsershouldabletoswitchnewwindowandclickQAEngineer(){

        Set<String> windowsIdler=driver.getWindowHandles();

        for(String id: windowsIdler) {

            driver.switchTo().window(id);
            System.out.println(id + " - Title = " + driver.getTitle());
        }


        WebElement element = GWD.getDriver().findElement(By.cssSelector("#job-603483"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
        GWD.Bekle(2);
        Action action =  actions.moveToElement(element).doubleClick().build();
        action.perform();


    }


    @Then("User should able to verify Job description")
    public void userShouldAbleToVerifyJobDescription() {

        dc.findAndContainsText("description","description");
    }
}
