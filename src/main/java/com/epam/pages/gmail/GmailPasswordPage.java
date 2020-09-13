package com.epam.pages.gmail;

import com.epam.decorator.elements.Button;
import com.epam.decorator.elements.TextField;
import com.epam.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPasswordPage extends BasePage {
    @FindBy(name = "password")
    private TextField passwordInput;

    @FindBy(className = "VfPpkd-RLmnJb")
    private Button nextButton;

    @FindBy(css = "div.aCayab > div")
    private WebElement chosenProfileLink;

    public void enterPassword(String password) {
        passwordInput.typeAndEnter(password);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public String getChosenProfileLinkAttribute() {
        return chosenProfileLink.getAttribute("aria-label");
    }
}
