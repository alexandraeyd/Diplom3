package stellar.burger.tests.personalAccount;

import io.qameta.allure.Step;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stellar.burger.AllTestsInit;
import stellar.burgers.data.UserRegistrationData;
import stellar.burgers.helpers.RandomValuesHelper;
import stellar.burgers.pages.*;

import static com.codeborne.selenide.Selenide.*;

//Переход в личный кабинет
//        Проверь переход по клику на «Личный кабинет».
//
//Переход из личного кабинета в конструктор
//        Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
//
//Выход из аккаунта
//        Проверь выход по кнопке «Выйти» в личном кабинете.

public class PersonalAccountTests extends AllTestsInit {

    private Log log = LogFactory.getLog(PersonalAccountTests.class);

    UserRegistrationData userWithValidRegistrationInfo = new UserRegistrationData(
            "Анна",
            "anna@yandex.ru" + RandomValuesHelper.generateRandomValueToMakeEmailUnique(),
            "AnnasRegistrationPassword");

    @BeforeEach
    public void registerUser(){
        registerUserAndLoginHimAfterAll(userWithValidRegistrationInfo);
    }

    @Test
    public void verifyPersonalAccountForRegisteredUser() {
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.checkOpened(personalAccountPage.URL);
    }

    @Test
    public void checkConstructorLinkFollowsToHomePageTest() {
        HeaderSection header = page(HeaderSection.class);
        header.builderLink.click();
        HomePage homePage = page(HomePage.class);
        homePage.checkOpened(homePage.URL + '/');
    }

    @Test
    public void checkExitFromPersonalAccountTest() {
        logOutFromCurrentUser();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkOpened(loginPage.URL);
    }

    @Step
    public void logOutFromCurrentUser() {
        HeaderSection header = page(HeaderSection.class);
        header.personalAccountLink.click();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        if(personalAccountPage.isOpened(PersonalAccountPage.URL)) {
            personalAccountPage.checkOpened(personalAccountPage.URL);
            personalAccountPage.exitButton.click();
        } else {
            log.info("There were no logged in user into the account.");
        }
    }

    @Step
    public void registerUserAndLoginHimAfterAll(UserRegistrationData userWithValidRegistrationInfo) {
        HomePage homePage = page(HomePage.class);
        homePage.registerUser(userWithValidRegistrationInfo);
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkOpened(loginPage.URL);
        loginPage.loginAsUser(userWithValidRegistrationInfo.emailAddress, userWithValidRegistrationInfo.password);
        HeaderSection header = page(HeaderSection.class);
        header.personalAccountLink.click();
    }

    @AfterEach
    public void logOutCurrentUserIfLoggedIn() {
        logOutFromCurrentUser();
        //Put object for the Garbage collector
        userWithValidRegistrationInfo = null;
    }
}
