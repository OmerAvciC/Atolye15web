package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//a[starts-with(@class,'c-hiring')]")
    public WebElement homepageVerify;

    @FindBy(xpath = "//a[text()='Events']")
    private WebElement eventsLink;

    @FindBy(xpath = "(//a[text()='Learn More'])[18]")
    private WebElement LearnMore;

    @FindBy(xpath = "//h4[text()='Open positions']")
    public WebElement openPositions;

    @FindBy(xpath ="//h2[contains(text(),'This is where productivity happens')]")
    public WebElement productivity;

    @FindBy(xpath ="//h3[contains(text(),'Job description')]")
    public WebElement description;



    WebElement myElement;


    public void findAndClick(String strElement) {

        switch (strElement) {
            case "eventsLink":
                myElement = eventsLink;
                break;
            case "LearnMore":
                myElement = LearnMore;
                break;



        }

        clickFunction(myElement);

    }

    public void findAndContainsText(String strElement, String text) {

        switch (strElement) {

            case "homepageVerify":
                myElement = homepageVerify;
                break;
            case "description":
                myElement = description;
                break;
            case "productivity":
                myElement = productivity;
                break;


        }

        verifyContainsText(myElement, text);
    }

}
