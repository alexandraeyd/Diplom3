package stellar.burger;

import com.codeborne.selenide.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import stellar.burgers.pages.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class AllTestsInit {
    public static final String FIREFOX_BROWSER_NAME = "firefox";
    public static final String CHROME_BROWSER_NAME = "chrome";
    private static Log log = LogFactory.getLog(AllTestsInit.class);
    public static HomePage homePage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        setBrowserFromProperty();
        homePage = open(HomePage.URL, HomePage.class);
    }

    public static void setBrowserFromProperty(){
        //ToDo Take the browser from the properties.
        Configuration.browser = FIREFOX_BROWSER_NAME;
        if(Configuration.browser == FIREFOX_BROWSER_NAME) {
            //Default variant works well here.
        } else if(Configuration.browser == CHROME_BROWSER_NAME){
            //Default variant works well here.
        } else {
            log.error("Provided through the property browser " + Configuration.browser + " is unknown.");
        }
    }

    @AfterAll
    public static void quitBrowser() {
        if(driver != null) {
            driver.quit();
        }
    }

}
