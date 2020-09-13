package com.epam.pages.gmail;

import com.epam.decorator.elements.Button;
import com.epam.decorator.elements.Link;
import com.epam.pages.BasePage;
import com.epam.utils.Wait;
import com.epam.utils.providers.DriverWaitProvider;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends BasePage {
    @FindBy(xpath = "//*[@class=\"T-I T-I-KE L3\"]")
    private Button composeButton;

    @FindBy(xpath = "//*[@class='TK']/div[5]//a[@class='J-Ke n0']")
    private Link draftsFolder;

    @FindBy(xpath = "//*[@class=\"T-I T-I-KE L3\"]")
    private Link mailLogo;

    @FindBy(css = ".ae4.UI[gh='tl'] tr:nth-child(1)")
    private Link lastDraftMessage;

    @FindBy(css = ".ag.a8k")
    private Link sentMessageLink;

    public void waitOnMailLogoToBeClickable() {
        Wait.waitOnElementToBeClickable(mailLogo.getElement());
    }

    public void waitOnSentMessageLinkToBeClickable() {
        Wait.waitOnElementToBeClickable(sentMessageLink.getElement());
    }

    public void clickComposeButton() {
        composeButton.click();
    }

    public void clickDraftsFolder() {
        DriverWaitProvider.getInstance().ignoring(StaleElementReferenceException.class).until(driver -> {
            draftsFolder.click();
            return true;
        });
    }

    public void clickLastDraftMessage() {
        lastDraftMessage.click();
    }
}
