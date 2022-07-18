package stellar.burger;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import stellar.burgers.pages.HomePage;
import stellar.burgers.pages.LoginPage;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageVerificationTests extends AllTestsInit {

    public static final String SHORT_VALUE_FOR_PASSWORD_TEXT = "short";
    public static final String INCORRECT_PASSWORD_ERROR_MESSAGE = "Некорректный пароль";

    @Test
    public void verifyIncorrectAmountOfSymbolsErrorMessageForPasswordInputTest() {
        HomePage homePage = page(HomePage.class);
        homePage.enterToAccountButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.passwordInput.setValue(SHORT_VALUE_FOR_PASSWORD_TEXT);
        loginPage.submitButton.click();
        SelenideElement passwordErrorMessage = loginPage.passwordErrorMessage;
        assertTrue(passwordErrorMessage.isDisplayed(),
                "Error message isn't displayed.");
        assertTrue(passwordErrorMessage.getText().contains(INCORRECT_PASSWORD_ERROR_MESSAGE),
                "Text of the error password message is not as expected:: " + passwordErrorMessage);
    }
}