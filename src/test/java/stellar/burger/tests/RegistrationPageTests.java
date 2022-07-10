package stellar.burger.tests;

import org.junit.jupiter.api.Test;
import stellar.burger.AllTestsInit;
import stellar.burgers.helpers.RandomValuesHelper;
import stellar.burgers.pages.LoginPage;
import stellar.burgers.pages.UserRegistrationData;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPageTests extends AllTestsInit {

    private UserRegistrationData userWithValidRegistrationInfo = new UserRegistrationData(
            "Петр",
            "petr@yandex.ru" + RandomValuesHelper.generateRandomValueToMakeEmailUnique(),
            "UserRegistrationPassword");

    @Test
    public void successfulRegistrationTest() {
        homePage.registerUser(userWithValidRegistrationInfo);
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkOpened(loginPage.URL);
    }
}
