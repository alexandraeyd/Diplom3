package stellar.burger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import stellar.burgers.pages.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class AllTestsInit {

    public static HomePage homePage = null;

    @BeforeAll
    public static void setup() {
        homePage = open(HomePage.URL, HomePage.class);
    }

}
