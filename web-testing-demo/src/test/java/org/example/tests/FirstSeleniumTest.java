package org.example.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("Открытие главной страницы и проверка заголовка")
    void openHomePageAndCheckTitle() {
        // Открываем тестовую страницу
        driver.get("https://www.selenium.dev/");

        String title = driver.getTitle();
        System.out.println("Заголовок страницы: " + title);
        Assertions.assertTrue(title.contains("Selenium"),
                "Заголовок должен содержать 'Selenium', но был: " + title);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}