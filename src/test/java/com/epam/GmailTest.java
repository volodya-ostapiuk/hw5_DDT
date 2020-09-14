package com.epam;

import com.epam.business.GmailLogInBO;
import com.epam.business.GmailMessageBO;
import com.epam.model.MessageEntity;
import com.epam.utils.Constants;
import com.epam.utils.providers.DataObjectsProvider;
import com.epam.utils.providers.DriverProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import java.util.Iterator;
import java.util.stream.Stream;

public class GmailTest implements Constants {

    @BeforeMethod
    private void setUp() {
        DriverProvider.getInstance().get(BASE_URL);
    }

    @DataProvider(parallel = true)
    public Iterator<Object[]> usersLoginAndPassword() {
        return Stream.of(DataObjectsProvider.getUsers()).iterator();
    }

    /**
     * Enters email, enters password. Waits until new page will be opened and element will be clickable on it.
     * Checks does page title contains email. Creates new letter. Saves it as draft.
     * Checks if last draft letter contains needed emails, text and topic. Sendsmvn cmvn test saved letter.
     */
    @Test(dataProvider = "usersLoginAndPassword")
    private void verifyDraftFieldsAreSavedCorrectly(String userEmail, String userPassword, boolean expectedResult) {
        GmailLogInBO logInBO = new GmailLogInBO();
        Assert.assertEquals(logInBO.isLogIn(userEmail, userPassword), expectedResult, UNEXPECTED_LOGIN);

        if (expectedResult) {
            GmailMessageBO messageBO = new GmailMessageBO();
            messageBO.createDraftMessage(TEST_MESSAGE);
            messageBO.goToDraftsFolderAndClickLastDraftMessage();

            MessageEntity filledDraftMessage = messageBO.getDraftMessageEntity();
            Assert.assertEquals(filledDraftMessage.toString(), TEST_MESSAGE.toString(), WRONG_SAVED_DRAFT);

            messageBO.sendLastDraftMessage();
            Assert.assertTrue(messageBO.isDraftSent(), WRONG_DRAFT_SENT);
        }
    }

    @AfterMethod
    private void tearDown() {
        DriverProvider.quit();
    }
}
