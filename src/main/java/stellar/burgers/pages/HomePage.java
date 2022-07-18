package stellar.burgers.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellar.burgers.WebPageCommon;
import stellar.burgers.data.UserRegistrationData;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends WebPageCommon {

    public static final String URL = MAIN_PART_URL;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    public SelenideElement enterToAccountButton;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Булки')]")
    public SelenideElement breadTab;

    @FindBy(how = How.XPATH, using = "//*[text() = 'Булки']/following-sibling::*[1]/a")
    public ElementsCollection breadList;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Соусы')]")
    public SelenideElement sauceTab;

    @FindBy(how = How.XPATH, using = "//*[text() = 'Соусы']/following-sibling::*[1]/a")
    public ElementsCollection sauceList;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Начинки')]")
    public SelenideElement fillingsTab;

    @FindBy(how = How.XPATH, using = "//*[text() = 'Начинки']/following-sibling::*[1]/a")
    public ElementsCollection fillingsList;

    @Step
    public void registerUser(UserRegistrationData user) {
        enterToAccountButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.registrationLink.click();
        RegistrationPage registerPage = page(RegistrationPage.class);
        registerPage.fillUserRegistrationForm(user);
        registerPage.registerButton.click();
    }

    @Step
    public void scrollToBreadItem(int numberInList) {
        breadList.get(numberInList).scrollIntoView(true);
    }

    @Step
    public boolean isBreadItemsDisplayed(int breadItemNumber) {
        return breadList.get(breadItemNumber).shouldBe(Condition.visible).isDisplayed();
    }

    @Step
    public void scrollToSauceItem(int numberInList) {
        sauceList.get(numberInList).scrollIntoView(true);
    }

    @Step
    public boolean isSauceItemsDisplayed(int sauceItemNumber) {
        return sauceList.get(sauceItemNumber).shouldBe(Condition.visible).isDisplayed();
    }

    @Step
    public void scrollToFillingsItem(int numberInList) {
        fillingsList.get(numberInList).scrollIntoView(true);
    }

    @Step
    public boolean isFillingsItemsDisplayed(int fillingsItemNumber) {
        return fillingsList.get(fillingsItemNumber).shouldBe(Condition.visible).isDisplayed();
    }

}
