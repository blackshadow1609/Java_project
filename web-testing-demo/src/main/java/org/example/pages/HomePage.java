package org.example.pages;

import org.example.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By MAIN_HEADING = By.cssSelector("h1");
    private static final By DOWNLOAD_LINK = By.linkText("Downloads");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(ConfigReader.get("base.url"));
        return this;
    }

    public String getMainHeadingText() {
        return getText(MAIN_HEADING);
    }

    public void clickDownloadLink() {
        click(DOWNLOAD_LINK);
    }
}