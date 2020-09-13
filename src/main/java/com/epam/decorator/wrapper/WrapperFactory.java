package com.epam.decorator.wrapper;

import com.epam.decorator.BaseElement;
import org.openqa.selenium.WebElement;

public class WrapperFactory {
    /**
     * Creates class instance by calling a constructor with WebElement as an argument
     */
    public static BaseElement createInstance(Class<BaseElement> clazz, WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class)
                    .newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                    "WebElement can't be represented as " + clazz
            );
        }
    }
}
