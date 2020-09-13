package com.epam.utils.providers;

import com.epam.utils.Constants;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWaitProvider implements Constants {
    private static WebDriverWait webDriverWait;

    private DriverWaitProvider() {
        webDriverWait = new WebDriverWait(DriverProvider.getInstance(), EXPLICIT_WAIT);
    }

    public static WebDriverWait getInstance() {
        if (webDriverWait == null) {
            new DriverWaitProvider();
        }
        return webDriverWait;
    }
}
