package com.epam.business;

import com.epam.pages.gmail.GmailHomePage;
import com.epam.pages.gmail.GmailLoginPage;
import com.epam.pages.gmail.GmailPasswordPage;
import com.epam.utils.providers.DriverProvider;
import com.epam.utils.providers.DriverWaitProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.NoSuchElementException;

public class GmailLogInBO {
    private GmailLoginPage loginPage;
    private GmailPasswordPage passwordPage;
    private GmailHomePage homePage;
    private static Logger logger = LogManager.getLogger(GmailLogInBO.class);

    public GmailLogInBO() {
        loginPage = new GmailLoginPage();
        passwordPage = new GmailPasswordPage();
        homePage = new GmailHomePage();
    }

    private void logIn(String userEmail, String userPassword) {
        logger.info("Authorising user with email: " + userEmail);
        loginPage.enterEmail(userEmail);
        logger.info("Authorising user with password: " + userPassword);
        passwordPage.enterPassword(userPassword);
    }

    public String getPageTitle() {
        logger.info("Getting page title that has Google logo");
        homePage.waitOnMailLogoToBeClickable();
        return DriverProvider.getInstance().getTitle().toLowerCase();
    }

    public boolean isLogIn(String userEmail, String userPassword) {
        logger.info("Checking is mail logo displayed to verify user log in");
        logIn(userEmail, userPassword);
        try {
            homePage.isMailLogoDisplayed();
        } catch (Exception exc) {
            return false;
        }
        return true;
    }
}
