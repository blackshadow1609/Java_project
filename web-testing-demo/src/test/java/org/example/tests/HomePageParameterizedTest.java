package org.example.tests;

import org.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class HomePageParameterizedTest extends BaseTest {

    @ParameterizedTest(name = "h1 содержит ''{0}''")
    @ValueSource(strings = {"Selenium", "automates", "browsers"})
    @DisplayName("Проверка вхождения подстроки в заголовок h1 страницы")
    void headingContainsSubstring(String substring) {
        HomePage homePage = new HomePage(driver).open();
        String heading = homePage.getMainHeadingText();
        log.info("Проверяю: '{}' в '{}'", substring, heading);

        Assertions.assertTrue(heading.contains(substring),
                "Заголовок h1 '" + heading + "' должен содержать '" + substring + "'");
    }

    @ParameterizedTest(name = "URL = {0}, ожидаем часть = {1}")
    @CsvSource({
            "https://www.selenium.dev/,        selenium.dev",
            "https://www.selenium.dev/downloads/, downloads"
    })
    @DisplayName("После перехода URL содержит ожидаемую часть")
    void urlContainsExpectedPart(String url, String expectedPart) {
        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        log.info("URL: {}", currentUrl);

        Assertions.assertTrue(currentUrl.contains(expectedPart),
                "URL '" + currentUrl + "' должен содержать '" + expectedPart + "'");
    }
}