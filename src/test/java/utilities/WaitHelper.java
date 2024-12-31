package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper  {
    private WebDriverWait wait;

    // Constructor - Varsayılan bekleme süresi alır
    public WaitHelper(int timeoutInSeconds) {
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutInSeconds));
    }

    // Element görünür olana kadar bekler (WebElement ile)
    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Element tıklanabilir olana kadar bekler (WebElement ile)
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Belirli bir metni içeren bir element olana kadar bekler (By ile)
    public boolean waitForTextToBePresentInElement(WebElement element, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    // URL'in belirli bir metni içermesi için bekler
    public boolean waitForUrlContains(String urlFraction) {
        return wait.until(ExpectedConditions.urlContains(urlFraction));
    }

    // Sayfanın yüklenmesi tamamlanana kadar bekler
    public void waitForPageToLoad() {
        wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) Driver.getDriver())
                .executeScript("return document.readyState").equals("complete"));
    }

    // Bir alert (uyarı) görünene kadar bekler
    public void waitForAlertToBePresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
