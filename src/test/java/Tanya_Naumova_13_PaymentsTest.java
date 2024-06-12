import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith({SoftAssertsExtension.class})

public class Tanya_Naumova_13_PaymentsTest {
    @Test
    void Payment1() {
        Configuration.assertionMode = SOFT;

        SelenideLogger.addListener("allure", new AllureSelenide());
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        $("body > form > div:nth-child(1) > input[type=text]").setValue("100");
        sleep(5000);

//  2 способ:
//        ElementsCollection ec;
//        ec = $$("[name=sum]");
//        ec.get(0).setValue("100");

//  3 способ:
//        $(byXpath("//span[contains(text(),'рублей')]/../input")).setValue("100");

        $("[type=submit]").should(exist);
        $("[type=submit]").click();

        $("#sum").should(exist);
        $("#sum").should(text("100"));

        $("#currency").should(exist);
        $("#currency").should(text("рублей"));
    }

    @Test
    void Payment2() {
        Configuration.assertionMode = SOFT;

        SelenideLogger.addListener("allure", new AllureSelenide());
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        $("body > form > div:nth-child(3) > input[type=text]").setValue("100");
        sleep(5000);

//  2 способ:
//        ElementsCollection ec;
//        ec = $$("[name=sum]");
//        ec.get(1).setValue("100");

//  3 способ:
//        $(byXpath("//span[contains(text(),'долларов')]/../input")).setValue("100");

        $("[type=submit]").should(exist);
        $("[type=submit]").click();

        $("#sum").should(exist);
        $("#sum").should(text("100"));

        $("#currency").should(exist);
        $("#currency").should(text("долларов"));

    }

    @Test
    void Payment3() {
        Configuration.assertionMode = SOFT;

        SelenideLogger.addListener("allure", new AllureSelenide());
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        $("body > form > div:nth-child(5) > input[type=text]").setValue("100");
        sleep(5000);

// 2 способ:
//        ElementsCollection ec;
//        ec = $$("[name=sum]");
//        ec.get(2).setValue("100");

//  3 способ:
//        $(byXpath("//span[contains(text(),'евро')]/../input")).setValue("100");

        $("[type=submit]").should(exist);
        $("[type=submit]").click();

        $("#sum").should(exist);
        $("#sum").should(text("100"));

        $("#currency").should(exist);
        $("#currency").should(text("евро"));
    }
}




