package org.example.tests;

import org.example.pages.DownloadPage;
import org.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DownloadPageTest extends BaseTest {

    @Test
    @DisplayName("Переход на страницу Downloads работает")
    void openDownloadsPage() {
        HomePage homePage = new HomePage(driver).open();
        DownloadPage downloadPage = homePage.openDownloads();

        String url = downloadPage.getCurrentUrl();
        log.info("URL страницы: {}", url);

        Assertions.assertTrue(url.contains("/downloads"),
                "URL должен содержать '/downloads', но был: " + url);
    }

    @Test
    @DisplayName("На странице Downloads отображается таблица загрузок")
    void downloadTableIsVisible() {
        DownloadPage downloadPage = new HomePage(driver).open().openDownloads();

        Assertions.assertTrue(downloadPage.isDownloadTableVisible(),
                "Таблица загрузок должна быть видна");
    }
}