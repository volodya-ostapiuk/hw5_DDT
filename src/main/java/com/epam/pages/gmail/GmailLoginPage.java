package com.epam.pages.gmail;

import com.epam.decorator.elements.Button;
import com.epam.decorator.elements.TextField;
import com.epam.pages.BasePage;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends BasePage {
    @FindBy(id = "identifierId")
    private TextField emailInput;

    @FindBy(className = "VfPpkd-RLmnJb")
    private Button nextButton;

    public void enterEmail(String email) {
        emailInput.typeAndEnter(email);
    }

    public void clickNextButton() {
        nextButton.click();
    }
}
