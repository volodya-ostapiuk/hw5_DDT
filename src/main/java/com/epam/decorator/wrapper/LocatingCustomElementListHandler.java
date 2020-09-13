package com.epam.decorator.wrapper;

import com.epam.decorator.BaseElement;
import com.epam.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LocatingCustomElementListHandler implements InvocationHandler {
    private final ElementLocator locator;
    private final Class<BaseElement> clazz;

    public LocatingCustomElementListHandler(ElementLocator locator, Class<BaseElement> clazz) {
        this.locator = locator;
        this.clazz = clazz;
    }

    /**
     * Finds list of web elements and processes its every element and returns new list with elements of custom class
     */
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {

        List<WebElement> elements = locator.findElements();
        List<BaseElement> customs = new ArrayList<>();

        for (WebElement element : elements) {
            customs.add(WrapperFactory.createInstance(clazz, element));
        }
        try {
            return method.invoke(customs, objects);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
