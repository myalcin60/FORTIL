package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class JobOffersPage {
    public JobOffersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "query")
    public WebElement rechercher;
    @FindBy(xpath = "//span[text()='Ingénieur Testeur QA (H/F)']")
    public WebElement result;


}
