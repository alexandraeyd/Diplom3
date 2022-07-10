package stellar.burger.tests;

import org.junit.jupiter.api.Test;
import stellar.burger.AllTestsInit;
import stellar.burgers.helpers.RandomValuesHelper;
import stellar.burgers.pages.*;

import static com.codeborne.selenide.Selenide.page;

//Переход в личный кабинет
//        Проверь переход по клику на «Личный кабинет».
//
//Переход из личного кабинета в конструктор
//        Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
//
//Выход из аккаунта
//        Проверь выход по кнопке «Выйти» в личном кабинете.

public class PersonalAccountTests extends AllTestsInit {

    @Test
    public void verifyPersonalAccountForRegisteredUser() {
        UserRegistrationData userWithValidRegistrationInfo = new UserRegistrationData(
                "Анна",
                "anna@yandex.ru" + RandomValuesHelper.generateRandomValueToMakeEmailUnique(),
                "AnnasRegistrationPassword");
        registerUserAndLoginHimAfterAll(userWithValidRegistrationInfo);
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.checkOpened(personalAccountPage.URL);
    }

    @Test
    public void checkConstructorLinkFollowsToHomePageTest() {
        UserRegistrationData userWithValidRegistrationInfo = new UserRegistrationData(
                "Рита",
                "rita@yandex.ru" + RandomValuesHelper.generateRandomValueToMakeEmailUnique(),
                "RitasRegistrationPassword");
        registerUserAndLoginHimAfterAll(userWithValidRegistrationInfo);
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        HeaderSection header = page(HeaderSection.class);
        header.builderLink.click();
        HomePage homePage = page(HomePage.class);
        homePage.checkOpened(homePage.URL + '/');
    }

    @Test
    public void checkExitFromPersonalAccountTest() {
        UserRegistrationData userWithValidRegistrationInfo = new UserRegistrationData(
                "Вера",
                "vera@yandex.ru" + RandomValuesHelper.generateRandomValueToMakeEmailUnique(),
                "VerasRegistrationPassword");
        registerUserAndLoginHimAfterAll(userWithValidRegistrationInfo);
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.exitButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkOpened(loginPage.URL);
    }

    public void registerUserAndLoginHimAfterAll(UserRegistrationData userWithValidRegistrationInfo) {
        HomePage homePage = page(HomePage.class);
        homePage.registerUser(userWithValidRegistrationInfo);
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkOpened(loginPage.URL);
        loginPage.loginAsUser(userWithValidRegistrationInfo.emailAddress, userWithValidRegistrationInfo.password);
        HeaderSection header = page(HeaderSection.class);
        header.personalAccountLink.click();
    }
}
