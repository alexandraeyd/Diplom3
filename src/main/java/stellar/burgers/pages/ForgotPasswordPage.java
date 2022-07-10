package stellar.burgers.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellar.burgers.WebPageCommon;

public class ForgotPasswordPage extends WebPageCommon {

    public static final String URL = MAIN_PART_URL + "/forgot-password";

    @FindBy(how = How.XPATH, using = "//*[@class='input__container']//input[@type='text']")
    public SelenideElement emailInput;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    public SelenideElement recoveryButton;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    public SelenideElement enterButton;

}
