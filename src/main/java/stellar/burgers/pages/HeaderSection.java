package stellar.burgers.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenidePageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//@FindBy(how = How.CLASS_NAME, using = "AppHeader_header__X9aJA")
public class HeaderSection {

    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    public SelenideElement builderLink;

    @FindBy(how = How.XPATH, using = "//a[contains(@href, 'feed')]")
    public SelenideElement listOfOrdersLink;

    @FindBy(how = How.XPATH, using = "//a[contains(@href, 'account')]")
    public SelenideElement personalAccountLink;

}
