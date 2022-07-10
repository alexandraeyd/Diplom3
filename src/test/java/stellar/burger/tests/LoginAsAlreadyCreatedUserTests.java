package stellar.burger.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stellar.burger.AllTestsInit;
import stellar.burgers.pages.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

//Вход
//        Проверь:
//        вход по кнопке «Войти в аккаунт» на главной,
//        вход через кнопку «Личный кабинет»,
//        вход через кнопку в форме регистрации,
//        вход через кнопку в форме восстановления пароля.

public class LoginAsAlreadyCreatedUserTests extends AllTestsInit {
    private static UserRegistrationData userWithValidRegistrationInfo = new UserRegistrationData(
            "Нина", "nina@yandex.ru", "NinasRegistrationPassword");


    static LoginPage loginPage = null;

    @BeforeEach
    public void loginAsValidUser() {
        HomePage homePage = page(HomePage.class);
        homePage.registerUser(userWithValidRegistrationInfo);
    }

    @Test
    public void loginByEnterToPersonalAccountLinkOnHomePageTest(){
        homePage = open(HomePage.URL, HomePage.class);
        HeaderSection header = page(HeaderSection.class);
        header.personalAccountLink.click();
        loginWithValidDataAndVerifySuccessOfGettingPersonalAccountPage();
    }

    @Test
    public void loginByEnterToAccountButtonOnHomePageTest(){
        homePage = open(HomePage.URL, HomePage.class);
        homePage.enterToAccountButton.click();
        loginWithValidDataAndVerifySuccessOfGettingPersonalAccountPage();
    }

    @Test
    public void loginByRegistrationFromButtonOnLoginPageTest(){
        homePage = open(HomePage.URL, HomePage.class);
        homePage.enterToAccountButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.registrationLink.click();
        RegistrationPage registerPage = page(RegistrationPage.class);
        registerPage.enterButton.click();
        loginWithValidDataAndVerifySuccessOfGettingPersonalAccountPage();
    }

    @Test
    public void loginByForgotPasswordButtonOnLoginPageTest(){
        homePage = open(HomePage.URL, HomePage.class);
        homePage.enterToAccountButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.forgotPasswordLink.click();
        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.enterButton.click();
        loginWithValidDataAndVerifySuccessOfGettingPersonalAccountPage();
    }

    public void loginWithValidDataAndVerifySuccessOfGettingPersonalAccountPage() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginAsUser(userWithValidRegistrationInfo.emailAddress, userWithValidRegistrationInfo.password);
        HeaderSection header = page(HeaderSection.class);
        header.personalAccountLink.click();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        webdriver().shouldHave(url(personalAccountPage.URL));
    }

    @AfterEach
    public void logoutFromValidUser() {
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.exitButton.click();
    }

}
