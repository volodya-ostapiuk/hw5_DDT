package com.epam.business;

import com.epam.model.MessageEntity;
import com.epam.pages.gmail.GmailHomePage;
import com.epam.pages.gmail.GmailMessageFormPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GmailMessageBO {
    private GmailHomePage homePage;
    private GmailMessageFormPage messageFormPage;
    private static Logger logger = LogManager.getLogger(GmailMessageBO.class);

    public GmailMessageBO() {
        homePage = new GmailHomePage();
        messageFormPage = new GmailMessageFormPage();
    }

    public void createDraftMessage(MessageEntity message) {
        logger.info("Creating new message.");
        homePage.clickComposeButton();
        logger.info("Filling new message fields.");
        fillDraftMessage(message);
        logger.info("Saving and closing created message as draft.");
        messageFormPage.saveLetterAsDraftAndClose();
    }

    private void fillDraftMessage(MessageEntity message) {
        messageFormPage.enterReceiverEmail(message.getReceiver());
        messageFormPage.displayCcField();
        messageFormPage.displayBccField();
        messageFormPage.enterCcEmail(message.getCc());
        messageFormPage.enterBccEmail(message.getBcc());
        messageFormPage.enterTopic(message.getTopic());
        messageFormPage.enterLetterText(message.getLetterText());
    }

    public void goToDraftsFolderAndClickLastDraftMessage() {
        logger.info("Going to draft messages folder.");
        homePage.clickDraftsFolder();
        logger.info("Clicking on last saved draft message.");
        homePage.clickLastDraftMessage();
    }

    public MessageEntity getDraftMessageEntity() {
        logger.info("Getting filled fields from draft message.");
        String filledToField = messageFormPage.getEmailAttributeOfFilledToField();
        String filledCcField = messageFormPage.getEmailAttributeOfFilledCcField();
        String filledBccField = messageFormPage.getEmailAttributeOfFilledBccField();
        String filledTopicField = messageFormPage.getFilledTopicFieldText();
        String filledTextField = messageFormPage.getFilledLetterTextFieldText();
        logger.info("Creating new entity from filled draft message fields.");
        return new MessageEntity(filledTopicField, filledToField, filledCcField, filledBccField, filledTextField);
    }

    public void sendLastDraftMessage() {
        logger.info("Sending draft message.");
        messageFormPage.sendLetter();
        logger.info("Waiting on draft message sent link to be clickable.");
        homePage.waitOnSentMessageLinkToBeClickable();
    }
}
