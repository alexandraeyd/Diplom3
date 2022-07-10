package stellar.burgers;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellar.burgers.pages.HeaderSection;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class WebPageCommon {

    public static String MAIN_PART_URL = "https://stellarburgers.nomoreparties.site";

    public void checkOpened(String url){
        webdriver().shouldHave(url(url));
    }
}
