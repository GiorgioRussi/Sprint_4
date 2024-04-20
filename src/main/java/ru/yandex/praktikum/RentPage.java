package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentPage {
    private final WebDriver webDriver;
    private final By calendarInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentInputLocator = By.xpath("//div[text()='* Срок аренды']");
    private final By rentDaysLocator = By.xpath("//div[text()='сутки']");
    private final By rentPageOrderButtonLocator = By.xpath("//div[2]/div[3]/button[2]");
    private final By rentYesButtonLocator = By.xpath("//button[text()='Да']");
    public RentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillRentInfo(String date) {

        WebElement calendarInput = webDriver.findElement(calendarInputLocator);
        calendarInput.sendKeys(date, Keys.ENTER);

        WebElement rentInput = webDriver.findElement(rentInputLocator);
        rentInput.click();
        WebElement rentDays = webDriver.findElement(rentDaysLocator);
        rentDays.click();
    }
    public void clickRentPageOrderButton() {
        WebElement rentPageOrderButton = webDriver.findElement(rentPageOrderButtonLocator);
        rentPageOrderButton.click();
    }

    public void clickRentYesButton() {
        WebElement rentYesButton = webDriver.findElement(rentYesButtonLocator);
        rentYesButton.click();
    }


}
