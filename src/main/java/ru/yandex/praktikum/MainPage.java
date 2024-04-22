package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver webDriver;
    private final By headerOrderButtonLocator = By.xpath("//div/div[1]/div[1]/div[2]/button[1]");
    private final By cookieButtonLocator = By.id("rcc-confirm-button");
    private final String questionLocator = "accordion__heading-%s";
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    public MainPage (WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void clickHeaderOrderButton(){
        WebElement headerOrderButton = webDriver.findElement(headerOrderButtonLocator);
        headerOrderButton.click();
    }

    public void closeCookiesWindow() {
        WebElement cookieWindowButton = webDriver.findElement(cookieButtonLocator);
        cookieWindowButton.click();
    }

    public void expandQuestionTitle(int id) {
       WebElement questionButton = webDriver.findElement(By.id(String.format(questionLocator, id)));
       ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();",questionButton);
       new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(questionButton));
        questionButton.click();
    }

    public boolean checkAnswer(String expectedAnswer) {
        WebElement answerText = webDriver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return answerText.isDisplayed();
    }



}

