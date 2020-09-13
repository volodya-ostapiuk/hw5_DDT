package com.epam.decorator.wrapper;

import java.lang.reflect.*;
import java.util.List;

import com.epam.decorator.BaseElement;
import com.epam.decorator.wrapper.LocatingCustomElementListHandler;
import com.epam.decorator.wrapper.WrapperFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    public CustomFieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    /**
     * Method is called by factory for every field in class
     */
    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<BaseElement> decoratableClass = decoratableClass(field);
        // if field class is decoratable
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            if (List.class.isAssignableFrom(field.getType())) {
                return createList(loader, locator, decoratableClass);
            }
            // element
            return createElement(loader, locator, decoratableClass);
        }
        return super.decorate(loader, field);
    }

    /**
     * Returns decoratable class for field. Or null if class is not suitable for decorator
     */
    @SuppressWarnings("unchecked")
    private Class<BaseElement> decoratableClass(Field field) {

        Class<?> clazz = field.getType();

        if (List.class.isAssignableFrom(clazz)) {
            if (field.getAnnotation(FindBy.class) == null &&
                    field.getAnnotation(FindBys.class) == null) {
                return null;
            }
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return null;
            }
            clazz = (Class<?>) ((ParameterizedType) genericType).
                    getActualTypeArguments()[0];
        }

        if (BaseElement.class.isAssignableFrom(clazz)) {
            return (Class<BaseElement>) clazz;
        }
        else {
            return null;
        }
    }

    /**
     * Creates an element. Finds WebElement and sends it to a custom class
     */
    protected BaseElement createElement(ClassLoader loader, ElementLocator locator, Class<BaseElement> clazz) {
        return WrapperFactory.createInstance(clazz, proxyForLocator(loader, locator));
    }

    /**
     * Creates a list
     */
    @SuppressWarnings("unchecked")
    protected List<BaseElement> createList(ClassLoader loader, ElementLocator locator, Class<BaseElement> clazz) {
        InvocationHandler handler = new LocatingCustomElementListHandler(locator, clazz);
        return (List<BaseElement>) Proxy.newProxyInstance(
                loader, new Class[] {List.class}, handler);
    }
}
