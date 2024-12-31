package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Cookies;
import pages.HomePage;

import pages.JobOffersPage;
import utilities.Driver;
import utilities.WaitHelper;

import static org.junit.Assert.assertTrue;

public class JobOffers {
    WaitHelper waitHelper = new WaitHelper(10);
    JobOffersPage jobOffers = new JobOffersPage();
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    Cookies cookies = new Cookies();

    @Given("Click on the Job offers")
    public void click_on_the_job_offers() {
        homePage.JobOffres.click();
    }

    @When("Click on the Rechercher area")
    public void click_on_the_rechercher_area() {
        waitHelper.waitForPageToLoad();
        if (cookies.cookieJobOffres.isDisplayed()){
            cookies.cookieJobOffres.click();
        }
    jobOffers.rechercher.click();

    }

    @Then("Enter {string} in the search field and press the Enter key")
    public void enter_in_the_search_field_and_press_the_enter_key(String text) {
    actions.sendKeys(text)
            .sendKeys(Keys.ENTER )
            .perform();
    }

    @Then("Verify that search results are displayed")
    public void verify_that_search_results_are_displayed() {
        waitHelper.waitForElementToBeVisible(jobOffers.result);
        actions.scrollByAmount(0,500).perform();
        assertTrue(jobOffers.result.isDisplayed());

    }


}
