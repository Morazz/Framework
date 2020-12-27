package page.abstractPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage
{
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public static WebElement waitElementToBeClickable(WebDriver driver, long time, WebElement element) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitElementIsDisplayed(WebDriver driver, long time, WebElement element) {
        return new WebDriverWait(driver, time)
                .until(driver -> element.isDisplayed());
    }

    public static WebElement waitElementVisibility(WebDriver driver, long time, WebElement element) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOf(element));
    }
}