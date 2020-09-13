package com.epam.pages.gmail;

import com.epam.decorator.elements.Button;
import com.epam.decorator.elements.Link;
import com.epam.decorator.elements.TextField;
import com.epam.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailMessageFormPage extends BasePage {
    @FindBy(name = "to")
    private TextField toField;

    @FindBy(xpath = "//*[@class='aB gQ pE']")
    private Link ccAdditionLink;

    @FindBy(name = "cc")
    private TextField ccField;

    @FindBy(css = ".aB.gQ.pB")
    private Link bccAdditionLink;

    @FindBy(name = "bcc")
    private TextField bccField;

    @FindBy(name = "subjectbox")
    private TextField topicFiled;

    @FindBy(xpath = "//*[@class=\"Am Al editable LW-avf tS-tW\"]")
    private TextField letterTextFiled;

    @FindBy(css = ".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3")
    private Button sendButton;

    @FindBy(css = "img.Ha")
    private Button saveAsDraftAndCloseButton;

    @FindBy(xpath = "//*[@class=\"vN bfK a3q\"]")
    private TextField filledToField;

    @FindBy(xpath = "//*[@class=\"vN bfK a3p\"]")
    private TextField filledCcField;

    @FindBy(xpath = "//*[@class=\"vN bfK\"]")
    private TextField filledBccField;

    @FindBy(className = "aYF")
    private TextField filledTopicField;

    @FindBy(css = ".nH.Hd")
    private WebElement messageDialog;

    public void enterReceiverEmail(String email) {
        toField.sendKeys(email);
    }

    public void displayCcField() {
        ccAdditionLink.click();
    }

    public void enterCcEmail(String email) {
        ccField.sendKeys(email);
    }

    public void displayBccField() {
        bccAdditionLink.click();
    }

    public void enterBccEmail(String email) {
        bccField.sendKeys(email);
    }

    public void enterTopic(String topic) {
        topicFiled.sendKeys(topic);
    }

    public void enterLetterText(String text) {
        letterTextFiled.sendKeys(text);
    }

    public String getEmailAttributeOfFilledToField() {
        return filledToField.getAttribute("email");
    }

    public String getEmailAttributeOfFilledCcField() {
        return filledCcField.getAttribute("email");
    }

    public String getEmailAttributeOfFilledBccField() {
        return filledBccField.getAttribute("email");
    }

    public String getFilledTopicFieldText() {
        return filledTopicField.getText();
    }

    public String getFilledLetterTextFieldText() {
        return letterTextFiled.getText();
    }

    public void sendLetter() {
        sendButton.click();
    }

    public void saveLetterAsDraftAndClose() {
        saveAsDraftAndCloseButton.click();
    }
}
