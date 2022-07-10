package stellar.burgers.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellar.burgers.WebPageCommon;

public class PersonalAccountPage extends WebPageCommon {

    public static final String URL = MAIN_PART_URL + "/account/profile";

    @FindBy(how = How.XPATH, using = "//*[@class = 'Account_listItem__35dAP']//a[contains(text(), 'Профиль')]")
    public SelenideElement profileButton;

    @FindBy(how = How.XPATH, using = "//*[@class = 'Account_listItem__35dAP']//a[contains(text(), 'История заказов')]")
    public SelenideElement ordersHistoryButton;

    @FindBy(how = How.XPATH, using = "//*[@class = 'Account_listItem__35dAP']//button[contains(text(), 'Выход')]")
    public SelenideElement exitButton;






}
