package com.epam.business;

import com.epam.pages.gmail.GmailHomePage;
import com.epam.pages.gmail.GmailLoginPage;
import com.epam.pages.gmail.GmailPasswordPage;
import com.epam.utils.providers.DriverProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public void logIn(String userEmail, String userPassword) {
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
}
