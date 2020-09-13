package com.epam.decorator.elements;

import com.epam.decorator.BaseElement;
import com.epam.utils.Wait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextField extends BaseElement {
    private static Logger logger = LogManager.getLogger(TextField.class);

    public TextField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String text) {
        logger.info("Typing textField value: " + text);
        Wait.waitOnElementToBeVisible(webElement);
        webElement.sendKeys(text);
    }

    public void typeAndEnter(String text) {
        logger.info("Typing and entering textField value: " + text);
        Wait.waitOnElementToBeClickable(webElement);
        webElement.sendKeys(text);
        webElement.sendKeys(Keys.ENTER);
    }

    public void click() {
        logger.info("Clicking on textField with location: " + webElement.getLocation());
        Wait.waitOnElementToBeClickable(webElement);
        webElement.click();
    }

    public String getText() {
        logger.info("Getting text from textField with location: " + webElement.getLocation());
        return webElement.getText();
    }

    public String getAttribute(String attribute) {
        logger.info("Getting attribute from textField with location: " + webElement.getLocation());
        return webElement.getAttribute(attribute);
    }
}
