package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//a[@href='https://fortil.group/en/accueil-en/']")
    public WebElement logo;
    @FindBy(xpath = "//a[text()='Our model']")
    public WebElement OurModel;
    @FindBy(xpath = "//a[text()='Social responsibility']")
    public WebElement SocialResponsibility;
    @FindBy(xpath = "//a[text()='Key Issues']")
    public WebElement KeyIssues;
@FindBy(xpath = "//a[text()='Careers']")
    public WebElement Careers;
@FindBy(xpath = "//a[text()='Insights']")
    public WebElement Insights;
@FindBy(xpath = "//a[text()='Contact']")
    public WebElement Contact;
@FindBy(xpath = "//a[text()='Job offers']")
    public WebElement JobOffres;

    @FindBy(xpath = "//h2[text()='Engineering and technology consulting group']")
    public WebElement homePageText;

}
