package stellar.burgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellar.burgers.WebPageCommon;
import stellar.burgers.data.UserRegistrationData;

public class RegistrationPage extends WebPageCommon {

    public static final String URL = MAIN_PART_URL + "/login";

    @FindBy(how = How.XPATH, using = "//label[text()='Имя']")
    public SelenideElement nameLabel;

    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/../input")
    public SelenideElement nameInput;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']")
    public SelenideElement emailLabel;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']/../input")
    public SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']")
    public SelenideElement passwordLabel;

    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']/../input")
    public SelenideElement passwordInput;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    public SelenideElement registerButton;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    public SelenideElement enterButton;

    @Step
    public void fillUserRegistrationForm(UserRegistrationData user) {
        nameInput.setValue(user.nameOfUser);
        emailInput.setValue(user.emailAddress);
        passwordInput.setValue(user.password);
    }

    @Step
    public void fillAndSubmitUserRegistrationFrom(UserRegistrationData userRegistrationData){
        fillUserRegistrationForm(userRegistrationData);
        registerButton.click();
    }
}

