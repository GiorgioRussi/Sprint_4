package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrderTest {

    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }


    @Test
    public void createOrder() {

        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickHeaderOrderButton();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillDataInfo("Георгий", "Тестов", "Москва", "Сокольники", "89998887766");
        orderPage.clickNextButton();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.fillRentInfo("11.11.11");
        rentPage.clickRentPageOrderButton();
        rentPage.clickRentYesButton();

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}