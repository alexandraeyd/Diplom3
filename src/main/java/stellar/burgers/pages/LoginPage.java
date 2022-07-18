package stellar.burgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellar.burgers.WebPageCommon;
import stellar.burgers.data.UserLoginData;

public class LoginPage extends WebPageCommon {

    public static final String URL = MAIN_PART_URL + "/login";

    //ToDo Replace all locators when ID or @data-testid will be added by the developers.
    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Email')]/following-sibling::input")
    public SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Пароль')]/following-sibling::input")
    public SelenideElement passwordInput;

    @FindBy(how = How.CLASS_NAME, using = "input__error")
    public SelenideElement passwordErrorMessage;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    public SelenideElement submitButton;

    @FindBy(how = How.XPATH, using = "//a[contains(@href, 'register')]")
    public SelenideElement registrationLink;

    @FindBy(how = How.XPATH, using = "//a[contains(@href, 'forgot-password')]")
    public SelenideElement forgotPasswordLink;

    @Step
    public void loginAsUser(UserLoginData user){
        emailInput.setValue(user.emailAddress);
        passwordInput.setValue(user.password);
        submitButton.click();
    }

    @Step
    public void loginAsUser(String email, String password){
        emailInput.setValue(email);
        passwordInput.setValue(password);
        submitButton.click();
    }

}