package com.epam.decorator;

import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected WebElement webElement;

    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getElement() {
        return webElement;
    }
}
