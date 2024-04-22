package ru.yandex.praktikum;

import org.openqa.selenium.*;

public class OrderPage {
    private final WebDriver webDriver;
    private final By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By subwayInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    private final String subwayLocator = "//div[text()='%s']";
    private final By phoneInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButtonLocator = By.xpath("//button[text()='Далее']");
    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillDataInfo(String name, String lastname, String address, String subway, String phone){

        WebElement nameInput = webDriver.findElement(nameInputLocator);
        nameInput.sendKeys(name);

        WebElement lastNameInput = webDriver.findElement(lastNameInputLocator);
        lastNameInput.sendKeys(lastname);

        WebElement addressInput = webDriver.findElement(addressInputLocator);
        addressInput.sendKeys(address);

        WebElement subwayInput = webDriver.findElement(subwayInputLocator);
        subwayInput.click();
        WebElement sokolnikiSubway = webDriver.findElement(By.xpath(String.format(subwayLocator, subway)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();",sokolnikiSubway);
        sokolnikiSubway.click();

        WebElement phoneInput = webDriver.findElement(phoneInputLocator);
        phoneInput.sendKeys(phone);
    }

    public void clickNextButton(){
        WebElement nextButton = webDriver.findElement(nextButtonLocator);
        nextButton.click();
    }
}
