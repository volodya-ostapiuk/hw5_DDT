package com.epam.pages;

import com.epam.decorator.wrapper.CustomFieldDecorator;
import com.epam.utils.providers.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage() {
        webDriver = DriverProvider.getInstance();
        PageFactory.initElements(new CustomFieldDecorator(webDriver), this);
    }
}
