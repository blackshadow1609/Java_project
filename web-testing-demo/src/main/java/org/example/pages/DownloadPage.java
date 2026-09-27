package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadPage extends BasePage {

    private static final By PAGE_HEADING = By.cssSelector("h1");
    private static final By DOWNLOAD_TABLE = By.cssSelector("table");

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeading() {
        return getText(PAGE_HEADING);
    }

    public boolean isDownloadTableVisible() {
        return waitForVisible(DOWNLOAD_TABLE).isDisplayed();
    }
}