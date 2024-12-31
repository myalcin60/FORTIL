package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.Cookies;
import pages.HomePage;
import utilities.WaitHelper;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.driver;

public class LogoSteps {
    WaitHelper wait = new WaitHelper(10);
    HomePage homePage = new HomePage();
    Cookies cookies = new Cookies();

    @Then("User should see the site logo")
    public void user_should_see_the_site_logo() {
        wait.waitForElementToBeVisible(homePage.logo);
        assertTrue(homePage.logo.isDisplayed());
    }

    @Given("User is on the {string} page")
    public void userIsOnThePage(String pages) {
        switch (pages) {
            case "Our model":
                homePage.OurModel.click();

                break;

            case "Social responsibility":
                homePage.SocialResponsibility.click();
                break;
            case "Key Issues":
                homePage.KeyIssues.click();
                break;
            case "Careers":
                homePage.Careers.click();
                break;
            case "Insights":
                homePage.Insights.click();
                break;
            case "Contact":
                homePage.Contact.click();
                break;

            default:
                throw new IllegalArgumentException("Page not defined: " + pages);

        }
        wait.waitForElementToBeClickable(homePage.logo);
        assertTrue(homePage.logo.isDisplayed());
    }

    @Given("User is on the {string} {string} page")
    public void userIsOnThePage(String pageName, String pageUrl) {
        switch (pageName) {
            case "Our model":
                homePage.OurModel.click();
                assertEquals("The user is not on the correct page!", pageUrl,driver.getCurrentUrl());
                break;
            case "Social responsibility":
                homePage.SocialResponsibility.click();
                assertEquals("The user is not on the correct page!", pageUrl,driver.getCurrentUrl());
                break;
            case "Key Issues":
                homePage.KeyIssues.click();
                assertEquals("The user is not on the correct page!", pageUrl,driver.getCurrentUrl());
                break;
            case "Careers":
                homePage.Careers.click();
                assertEquals("The user is not on the correct page!", pageUrl,driver.getCurrentUrl());
                break;
            case "Insights":
                homePage.Insights.click();
                assertEquals("The user is not on the correct page!", pageUrl,driver.getCurrentUrl());
                break;
            case "Contact":
                homePage.Contact.click();
                assertEquals("The user is not on the correct page!", pageUrl,driver.getCurrentUrl());
                break;
            default:
                throw new IllegalArgumentException("Invalid page name: " + pageName);
        }
    }



    @When("User clicks on the site logo")
    public void user_clicks_on_the_site_logo() {
        wait.waitForPageToLoad();
        if (cookies.cookie.isDisplayed()) {
            cookies.cookie.click();
        }
        homePage.logo.click();
    }

    @Then("User shoulds be redirected to the homepage")
    public void user_shoulds_be_redirected_to_the_homepage() {
        wait.waitForPageToLoad();
        if (cookies.cookie.isDisplayed()) {
            cookies.cookie.click();
        }
        wait.waitForElementToBeVisible(homePage.homePageText);
        assertTrue(homePage.homePageText.isDisplayed());
    }


}
