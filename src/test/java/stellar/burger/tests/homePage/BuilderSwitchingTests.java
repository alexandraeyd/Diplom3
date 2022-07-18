package stellar.burger.tests.homePage;

import org.junit.jupiter.api.Test;
import stellar.burger.AllTestsInit;
import stellar.burgers.pages.HomePage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Раздел «Конструктор»
//        Проверь, что работают переходы к разделам:
//        «Булки»,
//        «Соусы»,
//        «Начинки».

public class BuilderSwitchingTests extends AllTestsInit {

    @Test
    public void verifyBreadTabShowingListOfBreadsTest() {
        HomePage homePage = page(HomePage.class);
        homePage.breadTab.click();
        for (int i = 0; i < homePage.breadList.size(); i++) {
            homePage.scrollToBreadItem(i);
            assertTrue(homePage.isBreadItemsDisplayed(i),
                    "Bread Item for " + (i + 1) + " bread is not displayed");
        }
    }

    @Test
    public void verifySauceTabShowingListOfSaucesTest() {
        HomePage homePage = page(HomePage.class);
        homePage.sauceTab.click();
        for (int i = 0; i < homePage.sauceList.size(); i++) {
            homePage.scrollToSauceItem(i);
            assertTrue(homePage.isSauceItemsDisplayed(i),
                    "Sauce Item for " + (i + 1) + " sauce is not displayed");
        }
    }

    @Test
    public void verifyFillingsTabShowingListOfFillingsTest() {
        HomePage homePage = page(HomePage.class);
        homePage.fillingsTab.click();
        for (int i = 0; i < homePage.fillingsList.size(); i++) {
            homePage.scrollToFillingsItem(i);
            assertTrue(homePage.isFillingsItemsDisplayed(i),
                    "Fillings Item for " + (i + 1) + " fillings is not displayed");
        }
    }
}
