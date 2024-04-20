package ru.yandex.praktikum;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class FAQTest {

    private final int id;
    private final String answer;
    private WebDriver webDriver;

    public FAQTest(int id, String answer){
        this.id = id;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] textInQuestions(){
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
        };
    }

    @Before
    public void setup() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test

    public void checkTextInFAQ() {

        MainPage mainPage = new MainPage(webDriver);
        mainPage.closeCookiesWindow();
        mainPage.expandQuestionTitle(id);
        boolean checkAnswer = mainPage.checkAnswer(answer);
        assertTrue(checkAnswer);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
