import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith({SoftAssertsExtension.class})

public class Tanya_Brichko_13_dzEnterNumber {
    @Test
    void enterRub(){
        Configuration.assertionMode = SOFT;
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        $("body > form > div:nth-child(1) > input[type=text]").setValue("100");
        $("[type=submit]").click();
        $("#sum").should(exist);
        $("#sum").should(text("100"));

        $("#currency").should(exist);
        $("#currency").should(text("рублей"));
    }
    @Test
    void enterDoll(){
        Configuration.assertionMode = SOFT;
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        $(byXpath("/html/body/form/div[2]/input")).setValue("100");
        sleep(2000);
        $(byXpath("//span[contains(text(),'долларов')]/parent::*/input")).setValue("200");
        sleep(2000);
        $("[type=submit]").click();
        $("#sum").should(exist);
        $("#sum").should(text("200"));

        $("#currency").should(exist);
        $("#currency").should(text("долларов"));
    }
    @Test
    void enterEuro(){
        Configuration.assertionMode = SOFT;
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        ElementsCollection ec;
        ec = $$("[name=sum]");
        System.out.println("Количество элементов: " + ec.size());
        SelenideElement se;
        se = ec.get(2);
        se.setValue("300");

        $("[type=submit]").click();
        $("#payment_info").should(text("300 евро"));
    }
}

