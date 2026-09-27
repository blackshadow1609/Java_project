package org.example.tests;

import org.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstSeleniumTest extends BaseTest {

    @Test
    @DisplayName("Главная страница Selenium содержит заголовок 'Selenium'")
    void homePageTitleContainsSelenium() {
        HomePage homePage = new HomePage(driver).open();

        String title = homePage.getTitle();
        System.out.println("Заголовок страницы: " + title);

        Assertions.assertTrue(title.contains("Selenium"),
                "Заголовок должен содержать 'Selenium', но был: " + title);
    }

    @Test
    @DisplayName("На главной странице есть заголовок h1")
    void homePageHasMainHeading() {
        HomePage homePage = new HomePage(driver).open();

        String heading = homePage.getMainHeadingText();
        System.out.println("Заголовок h1: " + heading);

        Assertions.assertFalse(heading.isBlank(),
                "Заголовок h1 не должен быть пустым");
    }
}