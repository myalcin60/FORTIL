package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Cookies {
    public Cookies(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "tarteaucitronPersonalize")
    public WebElement cookie;
    @FindBy (xpath = "//button[text()='Désactiver les cookies facultatifs']")
    public WebElement cookieJobOffres;


}
