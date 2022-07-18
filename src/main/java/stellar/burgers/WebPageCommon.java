package stellar.burgers;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class WebPageCommon {

    public static String MAIN_PART_URL = "https://stellarburgers.nomoreparties.site";

    public void checkOpened(String url){
        webdriver().shouldHave(url(url));
    }

    public boolean isOpened(String url){
        return webdriver().object().getCurrentUrl().equals(url);
    }
}
