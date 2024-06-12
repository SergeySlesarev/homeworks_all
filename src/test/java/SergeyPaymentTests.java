import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith({SoftAssertsExtension.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SergeyPaymentTests {
    @BeforeAll
    static void beforeAllProc ()  {
        Configuration.assertionMode = SOFT;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void beforeEachProc() {
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
    }

    @Test
    @Order(1)
    void positive_01_rub() {
        $(byXpath("//span[contains(text(),'рублей')]/parent::*/input")).setValue("100");
        $("[type=submit]").click();

        $("#sum").should(exist);
        $("#sum").should(text("100"));

        $("#currency").should(exist);
        $("#currency").should(text("рублей"));
    }

    @Test
    @Order(2)
    void positive_02_usd() {
        $(byXpath("//span[contains(text(),'долларов')]/parent::*/input")).setValue("100");
        $("[type=submit]").click();

        $("#sum").should(exist);
        $("#sum").should(text("100"));

        $("#currency").should(exist);
        $("#currency").should(text("долларов"));
    }

    @Test
    @Order(3)
    void positive_03_eur() {
        $(byXpath("//span[contains(text(),'евро')]/parent::*/input")).setValue("100");
        $("[type=submit]").click();

        $("#sum").should(exist);
        $("#sum").should(text("100"));

        $("#currency").should(exist);
        $("#currency").should(text("евро"));
    }
}